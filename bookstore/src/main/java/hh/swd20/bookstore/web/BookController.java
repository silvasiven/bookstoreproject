package hh.swd20.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	
	@RequestMapping(value= "/index", method = RequestMethod.GET)
	public String helloYou() {
			return "index";

}
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String getBooks(Model model) {
			List<Book> books =  (List<Book>) bookRepository.findAll(); // haeta tietokannasta autot
			model.addAttribute("books", books); // välitetään autolista templatelle model-olion avulla
			return "booklist";
	}

// tyhjän lomakkeen muodostaminen
@RequestMapping(value = "/newbook", method = RequestMethod.GET)
public String getNewBookForm(Model model) {
	model.addAttribute("book", new Book()); // "tyhjä" auto-olio
	return "bookform";
}

//lomakkeella syötettyjen tietojen vastaanotto ja tallennus
@RequestMapping(value = "/newbook", method = RequestMethod.POST)
public String saveBook(@ModelAttribute Book book) {
	bookRepository.save(book);
	return "redirect:/booklist";
}

// poisto
@RequestMapping(value = "/deletebook/{id}", method = RequestMethod.GET)
public String deleteBook(@PathVariable("id") Long bookId) {
	bookRepository.deleteById(bookId);
	return "redirect:../booklist";
}
//muokkaus
@RequestMapping(value = "/editbook/{id}", method = RequestMethod.GET)
public String editBook(@PathVariable("id") Long bookId, Model title) {
	title.addAttribute("book", bookRepository.findById(bookId));
	return "editbook";	
}

@RequestMapping(value = "/editbook", method = RequestMethod.POST)
public String updateBook(@ModelAttribute Book book) {
	bookRepository.save(book);
	return "redirect:/booklist";
}
}