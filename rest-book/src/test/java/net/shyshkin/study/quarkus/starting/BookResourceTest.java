package net.shyshkin.study.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.text.IsEmptyString.emptyOrNullString;

@QuarkusTest
public class BookResourceTest {

    @Test
    void shouldReturnAllBooks() {
        given()
                .accept(ContentType.JSON)

                .when().get("/api/books")

                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("size()", is(5));
    }

    @Test
    void shouldReturnBookById_present() {
        given()
                .pathParam("id", 3)
                .accept(ContentType.JSON)

                .when().get("/api/books/{id}")

                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", is(3))
                .body("title", not(emptyOrNullString()))
                .body("author", not(emptyOrNullString()))
                .body("genre", not(emptyOrNullString()))
                .body("genre", is("IT"));
    }

    @Test
    void shouldReturnBookById_absentId() {
        given()
                .pathParam("id", 100)
                .accept(ContentType.JSON)

                .when().get("/api/books/{id}")

                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(is("null"))
        ;
    }

    @Test
    void shouldReturnBookById_wrongFormat() {
        given()
                .pathParam("id", "somethingWrong")
                .accept(ContentType.JSON)

                .when().get("/api/books/{id}")

                .then()
                .statusCode(404)
                .body(emptyOrNullString())
        ;
    }

    @Test
    void shouldReturnCountOfBooks() {
        given()
                .accept(ContentType.TEXT)

                .when().get("/api/books/count")

                .then()
                .statusCode(200)
                .contentType(ContentType.TEXT)
                .body(is("5"));
    }

}