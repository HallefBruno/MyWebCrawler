package com.org.mywebcrawler.entity;

import java.util.List;

public class LinkBusca {
    
    private String url;
    private String label;

    public LinkBusca() {
    }

    public LinkBusca(String url, String label) {
        this.url = url;
        this.label = label;
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    public List<LinkBusca> list() {
        return List.of(new LinkBusca("https://www.placardefutebol.com.br/brasileirao-serie-a", "Brasileirão Serie A"),new LinkBusca("https://www.placardefutebol.com.br/jogos-em-andamento", "Jogos em Andamento"),new LinkBusca("https://www.placardefutebol.com.br/jogos-de-hoje", "Jogos de Hoje"));
    }
    
}
