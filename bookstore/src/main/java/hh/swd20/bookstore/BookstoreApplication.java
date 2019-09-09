package hh.swd20.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}


@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository) { 
	return (args) -> {
		log.info("save a couple of books");
		bookRepository.save(new Book("Hauskimmat vitsit","Kari Kirjailija",55016,2017,40));
		bookRepository.save(new Book("Anna mun arvata","Oona Kalervo",690582,2017,46));	
		bookRepository.save(new Book("Sininen lintu","Oona Kalervo",690582,2007,76));	
		
		log.info("fetch all books");
		for (Book book : bookRepository.findAll()) {
			log.info(book.toString());
		}

	};
}
}

