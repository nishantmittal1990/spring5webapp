package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * In order to create author controller, specify controller annotation to Spring MVC
 */
@Controller
public class AuthorController {
    /**
     * passing author repository
     */
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    /**
     * @param model - author repository as model
     * @return - view with list of authors on thymleaf
     */
    @RequestMapping("/authors")
    public String getAuthor(Model model) {
        //model addAttribute - takes elements to view
        model.addAttribute("authors", authorRepository.findAll());
        return "authorslist";
    }

}
