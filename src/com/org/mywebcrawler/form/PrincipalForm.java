package com.org.mywebcrawler.form;

import java.util.Objects;
import javax.swing.ImageIcon;

public class PrincipalForm extends javax.swing.JFrame {

  private TimeBall timeBool;
  private CamaraFederal camaraFederal;

  public PrincipalForm() {
    initComponents();
    ImageIcon img = new ImageIcon(getClass().getResource("/com/org/mywebcrawler/icons/Web-Crawler-thum.jpg"));
    setIconImage(img.getImage());
    setLocationRelativeTo(null);
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jDesktopPane1 = new javax.swing.JDesktopPane();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    jMenuItem1 = new javax.swing.JMenuItem();
    jMenu2 = new javax.swing.JMenu();
    jMenuItem2 = new javax.swing.JMenuItem();
    jSeparator1 = new javax.swing.JPopupMenu.Separator();
    jMenuItem3 = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("MyWebCrawler");

    javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
    jDesktopPane1.setLayout(jDesktopPane1Layout);
    jDesktopPane1Layout.setHorizontalGroup(
      jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 1101, Short.MAX_VALUE)
    );
    jDesktopPane1Layout.setVerticalGroup(
      jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 547, Short.MAX_VALUE)
    );

    jMenu1.setText("Esporte");

    jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/org/mywebcrawler/icons/icons8-bola-de-futebol-2-20.png"))); // NOI18N
    jMenuItem1.setText("Futebol");
    jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem1ActionPerformed(evt);
      }
    });
    jMenu1.add(jMenuItem1);

    jMenuBar1.add(jMenu1);

    jMenu2.setText("Política");

    jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/org/mywebcrawler/icons/Câmara_dos_Deputados-icon-top.png"))); // NOI18N
    jMenuItem2.setText("Câmara Federal");
    jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem2ActionPerformed(evt);
      }
    });
    jMenu2.add(jMenuItem2);
    jMenu2.add(jSeparator1);

    jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/org/mywebcrawler/icons/Senado_Federal_do_Brasil.png"))); // NOI18N
    jMenuItem3.setText("Senado");
    jMenu2.add(jMenuItem3);

    jMenuBar1.add(jMenu2);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jDesktopPane1)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jDesktopPane1)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
      if (Objects.nonNull(timeBool)) {
        if (timeBool.isVisible()) {
          return;
        }
      }
      timeBool = new TimeBall();
      jDesktopPane1.remove(timeBool);
      jDesktopPane1.add(timeBool);
      timeBool.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

  private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    if (Objects.nonNull(camaraFederal)) {
      if (camaraFederal.isVisible()) {
        return;
      }
    }
    camaraFederal = new CamaraFederal();
    jDesktopPane1.remove(camaraFederal);
    jDesktopPane1.add(camaraFederal);
    camaraFederal.show();

  }//GEN-LAST:event_jMenuItem2ActionPerformed

  public static void main(String args[]) {
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(PrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    java.awt.EventQueue.invokeLater(() -> {
      new PrincipalForm().setVisible(true);
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JDesktopPane jDesktopPane1;
  private javax.swing.JMenu jMenu1;
  private javax.swing.JMenu jMenu2;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JMenuItem jMenuItem1;
  private javax.swing.JMenuItem jMenuItem2;
  private javax.swing.JMenuItem jMenuItem3;
  private javax.swing.JPopupMenu.Separator jSeparator1;
  // End of variables declaration//GEN-END:variables
}
