package MockAPI;
import groovy.util.logging.Slf4j;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

@Slf4j
public class MockAPIRestAssured {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MockAPIRestAssured.class);
    Response response;


    //Yapıcı kullanırak baseURI oluşturuldu. Tüm fonksiyonlarda yapıcı üzerinden kullanılır.
    public MockAPIRestAssured(){
        baseURI="https://lgoqg.mocklab.io/";
    }

    //Stok fiyat bilgisi dönen bir endpoint
    @Test(priority = 1)
    public void getallGrocery(){
        log.info("tok fiyat bilgisi dönen bir endpoint");

        response = given()
                .header("Content-Type","application/json")
                .when()
                .get("https://lgoqg.mocklab.io/allGrocery")
                .then()
                //status kod direkt burada kontrol edildi.
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();

        String body=response.getBody().asString();

    }


    // İsme göre cevap dönen bir endpoint
    @Test(priority = 2)
    public void getNameGrocery(){
        log.info("İsme göre cevap dönen bir endpoint");

        response= given()
                .accept(ContentType.JSON)
                .pathParam("allGrocery","apple")
                .when()
                .get("allGrocery/{allGrocery}")
                .then()
                .statusCode(200)
                .extract().response();
        String body=response.getBody().asString();


    }


    //Yeni bir ürün eklenen endpoint
    @Test(priority = 3)
    public void addGrocery(){
        log.info("Yeni bir ürün eklenen endpoint");

        response = given()
                .header("Content-Type","application/x-www-form-urlencoded")
                .body("{\r\n    \"name\": \"fish\",\r\n    \"status\": \"sold\"\r\n}")
                .when()
                .post("https://lgoqg.mocklab.io/allGrocery")
                .then()
                //status kod direkt burada kontrol edildi.
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();


    }
}
