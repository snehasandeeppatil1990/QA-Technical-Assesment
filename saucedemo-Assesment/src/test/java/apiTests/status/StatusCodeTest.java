package apiTests.status;



import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;


public class StatusCodeTest {
	@BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in";  
        
    }

    // GET REQUEST 
    @Test
    public void testGetUsers() {

        int statusCode =
                given()
                        .when()
                        .get("/api/users?page=2")
                        .then()
                        .extract()
                        .statusCode();

        System.out.println("GET Status: " + statusCode);

        Assert.assertEquals(statusCode, 200, "GET /users API failed!");
    }


    // POST REQUEST 
    @Test
    public void testCreateUser() {

        //String requestBody = "{\n" + "  \"name\": \"Sneha\",\n" + "  \"job\": \"QA Engineer\"\n" + "}";

        int statusCode =
                given()
                        .contentType(ContentType.JSON)
                        .body("{\n" + "  \"name\": \"Sneha\",\n" + "  \"job\": \"QA Engineer\"\n" + "}")
                        .when()
                        .post("/api/users")
                        .then()
                        .extract()
                        .statusCode();

        System.out.println("POST Status: " + statusCode);

        Assert.assertEquals(statusCode, 201, "POST /users API failed!");
    }


    // DELETE REQUEST 
    @Test
    public void testDeleteUser() {

        int statusCode =
                given()
                        .when()
                        .delete("/api/users/2")
                        .then()
                        .extract()
                        .statusCode();

        System.out.println("DELETE Status: " + statusCode);

        Assert.assertEquals(statusCode, 204, "DELETE /users API failed!");
    }

}
