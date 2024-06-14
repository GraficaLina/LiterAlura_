package com.alura.Literature;

import com.alura.Literature.principal.Principal;
import com.alura.Literature.repository.AuthorRepository;
import com.alura.Literature.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class aplicacionLiteralura implements CommandLineRunner {
	@Autowired
	public BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;

    public aplicacionLiteralura(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(aplicacionLiteralura.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(bookRepository, authorRepository);
		principal.showMenu();
	}
}
