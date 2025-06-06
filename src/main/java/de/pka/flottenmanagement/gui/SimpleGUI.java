package de.pka.flottenmanagement.gui;

import javax.swing.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.pka.flottenmanagement.model.Ugv;

import java.awt.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class SimpleGUI extends JFrame {

    public SimpleGUI() {
        setTitle("Simple GUI Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            String url = new String("http://localhost:8080/ugvs");

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).POST(HttpRequest.BodyPublishers.noBody()).build();

            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            int result = Integer.parseInt(response.body());
            System.out.println(result);

            url = "http://localhost:8080/ugvs";

            httpClient = HttpClient.newHttpClient();
            httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

            response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            result = Integer.parseInt(response.body());
            System.out.println(result);

            url = "http://localhost:8080/ugvs";

            httpClient = HttpClient.newHttpClient();
            httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

            response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            result = Integer.parseInt(response.body());
            System.out.println(result);

            url = "http://localhost:8080/ugvs/lowBattery";
            httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

            HttpResponse<String> res = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String json = res.body();

            ObjectMapper objectMapper = new ObjectMapper();

            ArrayList<Ugv> ugvs = objectMapper.readValue(json, new TypeReference<ArrayList<Ugv>>() {});

            // Ausgabe
            for (Ugv ugv : ugvs) {
                System.out.println(ugv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Erstellen und Hinzufügen von beweglichen grafischen Objekten zur GUI
        ObjectPanel objectPanel1 = new ObjectPanel(Color.RED);
        ObjectPanel objectPanel2 = new ObjectPanel(Color.BLUE);
        ObjectPanel objectPanel3 = new ObjectPanel(Color.GREEN);

        add(objectPanel1);
        add(objectPanel2);
        add(objectPanel3);

        // Starten der Bewegung der Objekte
        Thread thread1 = new Thread(new UgvGUI(objectPanel1, 1));
        thread1.start();
        Thread thread2 = new Thread(new UgvGUI(objectPanel2, 2));
        thread2.start();
        Thread thread3 = new Thread(new UgvGUI(objectPanel3, 3));
        thread3.start();


        // Layout der GUI aktualisieren
        setLayout(new FlowLayout());

        setVisible(true);
    }

    public static void main(String[] args) {
        // Starten der GUI-Anwendung
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SimpleGUI();
            }
        });
    }
}
