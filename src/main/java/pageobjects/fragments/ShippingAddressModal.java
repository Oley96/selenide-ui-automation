package pageobjects.fragments;

import static com.codeborne.selenide.Selenide.$;

public class ShippingAddressModal {

    public ShippingAddressModal setHouseNumber(String number) {
        $("#form-number").val(number);
        return this;
    }

    public ShippingAddressModal setStreenName(String name) {
        $("#form-street").val(name);
        return this;
    }

    public ShippingAddressModal setCity(String city) {
        $("#form-city").val(city);
        return this;
    }

    public ShippingAddressModal setPostCode(String code) {
        $("#form-post-code").val(code);
        return this;
    }

    public ShippingAddressModal setCountry(String country) {
        $("#form-country").val(country);
        return this;
    }

    public ShippingAddressModal clickUpdate() {
        $("[onclick='return address()']").click();
        return this;
    }

    public ShippingAddressModal addCard(String number, String name, String city, String code, String country) {
        setHouseNumber(number);
        setStreenName(name);
        setCity(city);
        setPostCode(code);
        setCountry(country);
        clickUpdate();
        return this;
    }

}

