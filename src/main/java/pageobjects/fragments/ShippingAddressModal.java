package pageobjects.fragments;

import dto.ShippingAddress;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ShippingAddressModal {

    private ShippingAddressModal setHouseNumber(String number) {
        $("#form-number").val(number);
        return this;
    }

    private ShippingAddressModal setStreetName(String name) {
        $("#form-street").val(name);
        return this;
    }

    private ShippingAddressModal setCity(String city) {
        $("#form-city").val(city);
        return this;
    }

    private ShippingAddressModal setPostCode(String code) {
        $("#form-post-code").val(code);
        return this;
    }

    private ShippingAddressModal setCountry(String country) {
        $("#form-country").val(country);
        return this;
    }

    private ShippingAddressModal clickUpdate() {
        $("[onclick='return address()']").click();
        return this;
    }

    @Step
    public ShippingAddressModal addShippingAddress(ShippingAddress address) {
        setHouseNumber(address.getHouseNumber());
        setStreetName(address.getStreetName());
        setCity(address.getCity());
        setPostCode(address.getPostCode());
        setCountry(address.getCountry());
        clickUpdate();
        return this;
    }

}

