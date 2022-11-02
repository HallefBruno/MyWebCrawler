package com.org.mywebcrawler.extract;

import com.org.mywebcrawler.entity.GastoCota;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExtractHtmlGastoCota {
  
  private final List<GastoCota> listGastoCota;
  private final String legislatura;
  private final String ano;
  private final String deputado;
  
  public ExtractHtmlGastoCota(String legislatura, String ano, String deputado) {
    this.listGastoCota = new ArrayList<>();
    this.legislatura = legislatura;
    this.ano = ano;
    this.deputado = deputado;
    this.listGastoCota.addAll(listGastoCotas());
  }

  private List<GastoCota> listGastoCotas() {
    List<GastoCota> deputados = new ArrayList<>();
    try {
      Document html = Jsoup.connect("https://www.camara.leg.br/transparencia/gastos-parlamentares?legislatura="+this.legislatura+"&ano="+this.ano+"&por=deputado&deputado="+this.deputado).get();
      Element select = html.select("#js-quantidade-cota > tbody").first();
      for(Element tbody : select.children()) {
        var gasto = GastoCota.builder()
          .mes(tbody.child(0).html())
          .valor(new BigDecimal(tbody.child(1).html().replace(".", "").replace(",", ".")))
          .build();
        deputados.add(gasto);
      }
    } catch (IOException ex) {
      Logger.getGlobal().log(Level.SEVERE, ex.getMessage());
    }
    return deputados;
  }
  
  public List<GastoCota> getListCotas() {
    return this.listGastoCota;
  }
}
