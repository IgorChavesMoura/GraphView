/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model_control.Vertex;
import model_control.Graph;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author anderson
 */
public class FrameEdgeEdit extends javax.swing.JFrame {

    /**
     * Creates new form FrameEdgeEdit
     */
    
    Vertex u, v;
    public FrameEdgeEdit() {
        initComponents();
        getEnd();
        buttonHandling();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        text1 = new javax.swing.JTextField();
        text2 = new javax.swing.JTextField();
        labelWeight = new javax.swing.JLabel();
        textWeight = new javax.swing.JTextField();
        ok = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        setTitle("Edit Edge");
        setLocation(new java.awt.Point(500, 300));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("Choose the edge ends and edit");

        labelWeight.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        labelWeight.setText("Set new weight");

        ok.setText("Ok");

        cancel.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelWeight)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(text2)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(text1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(textWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ok)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelWeight)
                    .addComponent(textWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ok)
                    .addComponent(cancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public void getEnd(){
        SelectionHandler sh = SelectionHandler.getUnit();
        u = sh.getBuffer();
        if(u != null)
            text1.setText(u.getName());
    }
    
    public void analyze(){
        Frame f = Frame.getUnit();
        Graph graph = Graph.getUnit();
        String s1 = f.removeSpace(text1.getText()),
                s2 = f.removeSpace(text2.getText());
        Vertex x, y;
        int weight = 0;
        try{
            weight = SelectionEdgeHandler.getUnit().getInt(textWeight.getText());
            x = graph.getVertex(s1);
            y = graph.getVertex(s2);
            if(x != null && y != null){
                x.putWeight(y, weight);
                if(!graph.isDirected()){
                    y.putWeight(x, weight);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid values");
            }
        } catch (NumberFormatException ex){}
    }
    
    public void buttonHandling(){
        ButtonHandler handler = new ButtonHandler();
        ok.addActionListener(handler);
        cancel.addActionListener(handler);
    }

    private class ButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == ok){
                analyze();
            }
            Panel.getUnit().repaint();
            dispose();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelWeight;
    private javax.swing.JButton ok;
    private javax.swing.JTextField text1;
    private javax.swing.JTextField text2;
    private javax.swing.JTextField textWeight;
    // End of variables declaration//GEN-END:variables
}
