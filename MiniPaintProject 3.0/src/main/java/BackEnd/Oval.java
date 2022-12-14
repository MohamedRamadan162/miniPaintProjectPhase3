/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import FrontEnd.DrawingFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import static java.lang.Math.pow;
import org.json.simple.JSONObject;

/**
 *
 * @author moham
 */
public class Oval extends SublimeShape{
    
    private int verticalRadius;
    private int horizontalRadius;
    private int width;
    private int height;
    private final String name = "Oval";
    private Rectangle ULCorner;
    private Rectangle URCorner;
    private Rectangle LLCorner;
    private Rectangle LRCorner;

    public Oval( Point startingCordinates, int horizontalRadius, int verticalRadius) {
        super(startingCordinates);
        this.verticalRadius = verticalRadius;
        height = verticalRadius * 2;
        this.horizontalRadius = horizontalRadius;
        width = horizontalRadius * 2;
    }

    public int getVerticalRadius() {
        return verticalRadius;
    }

    public void setVerticalRadius(int verticalRadius) {
        this.verticalRadius = verticalRadius;
    }

    public int getHorizontalRadius() {
        return horizontalRadius;
    }

    public void setHorizontalRadius(int horizontalRadius) {
        this.horizontalRadius = horizontalRadius;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if(width <= 0)
        {
            this.width = 0;
            this.setPosition(new Point(ULCorner.getPosition().x - getCornerSize()/2, ULCorner.getPosition().y - getCornerSize()/2));
        }
        else
            this.width = width;
        this.horizontalRadius = this.width / 2;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if(height <= 0)
        {
            this.height = 0;
            this.setPosition(new Point(ULCorner.getPosition().x - getCornerSize()/2, ULCorner.getPosition().y - getCornerSize()/2));
        }
        else
            this.height = height;
        this.verticalRadius = this.height / 2;
    }

    @Override
    public void draw(Graphics canvas) {
        Color oldCOlor = canvas.getColor();
        canvas.setColor(this.getColor());
        canvas.drawOval(this.getPosition().x, this.getPosition().y, 2*horizontalRadius, 2*verticalRadius);
        canvas.setColor(this.getFillColor());
        canvas.fillOval(this.getPosition().x, this.getPosition().y, 2*horizontalRadius, 2*verticalRadius);
        canvas.setColor(oldCOlor);
    }

    @Override
    public boolean contains(Point point) {
        Point center = new Point(this.getPosition().x + this.getHorizontalRadius(), this.getPosition().y + this.getVerticalRadius());
        return (pow(point.x - center.x, 2) / pow(horizontalRadius, 2)) + (pow(point.y - center.y, 2) / pow(verticalRadius, 2)) <= 1;
    }

