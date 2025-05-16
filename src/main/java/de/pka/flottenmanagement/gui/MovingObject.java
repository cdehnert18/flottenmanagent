package de.pka.flottenmanagement.gui;

import java.awt.*;
import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Klasse, die die Bewegungslogik des Objekts enthält
class MovingObject implements Runnable {
    private ObjectPanel objectPanel; // Das grafische Objekt

    public MovingObject(ObjectPanel objectPanel) {
        this.objectPanel = objectPanel;
    }

    @Override
    public void run() {
        int dx = 2; // Geschwindigkeit in x-Richtung
        int dy = 1; // Geschwindigkeit in y-Richtung

        try {
            String url = new String("http://localhost:8080/");

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            int result = Integer.parseInt(response.body());

            System.out.println("GOT: " + result);
        } catch (Exception e) {

        }
        while (true) {
            // Aktuelle Position des Objekts aktualisieren
            Point currentPosition = objectPanel.getLocation();
            int newX = currentPosition.x + dx;
            int newY = currentPosition.y + dy;

            // Überprüfen, ob das Objekt den Rand des Fensters erreicht hat, und die Richtung umkehren
            if (newX <= 0 || newX >= objectPanel.getParent().getWidth() - objectPanel.getWidth()) {
                dx = -dx;
            }
            if (newY <= 0 || newY >= objectPanel.getParent().getHeight() - objectPanel.getHeight()) {
                dy = -dy;
            }

            // Neue Position des Objekts setzen
            objectPanel.setLocation(newX, newY);

            // Kurze Pause, um die Bewegung zu verlangsamen
            try {
                Thread.sleep(10); // Wartezeit in Millisekunden (hier 10 Millisekunden)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}