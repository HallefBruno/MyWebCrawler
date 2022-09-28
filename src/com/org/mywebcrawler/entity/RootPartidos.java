package com.org.mywebcrawler.entity;

import java.util.ArrayList;

public class RootPartidos {

  public RootPartidos() {
  }

  public RootPartidos(ArrayList<SiglaPartido> dados, ArrayList<Link> links) {
    this.dados = dados;
    this.links = links;
  }

  private ArrayList<SiglaPartido> dados;
  private ArrayList<Link> links;

  public ArrayList<SiglaPartido> getDados() {
    return dados;
  }

  public void setDados(ArrayList<SiglaPartido> dados) {
    this.dados = dados;
  }

  public ArrayList<Link> getLinks() {
    return links;
  }

  public void setLinks(ArrayList<Link> links) {
    this.links = links;
  }
  
  
  
}
