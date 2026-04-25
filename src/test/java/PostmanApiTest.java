import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static constants.CommandConstants.BASE_URI;
import static io.restassured.RestAssured.given;

import models.EchoDataUser;
import org.junit.jupiter.api.Test;

public class PostmanApiTest {
    @Test
     void testGetPostmanApi() {
        Response response = given()
                .baseUri(BASE_URI)
                .queryParam("Name", "Nikita")
                .queryParam("ID", "506")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.Name", equalTo("Nikita"))
                .body("args.ID", equalTo("506"))
                .log().all()
                .extract().response();
    }

    @Test
    void testPostPostmanApi() {
        EchoDataUser user = EchoDataUser.builder()
                .username("shinu_user")
                .firstName("firstName")
                .lastName("lastName")
                .build();
        given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("json.username", equalTo("shinu_user"))
                .body("json.firstName", equalTo("firstName"))
                .log().all();
    }

    @Test
    void testPutPostmanApi() {
        EchoDataUser userUpdate = EchoDataUser.builder()
                .username("shinu_user_updated")
                .firstName("firstName_updated")
                .lastName("lastName_updated")
                .build();
        given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON)
                .body(userUpdate)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("json.username", equalTo("shinu_user_updated"))
                .body("json.firstName", equalTo("firstName_updated"))
                .log().all();
    }

    @Test
    void testPatchPostmanApi(){
        EchoDataUser userPatch = EchoDataUser.builder()
                .username("new_username")
                .build();
        given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON)
                .body(userPatch)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("json.username", equalTo("new_username"))
                .log().all();
    }

    @Test
    void testDeletePostmanApi() {
        given()
        .baseUri(BASE_URI)
        .when()
        .delete("/delete")
        .then()
        .statusCode(200)
        .log().all();
    }
}