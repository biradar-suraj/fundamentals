package org.drogo.basics.patterns;

import java.awt.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class Decorator {
    public static void main(String[] args) {
        print(new Camera());
        print(new Camera(Color::brighter));
        print(new Camera(Color::darker));
        print(new Camera(Color::darker,Color::brighter));

    }

    public static void print(Camera camera){
        System.out.println(camera.snap(new Color(125,125,125)));

    }
}

class Camera{
    public Color snap(Color input){
        return filter.apply(input);
    }
    private Function<Color,Color> filter;

    public Camera(Function<Color,Color>...filters){
        /*filter = Function.identity();

        for (var aFilter : filters) {
            filter= filter.andThen(aFilter);
        }*/

        filter= Stream.of(filters)
                .reduce(Function.identity(),Function::andThen);
    }
}