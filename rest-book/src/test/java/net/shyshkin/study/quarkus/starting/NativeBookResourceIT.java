package net.shyshkin.study.quarkus.starting;

import io.quarkus.test.junit.NativeImageTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.text.IsEmptyString.emptyOrNullString;

@NativeImageTest
public class NativeBookResourceIT extends BookResourceTest {

    // Execute the same tests but in native mode.

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
                .body("genre", is("Information Technology"));
    }
}