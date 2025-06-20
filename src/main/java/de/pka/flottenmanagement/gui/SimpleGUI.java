package de.pka.flottenmanagement.gui;

import javax.swing.*;
import java.awt.*;

public class SimpleGUI extends JFrame {

    public SimpleGUI() {
        setTitle("Simple GUI Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Erstellen und Hinzufügen von beweglichen grafischen Objekten zur GUI
        ObjectPanel objectPanel1 = new ObjectPanel(Color.RED);
        ObjectPanel objectPanel2 = new ObjectPanel(Color.BLUE);
        ObjectPanel objectPanel3 = new ObjectPanel(Color.GREEN);

        setLayout(null); // WICHTIG: kein Layout-Manager!

        // Objektgrößen setzen
        objectPanel1.setBounds(0, 0, 50, 50);
        objectPanel2.setBounds(60, 0, 50, 50);
        objectPanel3.setBounds(120, 0, 50, 50);

        // Hinzufügen zur GUI
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
