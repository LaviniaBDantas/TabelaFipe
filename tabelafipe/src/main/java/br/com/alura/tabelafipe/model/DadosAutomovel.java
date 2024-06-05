package br.com.alura.tabelafipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAutomovel(@JsonAlias("codigo") String codigo, @JsonAlias("nome")String marca) {
}
