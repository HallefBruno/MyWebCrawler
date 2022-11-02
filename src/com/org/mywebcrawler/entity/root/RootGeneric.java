package com.org.mywebcrawler.entity.root;

import java.util.ArrayList;

public class RootGeneric<T> {

  private ArrayList<T> dados;
  private ArrayList<T> links;
  private String url;

  public RootGeneric() {
  }
  
  public RootGeneric(ArrayList<T> dados, ArrayList<T> links, String url) {
    this.dados = dados;
    this.links = links;
    this.url = url;
  }

  public ArrayList<T> getDados() {
    return dados;
  }

  public void setDados(ArrayList<T> dados) {
    this.dados = dados;
  }

  public ArrayList<T> getLinks() {
    return links;
  }

  public void setLinks(ArrayList<T> links) {
    this.links = links;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

}
