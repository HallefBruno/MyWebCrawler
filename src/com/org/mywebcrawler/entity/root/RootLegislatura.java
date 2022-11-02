package com.org.mywebcrawler.entity.root;

import com.org.mywebcrawler.entity.Legislatura;
import com.org.mywebcrawler.entity.Link;
import java.util.ArrayList;
import java.util.List;


public class RootLegislatura {
  
  public RootLegislatura() {
  }

  public RootLegislatura(List<Legislatura> dados, ArrayList<Link> links) {
    this.dados = dados;
    this.links = links;
  }
  
  private List<Legislatura> dados;
  private ArrayList<Link> links;

  public List<Legislatura> getDados() {
    return dados;
  }

  public void setDados(List<Legislatura> dados) {
    this.dados = dados;
  }

  public ArrayList<Link> getLinks() {
    return links;
  }

  public void setLinks(ArrayList<Link> links) {
    this.links = links;
  }
}
