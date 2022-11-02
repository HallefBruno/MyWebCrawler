package com.org.mywebcrawler.render;

import com.org.mywebcrawler.entity.Legislatura;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class ComboboxLegislaturaRender extends DefaultListCellRenderer {
  @Override
  public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    if (value instanceof Legislatura) {
      Legislatura legislatura = (Legislatura) value;
      setText(legislatura.getId().toString());
    }
    return this;
  }
}
