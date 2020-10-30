package pageobjects.fragments;

import dto.PaymentInfo;

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

    public PaymentModal addCard(PaymentInfo info) {
        setCardNumber(info.getCardNumber());
        setExpirationDate(info.getExpirationDate());
        setCCV(info.getCcvCode());
        clickUpdate();
        return this;
    }

}
