package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class DrawStar extends JPanel {

    private int x = 250;     // координата x центра звезды
    private int y = 250;     // координата y центра звезды
    private int outerRadius = 40;     // внешний радиус звезды
    private int innerRadius = 20;     // внутренний радиус звезды
    private int numRays = 5;     // количество лучей звезды

    public DrawStar(int x, int y, int outerRadius, int innerRadius, int numRays) {     // конструктор для класса
        this.x = x;
        this.y = y;
        this.outerRadius = outerRadius;
        this.innerRadius = innerRadius;
        this.numRays = numRays;
    }

    protected void paintComponent(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setPaint(Color.BLACK);
        g.fill(drawStar());
    }

    private Shape drawStar() {     // метод рисования звезды
        Path2D p = new Path2D.Double();
        Star newStar = new Star(x, y, innerRadius, outerRadius, numRays);
        double angle0 = Math.PI / newStar.numRays();     // угол между лучами / 2
        for (int i = 0; i < newStar.numRays() * 2; i++) {
            double angle = i * angle0;     // угол между прямой, проходящей через точку, и осью координат
            double cos = Math.cos(angle);
            double sin = Math.sin(angle);
            double x0;
            double y0;
            if ((i % 2) == 0) {     // если i - чётное, то точка находится на внешнем радиусе, и к ней ведётся линия, и наоборот
                x0 = cos * newStar.outerRadius();
                y0 = sin * newStar.outerRadius();
            } else {
                x0 = cos * newStar.innerRadius();
                y0 = sin * newStar.innerRadius();
            }
            if (i == 0) {
                p.moveTo(newStar.x() + x0, newStar.y() + y0);
            } else {
                p.lineTo(newStar.x() + x0, newStar.y() + y0);
            }
        }
        p.closePath();
        return p;
    }
}
