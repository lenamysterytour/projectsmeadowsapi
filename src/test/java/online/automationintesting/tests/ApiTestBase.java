package online.automationintesting.tests;


import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public class ApiTestBase {

    @BeforeAll
    static void setup() {

        baseURI = "https://automationintesting.online";
    }
}