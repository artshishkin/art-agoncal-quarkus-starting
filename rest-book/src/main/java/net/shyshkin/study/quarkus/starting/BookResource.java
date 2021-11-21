package net.shyshkin.study.quarkus.starting;

import com.github.javafaker.Faker;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Path("/api/books")
public class BookResource {

    private List<Book> books = IntStream.rangeClosed(1, 5)
            .mapToObj(this::randomBook)
            .collect(Collectors.toList());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> allBooks() {
        return books;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Book> oneBook(@PathParam("id") int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findAny();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
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