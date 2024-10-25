package br.com.gdbsys.screenmatchweb.service;

public interface IConverteDados {
  public <T> T obterDados(String json, Class<T> classe);
}
