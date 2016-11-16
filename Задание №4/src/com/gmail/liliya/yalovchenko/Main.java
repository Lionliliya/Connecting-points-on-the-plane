package com.gmail.liliya.yalovchenko;

import java.util.*;

public class Main {

    public static void main(String[] args) {

//        List<Point> setOfPoints = Arrays.asList(new Point(-4, 1), new Point(-4, 3),
//                new Point(-3, 4), new Point(-5, 2),
//                new Point(-5, 3), new Point(-5.5, 3.5),
//                new Point(-5, 4), new Point(-6, 4),
//                new Point(-7, 3), new Point(-7, 4),
//                new Point(-6.5, 4.5), new Point(-7, 5),
//                new Point(-6, 5), new Point(2, 2), new Point(2, 3), new Point(2, 4), new Point(3,3),
//                new Point(3, 4), new Point(3, 5), new Point(4, 2), new Point(4, 4),
//                new Point(6, -5), new Point(6, -5));

        double [][] coordinates =  {{-4, 1}, {-4, 3}, {-3, 4}, {-5, 2},
                                    {-5, 3}, {-5.5, 3.5}, {-5, 4}, {-6, 4},
                                    {-7, 3}, {-7, 4}, {-6.5, 4.5}, {-7, 5},
                                    {-6, 5}, {2, 2}, {2, 3}, {2, 4}, {3, 3},
                                    {3, 4}, {3, 5}, {4, 2}, {4, 4}, {6, -5}, {6, -5}};


        List<Point> orderedPoints = PlaneOfPoints.arrangePointsOrder(coordinates);

        orderedPoints.forEach(System.out::println);
    }
}