    @Override
    public void moveTo(Point point) {
        int offsetX = point.x - this.getDraggingPoint().x;
        int offsetY = point.y - this.getDraggingPoint().y;
        this.setPosition(new Point(this.getPosition().x + offsetX, this.getPosition().y + offsetY));
        this.ULCorner.setPosition(new Point(this.ULCorner.getPosition().x + offsetX, this.ULCorner.getPosition().y + offsetY));
        this.URCorner.setPosition(new Point(this.URCorner.getPosition().x + offsetX, this.URCorner.getPosition().y + offsetY));
        this.LLCorner.setPosition(new Point(this.LLCorner.getPosition().x + offsetX, this.LLCorner.getPosition().y + offsetY));
        this.LRCorner.setPosition(new Point(this.LRCorner.getPosition().x + offsetX, this.LRCorner.getPosition().y + offsetY));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void displayCorners() {
        this.setCornersOn(true);

        Point upperLeftCorner = new Point(getPosition().x - getCornerSize() / 2, getPosition().y - getCornerSize() / 2);
        Point upperRightCorner = new Point(getPosition().x + horizontalRadius * 2 - getCornerSize() / 2, getPosition().y - getCornerSize() / 2);
        Point lowerLeftCorner = new Point(getPosition().x - getCornerSize() / 2, getPosition().y + verticalRadius * 2 - getCornerSize() / 2);
        Point lowerRightCorner = new Point(getPosition().x + horizontalRadius * 2 - getCornerSize() / 2, getPosition().y + verticalRadius * 2 - getCornerSize() / 2);

        this.ULCorner = new Rectangle(upperLeftCorner, getCornerSize(), getCornerSize());
        this.URCorner = new Rectangle(upperRightCorner, getCornerSize(), getCornerSize());
        this.LLCorner = new Rectangle(lowerLeftCorner, getCornerSize(), getCornerSize());
        this.LRCorner = new Rectangle(lowerRightCorner, getCornerSize(), getCornerSize());

        DrawingFrame.getPanel().getCorners().add(ULCorner);
        DrawingFrame.getPanel().getCorners().add(URCorner);
        DrawingFrame.getPanel().getCorners().add(LLCorner);
        DrawingFrame.getPanel().getCorners().add(LRCorner);

        DrawingFrame.getPanel().refresh(null);
        
    }

    @Override
    public void removeCorners() {
        this.setCornersOn(false);

        DrawingFrame.getPanel().getCorners().remove(ULCorner);
        DrawingFrame.getPanel().getCorners().remove(URCorner);
        DrawingFrame.getPanel().getCorners().remove(LLCorner);
        DrawingFrame.getPanel().getCorners().remove(LRCorner);

        DrawingFrame.getPanel().refresh(null);
    }

    @Override
    public void resize(Rectangle corner, Point point) {
        int index = DrawingFrame.getPanel().getCorners().indexOf(corner);
        int xdiff = point.x - corner.getPosition().x - getCornerSize()/2;
        int ydiff = point.y - corner.getPosition().y - getCornerSize()/2;

        switch (index) {
            case 0: // upper left corner
                setWidth(getWidth() - xdiff);
                setHeight(getHeight() - ydiff);
                setPosition(point);

                resetCorners();
                break;
            case 1: // upper right corner
                setWidth(getWidth() + xdiff);
                setHeight(getHeight() - ydiff);
                setPosition(new Point(getPosition().x, point.y));

                resetCorners();
                break;
            case 2: // bottom left corner
                setWidth(getWidth() - xdiff);
                setHeight(getHeight() + ydiff);
                setPosition(new Point(point.x, getPosition().y));

                resetCorners();
                break;
            case 3: // bottom right corner
                setWidth(getWidth() + xdiff);
                setHeight(getHeight() + ydiff);


                resetCorners();
                break;
            default:
                throw new AssertionError();
        }
    }

    public void resetCorners() {
        this.ULCorner.setPosition(new Point(this.getPosition().x - getCornerSize() / 2, this.getPosition().y - getCornerSize() / 2));
        this.LLCorner.setPosition(new Point(this.getPosition().x - getCornerSize() / 2, this.getPosition().y + (this.height - getCornerSize() / 2)));
        this.URCorner.setPosition(new Point(this.getPosition().x + (this.width - getCornerSize() / 2), this.getPosition().y - getCornerSize() / 2));
        this.LRCorner.setPosition(new Point(this.getPosition().x + (this.width - getCornerSize() / 2), this.getPosition().y + (this.height - getCornerSize() / 2)));
    }
    @Override
    public JSONObject getJsonObject() {
        JSONObject jObj = super.getJsonObject();
        jObj.put("horizontalRadius", getHorizontalRadius());
        jObj.put("verticalRadius", getVerticalRadius());
        jObj.put("ShapeName", getName());
        return jObj;
    }
    public static Oval JsonToShape(JSONObject jObj)
    {
        JSONObject positionJSON = (JSONObject) jObj.get("position");
        Point position = new Point(Integer.parseInt(positionJSON.get("x").toString()), Integer.parseInt(positionJSON.get("y").toString()));
        int horizontalRadius = Integer.parseInt(jObj.get("horizontalRadius").toString());
        int verticalRadius = Integer.parseInt((String) jObj.get("verticalRadius").toString());
        Oval oval = new Oval(position, horizontalRadius, verticalRadius);
        int colorRGB = Integer.parseInt(jObj.get("borderColor").toString());
        int fillColorRGB = Integer.parseInt(jObj.get("fillColor").toString());
        oval.setColor(new Color(colorRGB, true));
        oval.setFillColor(new Color(fillColorRGB, true));
        return oval;
    }
    
}
