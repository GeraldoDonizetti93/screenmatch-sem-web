package br.com.gdbsys.screenmatchweb;

import br.com.gdbsys.screenmatchweb.model.DadosSerie;
import br.com.gdbsys.screenmatchweb.service.ConsumoAPI;
import br.com.gdbsys.screenmatchweb.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchwebApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(ScreenmatchwebApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    var consumoAPI = new ConsumoAPI();
    var json = consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");

    System.out.println(json);

    var conversor = new ConverteDados();
    var dados = conversor.obterDados(json, DadosSerie.class);

    System.out.println(dados);

    //    json = consumoAPI.obterDados("https://coffee.alexflipnote.dev/random.json");
    //    System.out.println(json);
  }
}
