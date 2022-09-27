package com.org.mywebcrawler.render;

import com.org.mywebcrawler.entity.LinkBusca;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class ComboboxRenderer extends DefaultListCellRenderer {

  @Override
  public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    if (value instanceof LinkBusca) {
      LinkBusca estado = (LinkBusca) value;
      setText(estado.getLabel());
    }
    return this;
  }
}
