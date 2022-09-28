package com.org.mywebcrawler.entity;

import com.fasterxml.jackson.annotation.JsonRootName;
import java.io.Serializable;

@JsonRootName(value = "dados")
public class SiglaPartido implements Serializable {

  public SiglaPartido() {
  }

  public SiglaPartido(Integer id, String sigla, String nome, String uri) {
    this.id = id;
    this.sigla = sigla;
    this.nome = nome;
    this.uri = uri;
  }
  
  private Integer id;
  private String sigla;
  private String nome;
  private String uri;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getSigla() {
    return sigla;
  }

  public void setSigla(String sigla) {
    this.sigla = sigla;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }
  
  
  
}
