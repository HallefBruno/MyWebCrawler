package com.org.mywebcrawler.entity;

import java.util.ArrayList;
import java.util.List;


public class RootDeputados {

  public RootDeputados() {
  }

  public RootDeputados(List<Deputado> dados, ArrayList<Link> links) {
    this.dados = dados;
    this.links = links;
  }
  
  private List<Deputado> dados;
  private ArrayList<Link> links;

  public List<Deputado> getDados() {
    return dados;
  }

  public void setDados(List<Deputado> dados) {
    this.dados = dados;
  }

  public ArrayList<Link> getLinks() {
    return links;
  }

  public void setLinks(ArrayList<Link> links) {
    this.links = links;
  }
  
}
