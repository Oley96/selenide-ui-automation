package dto;

import helpers.RandomHelper;
import lombok.*;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class User {

    @Builder.Default
    private String username = RandomHelper.getRandomUsername();

    @Builder.Default
    private String firstName = "John";

    @Builder.Default
    private String lastName = "Doe";

    @Builder.Default
    private String email = RandomHelper.getRandomEmail();

    @Builder.Default
    private String password = RandomHelper.getRandomPassword();

}
