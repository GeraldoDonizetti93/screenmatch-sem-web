package br.com.gdbsys.screenmatchweb.principal;

import br.com.gdbsys.screenmatchweb.model.DadosSerie;
import br.com.gdbsys.screenmatchweb.model.DadosTempora;
import br.com.gdbsys.screenmatchweb.service.ConsumoAPI;
import br.com.gdbsys.screenmatchweb.service.ConverteDados;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

  private Scanner leitura = new Scanner(System.in);
  private final String ENDERECO = "https://omdbapi.com/?t=";
  private final String SEASON = "&season=";
  private final String APIKEY = "&apikey=b8dde3b1";
  private ConsumoAPI consumoAPI = new ConsumoAPI();
  private ConverteDados conversor = new ConverteDados();

  private void exibeTitulo() {
    System.out.println(
        """
            █▀ █▀▀ █▀█ █▀▀ █▀▀ █▄░█ █▀▄▀█ ▄▀█ ▀█▀ █▀▀ █░█
            ▄█ █▄▄ █▀▄ ██▄ ██▄ █░▀█ █░▀░█ █▀█ ░█░ █▄▄ █▀█""");
  }

  public void exibeMenu() {
    exibeTitulo();
    System.out.println("Digite o nome da Serie: ");
    var nomeDaSerie = leitura.nextLine();

    exiberTemporadasDaSerie(exibirSerie(nomeDaSerie));

    //    var aux = exibirSerie(nomeDaSerie);
    //
    //    System.out.println("Você quer ver as informações das temporadas? 1 - SIM / 2 - NÂO");
    //    var opt = leitura.nextInt();
    //
    //    if (opt == 1) {
    //      exiberTemporadasDaSerie(aux);
    //    }

    leitura.close();
  }

  public void exiberTemporadasDaSerie(DadosSerie dadosSerie) {
    var temporadas = new ArrayList<DadosTempora>();

    for (int i = 1; i <= dadosSerie.totalTemporadas(); i++) {
      //      var jsonTemporada =
      //          consumoAPI.obterDados(
      //              "https://omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=6585022c");
      var jsonTemporada =
          consumoAPI.obterDados(
              ENDERECO + dadosSerie.titulo().replace(" ", "+") + SEASON + i + APIKEY);
      var dadosTemporada = conversor.obterDados(jsonTemporada, DadosTempora.class);
      temporadas.add(dadosTemporada);
    }
    temporadas.forEach(System.out::println);
  }

  private DadosSerie exibirSerie(String nomeDaSerie) {
    var jsonSerie = consumoAPI.obterDados(ENDERECO + nomeDaSerie.replace(" ", "+") + APIKEY);
    System.out.println(jsonSerie);
    var conversor = new ConverteDados();
    var dadosSerie = conversor.obterDados(jsonSerie, DadosSerie.class);
    System.out.println(dadosSerie);

    return dadosSerie;
  }
}
