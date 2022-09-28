package com.org.mywebcrawler.entity;

import java.io.Serializable;

public class Deputado implements Serializable {

  public Deputado() {
  }

  public Deputado(Integer id, String uri, String nome, String siglaPartido, String uriPartido, String siglaUf, Integer idLegislatura, String urlFoto, String email) {
    this.id = id;
    this.uri = uri;
    this.nome = nome;
    this.siglaPartido = siglaPartido;
    this.uriPartido = uriPartido;
    this.siglaUf = siglaUf;
    this.idLegislatura = idLegislatura;
    this.urlFoto = urlFoto;
    this.email = email;
  }
  
  private Integer id;
  private String uri;
  private String nome;
  private String siglaPartido;
  private String uriPartido;
  private String siglaUf;
  private Integer idLegislatura;
  private String urlFoto;
  private String email;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSiglaPartido() {
    return siglaPartido;
  }

  public void setSiglaPartido(String siglaPartido) {
    this.siglaPartido = siglaPartido;
  }

  public String getUriPartido() {
    return uriPartido;
  }

  public void setUriPartido(String uriPartido) {
    this.uriPartido = uriPartido;
  }

  public String getSiglaUf() {
    return siglaUf;
  }

  public void setSiglaUf(String siglaUf) {
    this.siglaUf = siglaUf;
  }

  public Integer getIdLegislatura() {
    return idLegislatura;
  }

  public void setIdLegislatura(Integer idLegislatura) {
    this.idLegislatura = idLegislatura;
  }

  public String getUrlFoto() {
    return urlFoto;
  }

  public void setUrlFoto(String urlFoto) {
    this.urlFoto = urlFoto;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
  

}
