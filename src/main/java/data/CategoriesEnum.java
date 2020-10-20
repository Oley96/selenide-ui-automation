package data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoriesEnum {

    BROWN("brown"),
    GEEK("geek"),
    FORMAL("formal"),
    BLUE("blue"),
    SKIN("skin"),
    RED("red"),
    ACTION("action"),
    SPORT("sport"),
    BLACK("black"),
    MAGIC("magic"),
    GREEN("green");

    private String name;


}
