package net.shyshkin.study.quarkus.starting;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    List<Book> getAllBooks();

    Optional<Book> getBookById(int id);

    int count();

}
