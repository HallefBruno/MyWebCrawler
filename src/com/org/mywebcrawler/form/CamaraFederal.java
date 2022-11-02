package com.org.mywebcrawler.form;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.mywebcrawler.converter.DeputadosConverter;
import com.org.mywebcrawler.converter.LegislaturaConverter;
import com.org.mywebcrawler.entity.Legislatura;
import com.org.mywebcrawler.entity.root.RootDeputados;
import com.org.mywebcrawler.entity.root.RootPartidos;
import com.org.mywebcrawler.entity.TodosDeputados;
import com.org.mywebcrawler.entity.model.LegislaturaModel;
import com.org.mywebcrawler.entity.model.TodosDeputadosModel;
import com.org.mywebcrawler.entity.root.RootLegislatura;
import com.org.mywebcrawler.exec.ExectRuntime;
import com.org.mywebcrawler.extract.ExtractHtmlAnoPorLegislacao;
import com.org.mywebcrawler.extract.ExtractHtmlSelectDeputados;
import com.org.mywebcrawler.message.Message;
import com.org.mywebcrawler.render.ComboboxDeputadosRenderer;
import com.org.mywebcrawler.render.ComboboxLegislaturaRender;
import com.org.mywebcrawler.render.JTableColumnFotoRenderer;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class CamaraFederal extends javax.swing.JInternalFrame {

  private DefaultTableModel defaultTableModel = new DefaultTableModel();
  private ExtractHtmlAnoPorLegislacao extractHtmlAnoPorLegislacao;
  private TableColumn columnUrlFoto;
  private TodosDeputadosModel deputadosModel;
  private JComboBox<TodosDeputados> comboboxTodosDeputados;
  private LegislaturaModel legislaturaModel;
  private JComboBox<Legislatura> comboBoxLegislatura;
  private final Message message;
  

  public CamaraFederal() {
    initComponents();
    message = Message.getInstance();
    partidosPoliticos();
    populeComboLegislatura();
    popularComboAno();
    AutoCompleteDecorator.decorate(comboBoxLegislatura, new LegislaturaConverter());
    AutoCompleteDecorator.decorate(cmbBoxAno);
    comboBoxLegislatura.addActionListener(new EventComboLegislatura());
    cmbBoxAno.addActionListener(new EventComboAno());
  }

  private void partidosPoliticos() {
    Thread thread = new Thread(() -> {
      try {
        String command = "curl -X GET https://dadosabertos.camara.leg.br/api/v2/partidos?itens=50&ordem=ASC&ordenarPor=sigla -H accept: application/json";
        Process process = Runtime.getRuntime().exec(command);
        try ( BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(), Charset.forName("UTF-8")))) {
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
        JOptionPane.showMessageDialog(rootPane, "Um erro ocorreu ao realizar a busca!");
      }
      lbMensagem.setVisible(false);
      lbSpinner.setVisible(false);
      cmbPartidos.setEnabled(true);
    });
    thread.start();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel2 = new javax.swing.JPanel();
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
    lbSpinner = new javax.swing.JLabel();
    lbMensagem = new javax.swing.JLabel();
    jPanel3 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    cmbBoxAno = new javax.swing.JComboBox<>();

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 100, Short.MAX_VALUE)
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 100, Short.MAX_VALUE)
    );

    setClosable(true);
    setIconifiable(true);
    setMaximizable(true);
    setResizable(true);
    setTitle("Câmara federal");
    setToolTipText("Câmara federal");
    setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/com/org/mywebcrawler/icons/Web-Crawler-thum.jpg"))); // NOI18N

    jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        jTabbedPane1StateChanged(evt);
      }
    });

    lbFotoDeputado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lbFotoDeputado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/org/mywebcrawler/icons/icons8-conta-de-teste-48.png"))); // NOI18N

    cmbPartidos.setEnabled(false);

    tfNomeDeputado.setToolTipText("");

    jLabel2.setText("Nome deputado:");

    jLabel3.setText("Sigla partido:");

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

    lbSpinner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lbSpinner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/org/mywebcrawler/icons/spinner.gif"))); // NOI18N
    lbSpinner.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

    lbMensagem.setForeground(new java.awt.Color(255, 255, 255));
    lbMensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lbMensagem.setText("Caregando...");
    lbMensagem.setOpaque(true);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(61, 61, 61)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(lbMensagem)
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbSpinner))))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(tfNomeDeputado)
              .addComponent(cmbPartidos, 0, 194, Short.MAX_VALUE)
              .addComponent(jLabel2)
              .addComponent(jLabel3)))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(lbFotoDeputado, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addComponent(lbFotoDeputado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jLabel3)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(cmbPartidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel2)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(tfNomeDeputado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jButton1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(lbSpinner)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(lbMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(38, 38, 38))
      .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
    );

    jTabbedPane1.addTab("Dados dos Deputados", jPanel1);

    jLabel1.setText("Deputados:");

    jLabel4.setText("Legislatura:");

    jLabel5.setText("Ano:");

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel4)
          .addComponent(jLabel1)
          .addComponent(jLabel5)
          .addComponent(cmbBoxAno, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(799, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addGap(19, 19, 19)
        .addComponent(jLabel4)
        .addGap(56, 56, 56)
        .addComponent(jLabel5)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(cmbBoxAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(38, 38, 38)
        .addComponent(jLabel1)
        .addContainerGap(295, Short.MAX_VALUE))
    );

    jTabbedPane1.addTab("Gasto por Deputado", jPanel3);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jTabbedPane1)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    lbMensagem.setVisible(true);
    lbSpinner.setVisible(true);
    String partido = cmbPartidos.getSelectedItem().toString();
    popularTable();
    Thread thread = new Thread(() -> {
      try {
        StringBuilder stringBuilder = new StringBuilder();

        if (Objects.nonNull(partido) && !partido.isBlank()) {
          stringBuilder.append("siglaPartido=").append(partido);
        }
        if (Objects.nonNull(tfNomeDeputado) && !tfNomeDeputado.getText().isBlank()) {
          stringBuilder.append("&nome=").append(tfNomeDeputado.getText());
        }
        String command = "curl -X GET https://dadosabertos.camara.leg.br/api/v2/deputados?" + stringBuilder.toString() + "&ordem=ASC&ordenarPor=nome accept: application/json";
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
        JOptionPane.showMessageDialog(rootPane, "Um erro ocorreu ao realizar a busca!");
      }
      lbMensagem.setVisible(false);
      lbSpinner.setVisible(false);
    });
    thread.start();
  }//GEN-LAST:event_jButton1ActionPerformed

  private void tbDeputadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDeputadoMouseClicked
    String selectedCellValue = (String) tbDeputado.getValueAt(tbDeputado.getSelectedRow(), 6);
    try {
      URL url = new URL(selectedCellValue);
      Image image = ImageIO.read(url);
      BufferedImage readImage = ImageIO.read(url);
      if (readImage.getHeight() > 200) {
        lbFotoDeputado.setIcon(new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(150, 200, Image.SCALE_DEFAULT)));
      } else {
        lbFotoDeputado.setIcon(new ImageIcon(image));
      }
    } catch (MalformedURLException ex) {
      Logger.getGlobal().log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getGlobal().log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_tbDeputadoMouseClicked
  
  private void populeComboDeputados(String legislatura, String ano) {
    List<TodosDeputados> deputadoses = new ExtractHtmlSelectDeputados(legislatura, ano).getListDeputados();
    deputadosModel = new TodosDeputadosModel(deputadoses);
    comboboxTodosDeputados = new JComboBox<>();
    comboboxTodosDeputados.setModel(deputadosModel);
    comboboxTodosDeputados.setRenderer(new ComboboxDeputadosRenderer());
    //AutoCompleteDecorator.decorate(comboboxTodosDeputados, new DeputadosConverter());
  }
  
  private void populeComboLegislatura() {
    RootLegislatura legislatura = new ExectRuntime<RootLegislatura>().httpProcess(RootLegislatura.class, "curl -X GET https://dadosabertos.camara.leg.br/api/v2/legislaturas?itens=4&ordem=DESC&ordenarPor=id -H accept: application/json");
    legislaturaModel = new LegislaturaModel(legislatura.getDados());
    comboBoxLegislatura = new JComboBox<>();
    comboBoxLegislatura.setModel(legislaturaModel);
    comboBoxLegislatura.setRenderer(new ComboboxLegislaturaRender());
  }
  
  private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
    if (evt.getSource() instanceof JTabbedPane) {
      JTabbedPane pane = (JTabbedPane) evt.getSource();
      if(pane.getSelectedIndex() == 1) {
        jPanel3.add(comboboxTodosDeputados);
        comboboxTodosDeputados.setBounds(4, 195, 420, 28);
        
        jPanel3.add(comboBoxLegislatura);
        comboBoxLegislatura.setBounds(4, 45, 143, 28);

      }
    }
  }//GEN-LAST:event_jTabbedPane1StateChanged

  private void popularTable() {
    defaultTableModel = (DefaultTableModel) tbDeputado.getModel();
    defaultTableModel.fireTableDataChanged();
    defaultTableModel.setRowCount(0);
    tbDeputado.setModel(defaultTableModel);
  }


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JComboBox<String> cmbBoxAno;
  private javax.swing.JComboBox<String> cmbPartidos;
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTabbedPane jTabbedPane1;
  private javax.swing.JLabel lbFotoDeputado;
  private javax.swing.JLabel lbMensagem;
  private javax.swing.JLabel lbSpinner;
  private javax.swing.JTable tbDeputado;
  private javax.swing.JTextField tfNomeDeputado;
  // End of variables declaration//GEN-END:variables
  
  private void popularComboAno() {
    Legislatura legislatura = (Legislatura) comboBoxLegislatura.getSelectedItem();
    extractHtmlAnoPorLegislacao = new ExtractHtmlAnoPorLegislacao(legislatura.getId().toString());
    cmbBoxAno.removeAllItems();
    extractHtmlAnoPorLegislacao.getAnos().forEach(ano -> {
      cmbBoxAno.addItem(ano.getAno());
    });
    String ano = (String) cmbBoxAno.getSelectedItem();
    populeComboDeputados(legislatura.getId().toString(), ano);
  }
  
  
  private class EventComboLegislatura implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      Thread thread = new Thread(() -> {
        JComboBox cb = (JComboBox) e.getSource();
        Legislatura legislatura = (Legislatura) cb.getSelectedItem();
        extractHtmlAnoPorLegislacao = new ExtractHtmlAnoPorLegislacao(legislatura.getId().toString());
        cmbBoxAno.removeAllItems();
        extractHtmlAnoPorLegislacao.getAnos().forEach(ano -> {
          cmbBoxAno.addItem(ano.getAno());
        });
        message.hideMessage();
      });
      thread.start();
      message.showMessage(rootPane);
    }
  }
  
  private class EventComboAno implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      Thread thread = new Thread(() -> {
        System.out.println("ok");
        JComboBox cb = (JComboBox) e.getSource();
        String ano = (String) cb.getSelectedItem();
        Legislatura legislatura = (Legislatura) comboBoxLegislatura.getSelectedItem();
        populeComboDeputados(legislatura.getId().toString(), ano);
        message.hideMessage();
      });
      thread.start();
      message.showMessage(rootPane);
    }
  }
}
