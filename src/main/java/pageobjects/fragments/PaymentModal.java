package pageobjects.fragments;

import static com.codeborne.selenide.Selenide.$;

public class PaymentModal {

    public PaymentModal setCardNumber(String number) {
        $("#form-card-number").val(number);
        return this;
    }

    public PaymentModal setExpirationDate(String date) {
        $("#form-expires").val(date);
        return this;
    }

    public PaymentModal setCCV(String ccv) {
        $("#form-ccv").val(ccv);
        return this;
    }

    public PaymentModal clickUpdate() {
        $("[onclick='return card()']").click();
        return this;
    }

    public PaymentModal addCard(String number, String expirationDate, String ccv) {
        setCardNumber(number);
        setExpirationDate(expirationDate);
        setCCV(ccv);
        clickUpdate();
        return this;
    }

}
