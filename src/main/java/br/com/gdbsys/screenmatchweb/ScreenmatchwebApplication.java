package br.com.gdbsys.screenmatchweb;

import br.com.gdbsys.screenmatchweb.principal.Principal;
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

    var principal = new Principal();

    principal.exibeMenu();


    //    json = consumoAPI.obterDados("https://coffee.alexflipnote.dev/random.json");
    //    System.out.println(json);
  }
}
