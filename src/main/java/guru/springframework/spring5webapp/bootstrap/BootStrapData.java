
package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        /*System.out.println("Started with run method");*/

        //Creating publisher object
        Publisher pub = new Publisher();
        // Adding publisher components
        pub.setName("Hello Pushblisher");
        pub.setAddressLine1("India");
        pub.setCity("Ludhiana");
        pub.setZip("7887");
        publisherRepository.save(pub);
        System.out.println("Publisher count: " + publisherRepository.count());

        Author auth1 = new Author("Eric", "Evans");
        Book book1 = new Book("Test", "123456");
        auth1.getBooks().add(book1);
        book1.getAuthors().add(auth1);

        book1.setPublisher(pub);
        pub.getBooks().add(book1);

        authorRepository.save(auth1);
        bookRepository.save(book1);
        publisherRepository.save(pub);

        Author auth2 = new Author("Nishant", "Mittal");
        Book book2 = new Book("Master Java", "232323");

        auth2.getBooks().add(book2);
        book2.getAuthors().add(auth2);

        book2.setPublisher(pub);
        pub.getBooks().add(book2);

        authorRepository.save(auth2);
        bookRepository.save(book2);
        publisherRepository.save(pub);

        //System.out.println("Started in bootstrap");
        System.out.println("No. of books: " + bookRepository.count());
        System.out.println("No. of books assigned to publisher: " + pub.getBooks().size());
        //System.out.println(auth1.getBooks());
        //System.out.println("Elements of 1st author are : "+auth1.toString());
    }
}

