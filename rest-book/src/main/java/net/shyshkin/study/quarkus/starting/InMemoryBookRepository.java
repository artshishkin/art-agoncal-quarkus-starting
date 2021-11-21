package net.shyshkin.study.quarkus.starting;

import com.github.javafaker.Faker;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@ApplicationScoped
public class InMemoryBookRepository implements BookRepository {

    private final List<Book> books = IntStream.rangeClosed(1, 5)
            .mapToObj(this::randomBook)
            .collect(Collectors.toList());

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
                Faker.instance().book().title(),
                Faker.instance().book().author(),
                Faker.instance().date().birthday().getYear(),
                Faker.instance().book().genre()
        );
    }

}
