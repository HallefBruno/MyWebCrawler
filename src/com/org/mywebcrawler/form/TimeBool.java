package com.org.mywebcrawler.form;

import com.org.mywebcrawler.thread.ThreadBuscarPlacar;
import com.org.mywebcrawler.entity.LinkBusca;
import com.org.mywebcrawler.entity.model.LinkBuscaModel;
import com.org.mywebcrawler.extract.ExtractHtmlTimeBool;
import com.org.mywebcrawler.render.ComboboxRenderer;
import com.org.mywebcrawler.render.JTableButtonMouseListener;
import java.awt.Color;
import java.util.Objects;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class TimeBool extends javax.swing.JInternalFrame {

  private LinkBuscaModel modelLinks;
  private JComboBox<LinkBusca> comboBox;
  private ThreadBuscarPlacar buscarPlacar;

  public TimeBool() {
    initComponents();
    popularCombobox();

    add(comboBox);
    comboBox.setBounds(4, 65, 420, 28);

    tbResultado.getTableHeader().setReorderingAllowed(false);
    tbResultado.setRowHeight(30);
    tbResultado.addMouseListener(new JTableButtonMouseListener(tbResultado));
    tbResultado.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
    
    this.lbAguarde.setVisible(false);
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    lbAguarde = new javax.swing.JLabel();
    toggleButton = new javax.swing.JToggleButton();
    temporizador = new javax.swing.JSlider();
    jScrollPane1 = new javax.swing.JScrollPane();
    tbResultado = new javax.swing.JTable();

    setClosable(true);
    setIconifiable(true);
    setMaximizable(true);
    setResizable(true);
    setTitle("Live Football  Score");
    setToolTipText("Live Football  Score");
    setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/com/org/mywebcrawler/icons/Web-Crawler-thum.jpg"))); // NOI18N

    jLabel1.setText("Link de busca:");

    lbAguarde.setBackground(new java.awt.Color(0, 204, 204));
    lbAguarde.setForeground(new java.awt.Color(255, 255, 255));
    lbAguarde.setText("Aguarde...");
    lbAguarde.setOpaque(true);

    toggleButton.setBackground(new java.awt.Color(51, 102, 255));
    toggleButton.setForeground(new java.awt.Color(255, 255, 255));
    toggleButton.setText("Iniciar busca");
    toggleButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        toggleButtonActionPerformed(evt);
      }
    });

    temporizador.setMajorTickSpacing(30);
    temporizador.setMaximum(120);
    temporizador.setMinimum(30);
    temporizador.setMinorTickSpacing(30);
    temporizador.setPaintLabels(true);
    temporizador.setPaintTicks(true);
    temporizador.setSnapToTicks(true);
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
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel1)
              .addGroup(layout.createSequentialGroup()
                .addComponent(toggleButton)
                .addGap(18, 18, 18)
                .addComponent(lbAguarde))
              .addComponent(temporizador, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(47, 47, 47)
        .addComponent(jLabel1)
        .addGap(58, 58, 58)
        .addComponent(temporizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(33, 33, 33)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(toggleButton)
          .addComponent(lbAguarde))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void toggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleButtonActionPerformed

      LinkBusca buscaModel = ((LinkBusca) comboBox.getSelectedItem());
      long temp = (long) temporizador.getValue();
      
      this.lbAguarde.setVisible(true);
      
      if (toggleButton.isSelected()) {
        if (Objects.isNull(buscarPlacar)) {
          buscarPlacar = new ThreadBuscarPlacar(temp * 1000, new ExtractHtmlTimeBool(buscaModel.getUrl()), tbResultado, lbAguarde);
          comboBox.setEnabled(false);
          temporizador.setEnabled(false);
          toggleButton.setText("Parar busca");
          toggleButton.setBackground(new Color(255, 51, 51));
          toggleButton.setForeground(Color.WHITE);
        }
        return;
      }
      comboBox.setEnabled(true);
      temporizador.setEnabled(true);
      toggleButton.setText("Iniciar busca");
      toggleButton.setBackground(new Color(51, 102, 255));
      toggleButton.setForeground(Color.WHITE);
      this.lbAguarde.setVisible(false);
      buscarPlacar.stop();
      buscarPlacar = null;
    }//GEN-LAST:event_toggleButtonActionPerformed

  private void popularCombobox() {
    modelLinks = new LinkBuscaModel(new LinkBusca().listLinks());
    comboBox = new JComboBox<>();
    comboBox.setModel(modelLinks);
    comboBox.setRenderer(new ComboboxRenderer());
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jLabel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JLabel lbAguarde;
  private javax.swing.JTable tbResultado;
  private javax.swing.JSlider temporizador;
  private javax.swing.JToggleButton toggleButton;
  // End of variables declaration//GEN-END:variables

}
