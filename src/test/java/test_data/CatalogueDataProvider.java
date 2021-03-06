package test_data;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.*;


public class CatalogueDataProvider {

    public static Stream<Arguments> catalogProductNumberData() {
        return Stream.of(
                arguments(3, "&size=3"),
                arguments(6, "&size=6"),
                arguments(9, "&size=9")

        );
    }

}
