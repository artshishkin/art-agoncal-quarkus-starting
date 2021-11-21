package net.shyshkin.study.quarkus.starting;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/api/books")
public class BookResource {

    @Inject
    BookRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> allBooks() {
        return repository.getAllBooks();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Book> oneBook(@PathParam("id") int id) {
        return repository.getBookById(id);
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int count() {
        return repository.count();
    }
}