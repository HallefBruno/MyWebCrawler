package com.org.mywebcrawler.entity;

import java.io.Serializable;

public class Link implements Serializable {

  public Link() {
  }

  public Link(String rel, String href) {
    this.rel = rel;
    this.href = href;
  }
  
  private String rel;
  private String href;

  public String getRel() {
    return rel;
  }

  public void setRel(String rel) {
    this.rel = rel;
  }

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }
  
  
  
}
