package com.org.mywebcrawler.form;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.mywebcrawler.entity.RootDeputados;
import com.org.mywebcrawler.entity.RootPartidos;
import com.org.mywebcrawler.render.JTableColumnFotoRenderer;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class CamaraFederal extends javax.swing.JInternalFrame {
  
  private DefaultTableModel defaultTableModel = new DefaultTableModel();
  private TableColumn columnUrlFoto;
  
  public CamaraFederal() {
    initComponents();
    
    partidosPoliticos();
  }
  
  private void partidosPoliticos () {
    Thread thread = new Thread(() -> {
      try {
        String command = "curl -X GET https://dadosabertos.camara.leg.br/api/v2/partidos?itens=50&ordem=ASC&ordenarPor=sigla -H accept: application/json";
        Process process = Runtime.getRuntime().exec(command);
        try (BufferedReader in = new BufferedReader(new InputStreamReader( process.getInputStream(),Charset.forName("UTF-8")))) {
          String inputLine;
          StringBuilder content = new StringBuilder();
          while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
          }
          ObjectMapper objectMapper = new ObjectMapper();
          RootPartidos root = objectMapper.readValue(content.toString(), RootPartidos.class);
          root.getDados().forEach(partidos -> {
            cmbPartidos.addItem(partidos.getSigla());
          });
        }
      } catch (IOException ex) {
        Logger.getGlobal().log(Level.SEVERE, null, ex);
      }
      lbTeste.setVisible(false);
      cmbPartidos.setEnabled(true);
    });
    thread.start();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jTabbedPane1 = new javax.swing.JTabbedPane();
    jPanel1 = new javax.swing.JPanel();
    lbFotoDeputado = new javax.swing.JLabel();
    cmbPartidos = new javax.swing.JComboBox<>();
    tfNomeDeputado = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jButton1 = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    tbDeputado = new javax.swing.JTable();
    lbTeste = new javax.swing.JLabel();

    setClosable(true);
    setIconifiable(true);
    setMaximizable(true);
    setResizable(true);
    setTitle("Policy");
    setToolTipText("Policy");
    setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/com/org/mywebcrawler/icons/Web-Crawler-thum.jpg"))); // NOI18N

    lbFotoDeputado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lbFotoDeputado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/org/mywebcrawler/icons/icons8-conta-de-teste-48.png"))); // NOI18N

    cmbPartidos.setEnabled(false);

    tfNomeDeputado.setToolTipText("");

    jLabel2.setText("Nome:");

    jLabel3.setText("Sigla:");

    jButton1.setBackground(new java.awt.Color(51, 102, 255));
    jButton1.setForeground(new java.awt.Color(255, 255, 255));
    jButton1.setText("Pesquisar");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    tbDeputado.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Id", "Nome", "Sigla", "UF", "Legislatura", "Email", "Img"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false, false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    tbDeputado.getTableHeader().setReorderingAllowed(false);
    tbDeputado.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        tbDeputadoMouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(tbDeputado);
    if (tbDeputado.getColumnModel().getColumnCount() > 0) {
      tbDeputado.getColumnModel().getColumn(0).setResizable(false);
      tbDeputado.getColumnModel().getColumn(1).setResizable(false);
      tbDeputado.getColumnModel().getColumn(2).setResizable(false);
      tbDeputado.getColumnModel().getColumn(3).setResizable(false);
      tbDeputado.getColumnModel().getColumn(4).setResizable(false);
      tbDeputado.getColumnModel().getColumn(5).setResizable(false);
      tbDeputado.getColumnModel().getColumn(6).setResizable(false);
    }

    lbTeste.setBackground(new java.awt.Color(0, 204, 204));
    lbTeste.setForeground(new java.awt.Color(255, 255, 255));
    lbTeste.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lbTeste.setText("Caregando...");
    lbTeste.setOpaque(true);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel3)
            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tfNomeDeputado)
            .addComponent(cmbPartidos, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(lbFotoDeputado, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lbTeste))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addComponent(lbFotoDeputado, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(22, 22, 22)
        .addComponent(lbTeste)
        .addGap(18, 18, 18)
        .addComponent(jLabel3)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(cmbPartidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jLabel2)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(tfNomeDeputado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jButton1)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
    );

    jTabbedPane1.addTab("Dados dos Deputados", jPanel1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jTabbedPane1)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jTabbedPane1)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    lbTeste.setVisible(true);
    String partido = cmbPartidos.getSelectedItem().toString();
    popularTable();
    Thread thread = new Thread(() -> {
      try {
        StringBuilder stringBuilder = new StringBuilder();
        
        if(Objects.nonNull(partido) && !partido.isBlank()) {
          stringBuilder.append("siglaPartido=").append(partido);
        }
        if(Objects.nonNull(tfNomeDeputado) && !tfNomeDeputado.getText().isBlank()) {
          stringBuilder.append("&nome=").append(tfNomeDeputado.getText());
        }
        String command = "curl -X GET https://dadosabertos.camara.leg.br/api/v2/deputados?"+stringBuilder.toString()+"&ordem=ASC&ordenarPor=nome accept: application/json";
        Process process = Runtime.getRuntime().exec(command);
        try ( BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(), Charset.forName("UTF-8")))) {
          String inputLine;
          StringBuilder content = new StringBuilder();
          while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
          }
          ObjectMapper objectMapper = new ObjectMapper();
          RootDeputados root = objectMapper.readValue(content.toString(), RootDeputados.class);
          Object[] o = new Object[7];
          root.getDados().forEach(deputado -> {
            o[0] = deputado.getId();
            o[1] = deputado.getNome();
            o[2] = deputado.getSiglaPartido();
            o[3] = deputado.getSiglaUf();
            o[4] = deputado.getIdLegislatura();
            o[5] = deputado.getEmail();
            o[6] = deputado.getUrlFoto();
            defaultTableModel.addRow(o);
            tbDeputado.setModel(defaultTableModel);
            
            columnUrlFoto = tbDeputado.getColumnModel().getColumn(6);
            columnUrlFoto.setCellRenderer(new JTableColumnFotoRenderer());
            
          });
        }
      } catch (IOException ex) {
        Logger.getGlobal().log(Level.SEVERE, null, ex);
      }
      lbTeste.setVisible(false);
    });
    thread.start();
  }//GEN-LAST:event_jButton1ActionPerformed

  private void tbDeputadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDeputadoMouseClicked
    String selectedCellValue = (String) tbDeputado.getValueAt(tbDeputado.getSelectedRow() , 6);
    try {
      URL url = new URL(selectedCellValue);
      Image image = ImageIO.read(url);
      lbFotoDeputado.setIcon(new ImageIcon(image));
    } catch (MalformedURLException ex) {
      Logger.getGlobal().log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getGlobal().log(Level.SEVERE, null, ex);
    }
    
  }//GEN-LAST:event_tbDeputadoMouseClicked

  private void popularTable() {
    defaultTableModel = (DefaultTableModel) tbDeputado.getModel();
    defaultTableModel.fireTableDataChanged();
    defaultTableModel.setRowCount(0);
    tbDeputado.setModel(defaultTableModel);
  }
  
  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JComboBox<String> cmbPartidos;
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTabbedPane jTabbedPane1;
  private javax.swing.JLabel lbFotoDeputado;
  private javax.swing.JLabel lbTeste;
  private javax.swing.JTable tbDeputado;
  private javax.swing.JTextField tfNomeDeputado;
  // End of variables declaration//GEN-END:variables
}
