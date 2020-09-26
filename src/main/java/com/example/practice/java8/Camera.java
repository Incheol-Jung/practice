package com.example.practice.java8;

import java.awt.Color;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author Incheol Jung
 */
public class Camera {

    private Function<Color, Color> filter;

    public Color capture(final Color inputColor) {
        final Color processedColor = filter.apply(inputColor);
        // more processing of color
        return processedColor;
    }

    public void setFilters(final Function<Color, Color>... filters) {
        filter = Stream.of(filters)
                       .reduce((filter, next) -> filter.compose(next))
                       .orElse(color -> color);
    }

    public static void main(String[] args) {
        Camera camera = new Camera();
        camera.setFilters(Color::brighter, Color::darker);
    }
}
