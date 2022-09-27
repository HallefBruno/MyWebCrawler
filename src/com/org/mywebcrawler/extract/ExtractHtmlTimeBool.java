package com.org.mywebcrawler.extract;

import com.org.mywebcrawler.entity.Placar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ExtractHtmlTimeBool {

  private final String url;

  public ExtractHtmlTimeBool(String url) {
    this.url = url;
  }

  public List<Placar> listJogos() {
    List<Placar> placars = new ArrayList<>();
    try {
      Document html = Jsoup.connect(this.url).get();
      Element liveScore = html.select("div#livescore").first();
      Placar placar = new Placar();
      for (Element containerPai : liveScore.children()) {
        Elements containerConteudo = containerPai.getElementsByClass("container content");
        if (containerConteudo != null && !containerConteudo.isEmpty()) {

          Element classificacao = containerConteudo.first().children().get(0).firstElementChild();
          if (Objects.nonNull(classificacao)) {
            if ("Classificação - Campeonato Brasileiro".contains(classificacao.child(0).text())) {
              break;
            }
          }

          for (Element containerAtual : containerConteudo.first().children()) {
            if (Objects.nonNull(containerAtual) && containerAtual.childNodeSize() > 0) {
              Element status = containerAtual.getElementsByTag("span").first();
              String linkAcompanharAoVivo = containerAtual.select("a").attr("href");
              if (Objects.nonNull(status) && Objects.nonNull(status.text())) {
                placar = new Placar();
                if (status.text().contains("HOJE") || status.text().contains("AMANHÃ")) {
                  placar.setStatus(status.text());
                  placar.setPrimeiroTime(containerAtual.getElementsByClass("text-right team_link").first().text());
                  placar.setGolsPrimeiroTime("0");
                  placar.setSegundoTime(containerAtual.getElementsByClass("text-left team_link").first().text());
                  placar.setGolsSeguntoTime("0");
                  placars.add(placar);
                  placar = new Placar();
                } else if (status.text().contains("MIN") || status.text().contains("ENCERRADO")) {
                  placar.setStatus(status.text());
                  placar.setStatus(status.text());
                  placar.setPrimeiroTime(containerAtual.getElementsByClass("text-right team_link").first().text());
                  placar.setGolsPrimeiroTime(containerAtual.getElementsByClass("badge badge-default").first().text());
                  placar.setSegundoTime(containerAtual.getElementsByClass("text-left team_link").first().text());
                  placar.setGolsSeguntoTime(containerAtual.getElementsByClass("w-25 p-1 match-score d-flex justify-content-start").first().getElementsByClass("badge badge-default").first().text());

                  Element elementNarracao = containerAtual.getElementsByClass("w-25 p-1 link_to_match").first();
                  String linkImg = elementNarracao.select("img").first().absUrl("src");
                  if (Objects.nonNull(linkImg) && !linkImg.isEmpty() && linkImg.contains("tv")) {
                    placar.setLink(linkAcompanharAoVivo);
                  }

                  placars.add(placar);
                  placar = new Placar();
                }
              }
            }
          }
        }
      }

    } catch (IOException ex) {
      Logger.getLogger(ExtractHtmlTimeBool.class.getName()).log(Level.SEVERE, ex.getMessage());
    }
    return placars;
  }

}
