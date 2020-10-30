package dto;

import lombok.*;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static utils.Utils.getRandomNumberWithLength;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class User {

    @Builder.Default
    private String userName = "john_doe".concat(getRandomNumberWithLength(5));

    @Builder.Default
    private String firstName = "John";

    @Builder.Default
    private String lastName = "Doe";

    @Builder.Default
    private String email = randomAlphabetic(6, 10).concat("@gmail.com");

    @Builder.Default
    private String password = randomAlphabetic(10);

}
