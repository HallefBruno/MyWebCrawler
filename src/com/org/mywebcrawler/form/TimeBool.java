package com.org.mywebcrawler.form;

import com.org.mywebcrawler.entity.LinkBusca;
import com.org.mywebcrawler.entity.model.LinkBuscaModel;
import com.org.mywebcrawler.entity.model.PlacarTableModel;
import com.org.mywebcrawler.render.LinksCellRenderer;
import javax.swing.JComboBox;

public class TimeBool extends javax.swing.JInternalFrame {
    
    private LinkBuscaModel modelLinks;
    private JComboBox<LinkBusca> comboBox;
    
    public TimeBool() {
        initComponents();
        popularCombobox();
        
        add(comboBox);
        comboBox.setBounds(4, 65, 390,28);
        
        PlacarTableModel model = new PlacarTableModel();
        tbResultado.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbAguarde = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        temporizador = new javax.swing.JSlider();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbResultado = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Time Bool");
        setToolTipText("Time Bool");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/com/org/mywebcrawler/icons/Web-Crawler-thum.jpg"))); // NOI18N

        jLabel1.setText("Link de busca:");

        lbAguarde.setText("Aguarde...");

        jToggleButton1.setText("Iniciar buscar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        temporizador.setMajorTickSpacing(30);
        temporizador.setMaximum(120);
        temporizador.setMinimum(30);
        temporizador.setMinorTickSpacing(30);
        temporizador.setPaintLabels(true);
        temporizador.setPaintTicks(true);
        temporizador.setToolTipText("");
        temporizador.setValue(30);

        tbResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbResultado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1055, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(416, 416, 416)
                                .addComponent(lbAguarde))
                            .addComponent(temporizador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbAguarde)
                .addGap(36, 36, 36)
                .addComponent(temporizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jToggleButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        LinkBusca buscaModel = ((LinkBusca) comboBox.getSelectedItem());
        System.out.println(buscaModel.getLabel());
        System.out.println(temporizador.getValue());
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    
    private void popularCombobox() {
        modelLinks = new LinkBuscaModel(new LinkBusca().list());
        comboBox = new JComboBox<>();
        comboBox.setModel(modelLinks);
        comboBox.setRenderer(new LinksCellRenderer());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lbAguarde;
    private javax.swing.JTable tbResultado;
    private javax.swing.JSlider temporizador;
    // End of variables declaration//GEN-END:variables

}
