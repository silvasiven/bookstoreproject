package hh.swd20.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
	
	@RequestMapping(value= "/index", method = RequestMethod.GET)
	public String helloYou() {
			return "index";
}

/*	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public List<Book> getCars(Model model) {
		List<Book> books = new ArrayList<Book>(); // ei vielä haeta tietokannasta autoja -> luodaan tyhjä lista
		books.add(new Book("Tesla","Kari Kirjailija",55016,2017,40));
		books.add(new Book("Kingi","Oona Kalervo",690582,2017,46));
		model.addAttribute("books", books); // välitetään autolista templatelle model-olion avulla
		return "lista"; 
	}*/

}
