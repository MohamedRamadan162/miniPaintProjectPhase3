/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import static java.lang.Math.pow;

/**
 *
 * @author moham
 */
public class Circle extends SublimeShape{
    
    private int radius;
    private final String name = "Circle";

    public Circle(Point startingCordinates, int radius) {
        super(startingCordinates);
        this.radius = radius;
    }



    public int getRaduis() {
        return this.radius;
    }

    public void setRaduis(int raduis) {
        this.radius = raduis;
    }
   
    @Override
    public void draw(Graphics canvas) {
        Color oldCOlor = canvas.getColor();
        canvas.setColor(this.getColor());
        canvas.drawOval(this.getPosition().x, this.getPosition().y, 2*radius, 2*radius);
        canvas.setColor(this.getFillColor());
        canvas.fillOval(this.getPosition().x, this.getPosition().y, 2*radius, 2*radius);
        canvas.setColor(oldCOlor);
    }

    @Override
    public boolean contains(Point point) {
        Point center = new Point(this.getPosition().x + this.getRaduis(), this.getPosition().y + this.getRaduis());
        return pow(point.x - center.x, 2) + pow(point.y - center.y, 2) <= pow(radius, 2);
    }

    @Override
    public void moveTo(Point point) {
        int offsetX = point.x - this.getDraggingPoint().x;
        int offsetY = point.y - this.getDraggingPoint().y;
        this.setPosition(new Point(this.getPosition().x + offsetX, this.getPosition().y + offsetY));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void displayCorners() {
        
    }

    @Override
    public void removeCorners() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
