package hh.swd20.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	//REST kaikki kirjat
	@RequestMapping(value="/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) bookRepository.findAll();
	}
	
	//REST hakee kirjan id:n perusteella
	@RequestMapping(value="/book/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
		return bookRepository.findById(bookId);
	}

   
	// kaikki kirjat listalla
	@RequestMapping(value="/booklist")
	public String listBook(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "booklist";
	}
	
	
	// lisää uuden kirjan
	@RequestMapping(value="/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		return "addbook";
	}
	
	// tallentaa uuden kirjan/päivittää muuttuneet tiedot
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Book book) {
		bookRepository.save(book);
		return "redirect:booklist";
	}
	

	// poisto
	@RequestMapping(value = "/deletebook/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId) {
		bookRepository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", bookRepository.findById(bookId));
		model.addAttribute("categories", categoryRepository.findAll());
		return "editbook";
	}
	
}