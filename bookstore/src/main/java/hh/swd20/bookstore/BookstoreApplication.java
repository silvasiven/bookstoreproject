package hh.swd20.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;
import hh.swd20.bookstore.domain.User;
import hh.swd20.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}


@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository,UserRepository userRepository) { 
	return (args) -> {
		log.info("save a couple of books");
		categoryRepository.save(new Category("Horror"));
		categoryRepository.save(new Category("Biography"));
		categoryRepository.save(new Category("Fiction"));
		
		bookRepository.save(new Book("Hauskimmat vitsit","Kari Kirjailija","55016",2017,40, categoryRepository.findByName("Horror").get(0)));
		bookRepository.save(new Book("Anna mun arvata","Oona Kalervo","690582",2017,46, categoryRepository.findByName("Biography").get(0)));	
		bookRepository.save(new Book("Sininen lintu","Oona Kalervo","690582",2007,76, categoryRepository.findByName("Fiction").get(0)));	
		
		User user1 = new User("user", "$2a$10$/iEyHBLqguFtM/aIiaOKmu2PiPe635mDmoqkOdG21yJbHGLgYF07e", "kayttaja@kayttaja.fi", "USER");
		User user2 = new User("admin", "$2a$10$JWXmJcPJWkMuoPWgypbkou492xYY.8IGhmnd91PvJe0FPyz.dxFLK", "admin@admin.fi", "ADMIN");
		userRepository.save(user1);
		userRepository.save(user2);
		
		log.info("fetch all books");
		for (Book book : bookRepository.findAll()) {
			log.info(book.toString());
		}

	};
}
}

