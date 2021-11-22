package net.shyshkin.study.quarkus.starting;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@ApplicationScoped
public class InMemoryBookRepository implements BookRepository {

    @ConfigProperty(name = "app.books.genre", defaultValue = "IT")
    String genre;

    private List<Book> books;

    @Inject
    Logger logger;

    @PostConstruct
    void init() {
        logger.debug("Initializing books");
        books = IntStream.rangeClosed(1, 5)
                .mapToObj(this::randomBook)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Optional<Book> getBookById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findAny();
    }

    @Override
    public int count() {
        return books.size();
    }

    private Book randomBook(int id) {
        return new Book(
                id,
                "Title_" + id,
                "Author " + id,
                ThreadLocalRandom.current().nextInt(1920, 2021),
                genre
        );
    }

}
