package br.com.gdbsys.screenmatchweb;

import br.com.gdbsys.screenmatchweb.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ScreenmatchwebApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(ScreenmatchwebApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    //    var principal = new Principal();
    //
    //    principal.exibeMenu();

    List<String> nomes = Arrays.asList("Geraldo", "Fernando", "Eduardo", "Sergio");
    //    nomes.stream().forEach(System.out::println);
    nomes.stream()
        .sorted()
        .limit(3)
        .filter(n -> n.startsWith("G"))
        //        .map(n -> n.toUpperCase())
        .map(String::toUpperCase)
        .forEach(System.out::println);

    //    json = consumoAPI.obterDados("https://coffee.alexflipnote.dev/random.json");
    //    System.out.println(json);
  }
}
