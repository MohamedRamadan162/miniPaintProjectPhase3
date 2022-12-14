 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FrontEnd;

import BackEnd.Oval;
import BackEnd.DrawingEngine;
import BackEnd.LineSegment;
import BackEnd.Rectangle;
import BackEnd.Shape;
import BackEnd.SublimeShape;
import BackEnd.Triangle;
import java.awt.Graphics;
import java.awt.List;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author moham
 */
public class DrawingPanel extends javax.swing.JPanel implements DrawingEngine, MouseListener, MouseMotionListener{

    /**
     * Creates new form DrawingPanel
     */
    private ArrayList<Shape> shapes;
    private ArrayList<Rectangle> corners;
    private SublimeShape draggedShape, JsonShape;
    private Rectangle draggedCorner;
    private boolean isDraggingCorner;
    private boolean isDraggingShape;
    
    
    public DrawingPanel() {
        initComponents();   
        shapes = new ArrayList<Shape>();
        corners = new ArrayList<Rectangle>();
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (Shape shape : shapes){
            shape.draw(g);
        }
        for(Rectangle corner : corners){
            corner.draw(g);
        }
    }
    @Override
    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }

    @Override
    public void removeShape(Shape shape) {
        this.shapes.remove(shape);
    }

    @Override
    public Shape[] getShapes() {
        return this.shapes.toArray(new Shape[0]);
    }

    public ArrayList<Rectangle> getCorners() {
        return corners;
    }
    
    @Override
    public void refresh(Graphics canvas) {
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point clickLocation = e.getPoint();
        for(int i = shapes.size() -1 ; i >= 0 ; i--){
            draggedShape = (SublimeShape)shapes.get(i);
            if(draggedShape.contains(clickLocation) && !draggedShape.isCornersOn()){
                corners.clear();
                draggedShape.displayCorners();
                DrawingFrame.getCombobox().setSelectedIndex(i);
                break;

            }
            else {
                if(draggedShape != null)
                {
                    draggedShape.removeCorners();
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point clickLocation = e.getPoint();
        
        for(int i = shapes.size() - 1; i >= 0; i--){
            
            if(((SublimeShape)shapes.get(i)).contains(e.getPoint()) && ((SublimeShape)shapes.get(i)).isCornersOn()){ 
                DrawingFrame.getCombobox().setSelectedIndex(shapes.indexOf(shapes.get(i)));
                draggedShape = (SublimeShape)shapes.get(i);
                isDraggingShape = true;
                draggedShape.setDraggingPoint(clickLocation);
                break;
            
            }
        }
        if(!getCorners().isEmpty()){
            for(int i = 0; i < corners.size() ; i++){
                if(getCorners().get(i).contains(clickLocation)){
                    draggedCorner = getCorners().get(i);
                    isDraggingCorner = true;
            }
        }      
        }
            
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isDraggingShape = false;
        draggedCorner = null;
        isDraggingCorner = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point dragLocation = e.getPoint();
        if(draggedShape != null && draggedShape.isCornersOn() && isDraggingShape && !isDraggingCorner){
            
            draggedShape.moveTo(dragLocation);
            draggedShape.setDraggingPoint(dragLocation);
            this.refresh(null);
        }
        else if(draggedCorner != null && draggedShape != null){
            draggedShape.resize(draggedCorner, dragLocation);
            refresh(null);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    public JSONObject getJsonArray()
    {
        JSONObject jObj = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for(Shape shape : shapes){
            JsonShape = (SublimeShape) shape;
            jsonArray.add(JsonShape.getJsonObject());
            jObj.put("shapes", jsonArray);
        }
        return jObj;
    }
    public void save(String fileName)
    {
        JSONObject JsonObject = getJsonArray();
        try ( FileWriter fileWriter = new FileWriter(new File(fileName))) {
                fileWriter.write(JsonObject.toJSONString());
                fileWriter.flush();
            }catch(IOException e){
                e.printStackTrace();
            }
    }
    public void load(String fileName)
    {
        shapes.clear();
        this.getCorners().clear();
        JSONParser jParser = new JSONParser();
        try {
                Object obj = jParser.parse(new FileReader(fileName));
                JSONObject jsonObject = (JSONObject) obj;
                JSONArray SHAPES = (JSONArray) jsonObject.get("shapes");
                for (int i = 0; i < SHAPES.size(); i++) {

                    JSONObject object = (JSONObject) SHAPES.get(i);
                    String jObjShapeName = (String) object.get("ShapeName");
                    if (jObjShapeName.equals("Line")) {
                        this.addShape(LineSegment.JsonToShape(object));
                        DrawingFrame.getCombobox().addItem("Line" + DrawingFrame.getPanel().getShapes().length);
                        
                    } else if (jObjShapeName.equals("Oval")) {
                        this.addShape(Oval.JsonToShape(object));
                        DrawingFrame.getCombobox().addItem("Oval" + DrawingFrame.getPanel().getShapes().length);

                    } else if (jObjShapeName.equals("Rectangle")) {
                        this.addShape(Rectangle.JsonToShape(object));
                        DrawingFrame.getCombobox().addItem("Rectangle" + DrawingFrame.getPanel().getShapes().length);

                    } else {
                        this.addShape(Triangle.JsonToShape(object));
                        DrawingFrame.getCombobox().addItem("Triangle" + DrawingFrame.getPanel().getShapes().length);

                    }

                    this.refresh(null);

                }
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "File Not Found");
                System.out.println("File Not Found");;
            } catch (org.json.simple.parser.ParseException e) {
                JOptionPane.showMessageDialog(null, "parse exception");
                System.out.println("parse exception");
                e.printStackTrace();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "IOException");
                System.out.println("IOException");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Exception");
                System.out.println("Exception");
                e.printStackTrace();
            }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
