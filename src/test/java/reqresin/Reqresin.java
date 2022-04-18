package reqresin;

import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;

import java.io.File;

public class Reqresin {

    private static final String REQRESIN_BASEURL = "https://reqres.in";

    public void getListUser()  {
        SerenityRest.given()
                .queryParam("page", "1")
                .get(REQRESIN_BASEURL + "/api/users");
    }

    public void postLogin() {

        JSONObject bodyJson = new JSONObject();

        bodyJson.put("email", "eve.holt@reqres.in");
        bodyJson.put("password", "cityslicka");

        SerenityRest.given()
                .header("Content-type", "application/json")
                .body(bodyJson.toString())
                .post(REQRESIN_BASEURL + "/api/login");

    }

    public void putUpdate() {
        JSONObject bodyJson = new JSONObject();

        bodyJson.put("name", "morpheus");
        bodyJson.put("job", "zion");

        SerenityRest.given()
                .header("Content-type", "application/json")
                .body(bodyJson.toString())
                .put(REQRESIN_BASEURL + "/api/users/2");
    }

    public void postLoginWithParam(String jsonPath) {
            File bodyJson = new File(String.format("src/test/resources/payload/%s", jsonPath));

            SerenityRest.given()
                    .header("Content-type", "application/json")
                    .body(bodyJson)
                    .post(REQRESIN_BASEURL + "/api/login");
    }

    public void getSingleRequestWithParam(String jsonPath) {
        File bodyJson = new File(String.format("src/test/resources/payload/%s", jsonPath));

        SerenityRest.given()
                .header("Content-type", "application/json")
                .body(bodyJson)
                .post(REQRESIN_BASEURL + "/api/users/2");
    }
}

