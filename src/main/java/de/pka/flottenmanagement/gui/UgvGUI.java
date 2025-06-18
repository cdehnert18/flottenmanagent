package de.pka.flottenmanagement.gui;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.pka.flottenmanagement.model.Mission;
import de.pka.flottenmanagement.dto.Coordinates;

import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class UgvGUI implements Runnable {

    private  int id;
    private ObjectPanel objectPanel; // Das grafische Objekt
    private Long missionId;
    private int longitudeDest;
    private int latitudeDest;

    public UgvGUI(ObjectPanel objectPanel, int id) {
        this.objectPanel = objectPanel;
        this.id = id;
        this.missionId = null;

        getMission();
    }

    @Override
    public void run() {
        goToHome();
        performJob();
        goToHome();
    }

    private boolean moveTo(int x, int y) {
        Point currentPosition = objectPanel.getLocation();
        if (Math.abs(currentPosition.x - x) < 1 && Math.abs(currentPosition.y - y) < 1) {
            SwingUtilities.invokeLater(() -> objectPanel.setLocation(x, y));
            return true;
        }

        int dirX = x - currentPosition.x;
        int dirY = y - currentPosition.y;

        // Normalize
        double length = Math.sqrt(dirX * dirX + dirY * dirY);
        double normX = dirX / length;
        double normY = dirY / length;

        int step = 2; // or any small positive value
        int newX = currentPosition.x + (int)(normX * step);
        int newY = currentPosition.y + (int)(normY * step);

        SwingUtilities.invokeLater(() -> objectPanel.setLocation(newX, newY));

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }

    private void goToHome() {
        while (!moveTo(1,1)){};
    }

    private void performJob() {
        while(true) {
            boolean jobRunning = getNextJob(this.objectPanel.getX(),this.objectPanel.getY());
            if(!jobRunning) break;
            while (!moveTo(this.latitudeDest,this.longitudeDest)){};
        }
    }

    private Mission getMission () {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String uri = "http://localhost:8080/jobs?id=";
            stringBuilder.append(uri);
            stringBuilder.append(this.id);

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(stringBuilder.toString()))
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                try {
                    ObjectMapper mapper = new ObjectMapper();
                    Mission mission = mapper.readValue(response.body(), Mission.class);
                    this.missionId = mission.getId();
                    System.out.println("Meine Mission: " + mission.getShortName() + " " + mission.getDescription());
                    return mission;
                } catch (Exception e) {
                    e.printStackTrace();
                }


            } else {
                System.out.println("Fehler: Status " + response.statusCode());
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    private boolean getNextJob (int longitude, int langitude){
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String uri = "http://localhost:8080/jobs?missionId=";
            stringBuilder.append(uri);
            stringBuilder.append(this.missionId);
            stringBuilder.append(new String("&x="));
            stringBuilder.append((int) this.objectPanel.getLocation().getX());
            stringBuilder.append(new String("&y="));
            stringBuilder.append((int) this.objectPanel.getLocation().getY());

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(stringBuilder.toString()))
                    .PUT(HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                ObjectMapper mapper = new ObjectMapper();
                Coordinates coordinates = mapper.readValue(response.body(), Coordinates.class);
                this.latitudeDest = coordinates.x();
                this.longitudeDest = coordinates.y();
                return true;
            } else {
                System.out.println("Fehler: Status " + response.statusCode());
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}