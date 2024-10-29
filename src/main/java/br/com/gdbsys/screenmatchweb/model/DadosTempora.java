package br.com.gdbsys.screenmatchweb.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTempora(
    @JsonAlias("Season") Integer numero, @JsonAlias("Episodes") List<DadosEpisodio> episodios) {}
