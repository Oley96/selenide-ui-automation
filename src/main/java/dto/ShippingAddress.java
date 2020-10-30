package dto;

import lombok.*;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class ShippingAddress {

    @Builder.Default
    private String houseNumber = "26";

    @Builder.Default
    private String streetName = "Valburn street";

    @Builder.Default
    private String city = "Springfield";

    @Builder.Default
    private String postCode = "12345";

    @Builder.Default
    private String country = "USA";


}
