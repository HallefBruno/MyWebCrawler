package com.org.mywebcrawler.render;

import com.org.mywebcrawler.entity.TodosDeputados;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class ComboboxDeputadosRenderer extends DefaultListCellRenderer {
  
  @Override
  public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    if (value instanceof TodosDeputados) {
      TodosDeputados deputados = (TodosDeputados) value;
      setText(deputados.getLabel());
    }
    return this;
  }
  
}
