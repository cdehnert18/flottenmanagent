package de.pka.flottenmanagement.gui;

import javax.swing.*;
import java.awt.*;

class ObjectPanel extends JPanel {
    private Color color; // Farbe des Objekts

    public ObjectPanel(Color color) {
        this.color = color;
        setPreferredSize(new Dimension(50, 50)); // Größe des Panels
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Objekt zeichnen
        g.setColor(color);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}