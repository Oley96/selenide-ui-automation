package api_service;

import dto.User;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class UserApiService extends ApiService {

    public Response registerUser(User user) {
        return setUp()
                .body(user)
                .when()
                .post("register");
    }

    public Response deleteCustomer(String id) {
        return setUp()
                .when()
                .delete("customers/" + id);
    }

    public Response getCustomers() {
        return setUp()
                .when()
                .get("customers");
    }


    public void deleteAllCustomers() {
        List<Map> customers = getCustomers()
                .then().extract().body().jsonPath().get("_embedded.customer.findAll()");

        customers.forEach((customer) -> deleteCustomer(customer.get("id").toString()));
    }
}
