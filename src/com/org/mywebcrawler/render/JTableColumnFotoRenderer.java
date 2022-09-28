package com.org.mywebcrawler.render;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class JTableColumnFotoRenderer extends DefaultTableCellRenderer {

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    cell.setForeground(Color.WHITE);
    cell.setBackground(Color.WHITE);
    return cell;
  }
}
