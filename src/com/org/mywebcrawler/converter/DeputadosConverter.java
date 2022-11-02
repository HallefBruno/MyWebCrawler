package com.org.mywebcrawler.converter;

import com.org.mywebcrawler.entity.TodosDeputados;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;

public class DeputadosConverter extends ObjectToStringConverter {

  @Override
  public String getPreferredStringForItem(Object o) {
    TodosDeputados todosDeputados = (TodosDeputados) o;
    return todosDeputados.getLabel();
  }
  
}
