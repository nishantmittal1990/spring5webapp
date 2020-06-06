package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * First of all we will tell spring that this is our controller by annotating @Controller
 * This is our BookController, we will have one method and it's request mapping
 * when that request mapping "/xyz" will be called, then that method will be called
 */
@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /*
    When this /books will be called, getBooks method will be called
    spring is going to provide it a model and we are using repository
    to get list of books out of database, assigning it to that of view of books on the model
    and then return back as a string
     */
    @RequestMapping("/books")
    public String getBooks(Model model){
        System.out.println("******Call to Books controller********");
        //model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("books", bookRepository.findAll());
        return "bookslist";
    }
}
