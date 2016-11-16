package com.gmail.liliya.yalovchenko;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class {@code PlaneOfPoints} define methods to handle {@code Point}
 * Method arrangePointsOder(list of points) define list of points with
 * x and y coordinates on the plane, which can be consecutive connected
 * by a closed polygonal line that has no self-intersections.
 */
public class PlaneOfPoints {

    /**
     * Don't let anyone instantiate this class with empty coordinates.
     */
    private PlaneOfPoints() {}

    /**
     * Define list of points with x and y coordinates on the plane,
     * which can be consecutive connected by a closed polygonal line
     * that has no self-intersections.
     *
     * Algorithm:
     * 1. Find the lowest point on the plane.
     * 2  Find angle between the X axis and line that connects each point
     *    with the lowest point, while crossing X axis.
     * 3. Sort point in ascending order by angle (if the angle is the same, by distance from point to the lowest point)
     * 4. Add closed point to ordered list in order to close the polygonal line
     * 5. Return ordered list of points.
     *
     * @param listOfCoordinates input array of coordinates of points on the plane
     *                    that need to be connected by polygonal line
     * @return list of ordered points
     * @throws java.lang.NullPointerException if input list of {@code Point} is empty or null
     */
    public static List<Point> arrangePointsOrder(double [][] listOfCoordinates) throws NullPointerException {
        List<Point> setOfPoints = new ArrayList<>();

        if (listOfCoordinates == null) {
            throw new NullPointerException("Input array is null or empty");
        }
        populatePoints(listOfCoordinates, setOfPoints);

        List<Point> sortedPoints = new ArrayList<>(setOfPoints);
        Collections.sort(sortedPoints);
        Point downPoint = sortedPoints.get(0);

        for (Point point : setOfPoints) {
            point.setTangle(getTangent(downPoint, point));
        }

        Collections.sort(sortedPoints, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int result;
                result = Double.compare(o1.getTangle(), o2.getTangle());

                if (result != 0) {
                    return result;
                }
                result =  Double.compare(o1.getX(), o2.getX());
                return result;
            }
        });

        sortedPoints.add(sortedPoints.get(0));
        return sortedPoints;
    }

    private static void populatePoints(double[][] listOfCoordinates, List<Point> setOfPoints) throws NullPointerException {

        for (double[] listOfCoordinate : listOfCoordinates) {

            if (listOfCoordinate == null) {
                throw new NullPointerException("Input array is null or empty");
            }
             setOfPoints.add(new Point(listOfCoordinate[0], listOfCoordinate[1]));

        }
    }

    /**
     * Calculate tangent of angel between the X axis and line that connects two points
     *
     * @param downPoint the lowest point in the plane
     * @param point current point
     *
     * @return tangent of angel or NaN if point == downPoint
     */
    private static double getTangent(Point downPoint, Point point) {
        return (downPoint.getY() - point.getY())/(downPoint.getX() - point.getX());
    }

}
