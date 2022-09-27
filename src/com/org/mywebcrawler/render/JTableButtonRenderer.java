package com.org.mywebcrawler.render;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

public class JTableButtonRenderer implements TableCellRenderer {

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    JButton button = (JButton) value;
    button.setVerticalAlignment(SwingConstants.CENTER);
    button.setToolTipText("Link");
    return button;
  }
}
