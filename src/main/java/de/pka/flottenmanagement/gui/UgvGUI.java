package de.pka.flottenmanagement.gui;

import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class UgvGUI implements Runnable {

    private  int id;
    private ObjectPanel objectPanel; // Das grafische Objekt

    public UgvGUI(ObjectPanel objectPanel, int id) {
        this.objectPanel = objectPanel;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            String url = new String("http://localhost:8080/");

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            int result = Integer.parseInt(response.body());

        } catch (Exception e) {

        }
        while (!goToHome()) {};
        while (!moveTo(40, 40)) {};

    }

    private boolean moveTo(int x, int y) {
        Point currentPosition = objectPanel.getLocation();
        if (Math.abs(currentPosition.x - x) <= 5 && Math.abs(currentPosition.y - y) <= 5) {
            SwingUtilities.invokeLater(() -> objectPanel.setLocation(x, y));
            return true;
        }

        int dirX = x - currentPosition.x;
        int dirY = y - currentPosition.y;

        // Normalize
        double length = Math.sqrt(dirX * dirX + dirY * dirY);
        double normX = dirX / length;
        double normY = dirY / length;

        if (currentPosition.x + (int)normX <= 0 || currentPosition.x + (int)normX >= objectPanel.getParent().getWidth() - objectPanel.getWidth()) {
            normX = -normX;
        }
        if (currentPosition.y + (int)normY <= 0 || currentPosition.y + (int)normY >= objectPanel.getParent().getHeight() - objectPanel.getHeight()) {
            normY = -normY;
        }

        int step = 5; // or any small positive value
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

    private boolean goToHome() {
        return moveTo(0, 0);
    }
}