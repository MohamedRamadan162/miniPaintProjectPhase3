 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FrontEnd;
import BackEnd.Oval;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import BackEnd.LineSegment;
import BackEnd.Rectangle;
import BackEnd.Shape;
import BackEnd.SublimeShape;
import BackEnd.Triangle;
import FrontEnd.LineProperties;
import FrontEnd.OvalProperties;
import FrontEnd.RectangleProperties;
import FrontEnd.TriangleProperties;
import java.awt.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JPanel;



/**
 *
 * @author moham
 */
public class DrawingFrame extends javax.swing.JFrame implements Node{
    private Node parent;
    

    /**
     * Creates new form NewJFrame
     */
    
    public DrawingFrame() {
        initComponents();
    }
    
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DrawingFramePanel = new javax.swing.JPanel();
        lineButton = new javax.swing.JButton();
        drawingPanel = new FrontEnd.DrawingPanel();
        ovalButton = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        rectangleButton = new javax.swing.JButton();
        triangleButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        colorButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        cloneButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vector Drawing App");

        lineButton.setLabel("Line segment");
        lineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineButtonActionPerformed(evt);
            }
        });

        drawingPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout drawingPanelLayout = new javax.swing.GroupLayout(drawingPanel);
        drawingPanel.setLayout(drawingPanelLayout);
        drawingPanelLayout.setHorizontalGroup(
            drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
        );
        drawingPanelLayout.setVerticalGroup(
            drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );

        ovalButton.setText("Oval");
        ovalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ovalButtonActionPerformed(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        rectangleButton.setText("Rectangle");
        rectangleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectangleButtonActionPerformed(evt);
            }
        });

        triangleButton.setText("Triangle");
        triangleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                triangleButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Select Shape");

        colorButton.setText("Colorize");
        colorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        cloneButton.setText("Clone");
        cloneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cloneButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DrawingFramePanelLayout = new javax.swing.GroupLayout(DrawingFramePanel);
        DrawingFramePanel.setLayout(DrawingFramePanelLayout);
        DrawingFramePanelLayout.setHorizontalGroup(
            DrawingFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DrawingFramePanelLayout.createSequentialGroup()
                .addGroup(DrawingFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DrawingFramePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(DrawingFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(DrawingFramePanelLayout.createSequentialGroup()
                                .addComponent(colorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(DrawingFramePanelLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(cloneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(DrawingFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(DrawingFramePanelLayout.createSequentialGroup()
                        .addComponent(lineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ovalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rectangleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(triangleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(drawingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        DrawingFramePanelLayout.setVerticalGroup(
            DrawingFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DrawingFramePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(DrawingFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lineButton)
                    .addComponent(rectangleButton)
                    .addComponent(triangleButton)
                    .addComponent(ovalButton))
                .addGroup(DrawingFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DrawingFramePanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DrawingFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(colorButton)
                            .addComponent(deleteButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cloneButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(DrawingFramePanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(drawingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        cloneButton.getAccessibleContext().setAccessibleName("cloneButton");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DrawingFramePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DrawingFramePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineButtonActionPerformed
        LineProperties lineProperties = new LineProperties();
        lineProperties.setParentNode(this);
        lineProperties.setVisible(true);
        this.setVisible(false);      
    }//GEN-LAST:event_lineButtonActionPerformed

    private void ovalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ovalButtonActionPerformed
        OvalProperties ovalProperties = new OvalProperties();
        ovalProperties.setParentNode(this);
        ovalProperties.setVisible(true);
        this.setVisible(false);   
    }//GEN-LAST:event_ovalButtonActionPerformed

    private void triangleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_triangleButtonActionPerformed
        TriangleProperties triangleProperties = new TriangleProperties();
        triangleProperties.setParentNode(this);
        triangleProperties.setVisible(true);
        this.setVisible(false); 
    }//GEN-LAST:event_triangleButtonActionPerformed

    private void colorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorButtonActionPerformed
        int index = jComboBox1.getSelectedIndex();
        Color borderColor = JColorChooser.showDialog(null, "Choose Border Color", Color.black);
        drawingPanel.getShapes()[index].setColor(borderColor);
        Color fillColor = JColorChooser.showDialog(null, "Choose fill Color", Color.black);
        drawingPanel.getShapes()[index].setFillColor(fillColor);
        drawingPanel.refresh(null);
    }//GEN-LAST:event_colorButtonActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int index = jComboBox1.getSelectedIndex();
        drawingPanel.removeShape(drawingPanel.getShapes()[index]);
        jComboBox1.removeItemAt(index);
        drawingPanel.getCorners().clear();
        drawingPanel.refresh(null);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void rectangleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectangleButtonActionPerformed
        RectangleProperties rectangleProperties = new RectangleProperties();
        rectangleProperties.setParentNode(this);
        rectangleProperties.setVisible(true);
        this.setVisible(false); 
    }//GEN-LAST:event_rectangleButtonActionPerformed

    private void cloneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cloneButtonActionPerformed
        try {
            int index = getCombobox().getSelectedIndex();
            SublimeShape oldShape = (SublimeShape)getPanel().getShapes()[index];
            drawingPanel.getCorners().clear();
            Shape ClonnedShape = (Shape) (oldShape).clone();
            getPanel().addShape(ClonnedShape);
            getCombobox().addItem(((SublimeShape)ClonnedShape).getName() + getPanel().getShapes().length);
            getPanel().refresh(null);
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(DrawingFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cloneButtonActionPerformed

    public static JComboBox<String> getCombobox(){
        return DrawingFrame.jComboBox1;
    }
    
     public static DrawingPanel getPanel(){
        return DrawingFrame.drawingPanel;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DrawingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DrawingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DrawingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DrawingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DrawingFrame drawingframe = new DrawingFrame();
                drawingframe.setVisible(true);
                drawingframe.setLocationRelativeTo(null);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DrawingFramePanel;
    private javax.swing.JButton cloneButton;
    private javax.swing.JButton colorButton;
    private javax.swing.JButton deleteButton;
    private static FrontEnd.DrawingPanel drawingPanel;
    private static javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton lineButton;
    private javax.swing.JButton ovalButton;
    private javax.swing.JButton rectangleButton;
    private javax.swing.JButton triangleButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setParentNode(Node node) {
        this.parent = node;
    }

    @Override
    public Node getParentNode() {
        
        return parent;
        
    }
}
