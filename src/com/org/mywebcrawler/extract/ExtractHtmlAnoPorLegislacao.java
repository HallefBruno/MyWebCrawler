package com.org.mywebcrawler.extract;

import com.org.mywebcrawler.entity.Ano;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class ExtractHtmlAnoPorLegislacao {
  
  private final List<Ano> anos;

  public ExtractHtmlAnoPorLegislacao(String legislatura) {
    this.anos = new ArrayList<>();
    this.anos.addAll(listAnos(legislatura));
  }
  
  private List<Ano> listAnos(String legislatura) {
    List<Ano> listAno = new ArrayList<>();
    try {
      Document html = Jsoup.connect("https://www.camara.leg.br/transparencia/gastos-parlamentares?legislatura=" + legislatura).get();
      Element select = html.select("select.ano").first();
      if(Objects.nonNull(select)) {
        for (Element tbody : select.children()) {
          var ano = Ano.builder().ano(tbody.html()).build();
          listAno.add(ano);
        }
      }
    } catch (IOException ex) {
      Logger.getGlobal().log(Level.SEVERE, ex.getMessage());
    }
    return listAno;
  }
  
  public List<Ano> getAnos() {
    return anos;
  }
  
}

/**
 *Document doc = Jsoup.connect("http://example.com")
  .data("query", "Java")
  .userAgent("Mozilla")
  .cookie("auth", "token")
  .timeout(3000)
  .post(); 
 */
