package ru.job4j.ood.ocp;

import java.util.List;

public class FiguresImplemetation {

    private interface Drawable {
        String draw();
    }

    //    private static class Rectangle {
    private static class Rectangle implements Drawable {
        public String draw() {
            return "...";
        }
    }

    public static void main(String[] args) {
        List<Rectangle> rectangles = List.of(new Rectangle());
        rectangles.forEach(Rectangle::draw);
    }
}