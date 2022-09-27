package com.org.mywebcrawler.thread;

import com.org.mywebcrawler.entity.model.PlacarTableModel;
import com.org.mywebcrawler.extract.ExtractHtmlTimeBool;
import com.org.mywebcrawler.render.JTableButtonRenderer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ThreadBuscarPlacar implements Runnable {

  private boolean estaSuspensa;
  private boolean foiTerminada;
  private final Long timer;
  private final ExtractHtmlTimeBool extractHtmlTimeBool;
  private final PlacarTableModel placarTableModel;
  private final JTable table;
  private final JLabel lbAguarde;

  @SuppressWarnings("CallToThreadStartDuringObjectConstruction")
  public ThreadBuscarPlacar(Long timer, ExtractHtmlTimeBool extractHtmlTimeBool, JTable table, JLabel lbAguarde) {
    this.timer = timer;
    this.estaSuspensa = false;
    this.extractHtmlTimeBool = extractHtmlTimeBool;
    this.placarTableModel = new PlacarTableModel();
    this.table = table;
    this.lbAguarde = lbAguarde;
    new Thread(this, "ThreadBuscarPlacar").start();
  }

  @Override
  @SuppressWarnings("SleepWhileInLoop")
  public void run() {
    try {
      while (true) {
        Logger.getGlobal().log(Level.INFO, "ThreadBuscarPlacar");
        placarTableModel.limpar();
        placarTableModel.addListaDePlacar(this.extractHtmlTimeBool.listJogos());
        table.setModel(placarTableModel);
        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
        table.getColumnModel().getColumn(5).setCellRenderer(buttonRenderer);
        table.getColumnModel().getColumn(0).setPreferredWidth(300);
        table.getColumnModel().getColumn(1).setPreferredWidth(300);
        table.getColumnModel().getColumn(2).setPreferredWidth(50);
        table.getColumnModel().getColumn(3).setPreferredWidth(300);
        table.getColumnModel().getColumn(2).setPreferredWidth(50);
        table.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.lbAguarde.setVisible(false);
        Thread.sleep(timer);
        this.lbAguarde.setVisible(true);
        synchronized (this) {
          while (estaSuspensa) {
            wait();
          }
          if (this.foiTerminada) {
            break;
          }
        }
      }
    } catch (InterruptedException ex) {
      Logger.getGlobal().log(Level.SEVERE, null, ex);
    }
  }

  public void suspend() {
    this.estaSuspensa = true;
  }

  public synchronized void resume() {
    this.estaSuspensa = false;
    notify();
  }

  public synchronized void stop() {
    this.foiTerminada = true;
    notify();
  }
}
