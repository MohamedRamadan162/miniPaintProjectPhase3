/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author moham
 */
public class Triangle extends SublimeShape{

    private Point p2;
    private Point p3;
    private final String name = "Line";
    
    public Triangle( Point startingCordinates, Point p2, Point p3) {
        super(startingCordinates);
        this.p2 = p2;
        this.p3 = p3;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }

   
    
    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }
    
    
    @Override
    public void draw(Graphics canvas) {
        Color oldCOlor = canvas.getColor();
        canvas.setColor(this.getColor());
        canvas.drawPolygon(new int[] {this.getPosition().x, this.getP2().x, this.getP3().x}, new int[] {this.getPosition().y, this.getP2().y, this.getP3().y}, 3);
        canvas.setColor(this.getFillColor());
        canvas.fillPolygon(new int[] {this.getPosition().x, this.getP2().x, this.getP3().x}, new int[] {this.getPosition().y, this.getP2().y, this.getP3().y}, 3);
        canvas.setColor(oldCOlor);
    }
    
    
    float sign (Point p1, Point p2, Point p3)
    {
        return (p1.x - p3.x) * (p2.y - p3.y) - (p2.x - p3.x) * (p1.y - p3.y);
    }
    
    
    @Override
    public boolean contains(Point point) {
        float d1, d2, d3;
        boolean has_neg, has_pos;

        d1 = sign(point, this.getPosition(), p2);
        d2 = sign(point, p2, p3);
        d3 = sign(point, p3, this.getPosition());

        has_neg = (d1 < 0) || (d2 < 0) || (d3 < 0);
        has_pos = (d1 > 0) || (d2 > 0) || (d3 > 0);

        return !(has_neg && has_pos);
    }

    
    @Override
    public void moveTo(Point point) {
        int offsetX = point.x - this.getDraggingPoint().x;
        int offsetY = point.y - this.getDraggingPoint().y;
        this.setPosition(new Point(this.getPosition().x + offsetX, this.getPosition().y + offsetY));
        this.setP2(new Point(this.getP2().x + offsetX, this.getP2().y + offsetY));
        this.setP3(new Point(this.getP3().x + offsetX, this.getP3().y + offsetY));
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
