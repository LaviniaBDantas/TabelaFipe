package br.com.alura.tabelafipe;

import br.com.alura.tabelafipe.principal.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.Principal;

@SpringBootApplication
public class TabelafipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TabelafipeApplication.class, args);
	}
	public void run(String... args) throws Exception{
		Main principal = new Main();
		principal.exibeMenu();
	}

}
