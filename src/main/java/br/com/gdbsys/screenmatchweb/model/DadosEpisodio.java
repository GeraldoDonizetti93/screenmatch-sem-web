package br.com.gdbsys.screenmatchweb.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodio(
    @JsonAlias("Title") String titulo,
    @JsonAlias("Episode") Integer numeroEp,
    @JsonAlias("imdbRating") String avaliacao,
    @JsonAlias("Released") String dataDeLancamento) {}
