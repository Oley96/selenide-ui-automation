package dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder(toBuilder = true)
public class PaymentInfo {

    @Builder.Default
    private String cardNumber = "1111222233334444";

    @Builder.Default
    private String expirationDate = "09/25";

    @Builder.Default
    private String ccvCode = "123";

}
