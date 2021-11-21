package net.shyshkin.study.quarkus.starting;

import org.jboss.logging.Logger;

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

    @Inject
    Logger logger;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> allBooks() {
        logger.info("Returns all books");
        return repository.getAllBooks();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Book> oneBook(@PathParam("id") int id) {
        logger.info("Returns book with id: "+id);
        return repository.getBookById(id);
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int count() {
        logger.info("Returns books count");
        return repository.count();
    }
}