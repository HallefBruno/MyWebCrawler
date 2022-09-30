package com.org.mywebcrawler.extract;

import com.org.mywebcrawler.entity.TodosDeputados;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ExtractHtmlSelectDeputados {
  
  private final List<TodosDeputados> listTodosDeputados;
  
  public ExtractHtmlSelectDeputados() {
    this.listTodosDeputados = new ArrayList<>();
    this.listTodosDeputados.addAll(listDeputados());
  }
  
  private List<TodosDeputados> listDeputados() {
    List<TodosDeputados> deputados = new ArrayList<>();
    try {
      Document html = Jsoup.connect("https://www.camara.leg.br/transparencia/gastos-parlamentares").get();
      Element select = html.getElementById("deputado");
      for(Element optional : select.children()) {
        if(!"".equals(optional.attr("value"))) {
          var deputado = TodosDeputados.builder().label(optional.text()).value(optional.attr("value")).build();
          deputados.add(deputado);
        }
      }
    } catch (IOException ex) {
      Logger.getGlobal().log(Level.SEVERE, ex.getMessage());
    }
    return deputados;
  }
  
  public List<TodosDeputados> getListDeputados() {
    return this.listTodosDeputados;
  }

}
