package com.org.mywebcrawler.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Legislatura {
  private Integer id;
  private String uri;
  private String dataInicio;
  private String dataFim;
}
