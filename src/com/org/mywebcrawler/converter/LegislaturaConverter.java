package com.org.mywebcrawler.converter;

import com.org.mywebcrawler.entity.Legislatura;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;


public class LegislaturaConverter extends ObjectToStringConverter {

  @Override
  public String getPreferredStringForItem(Object o) {
    Legislatura todosDeputados = (Legislatura) o;
    return todosDeputados.getId().toString();
  }
  
}
