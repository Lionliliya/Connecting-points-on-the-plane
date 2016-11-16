package com.gmail.liliya.yalovchenko;

/***
 * The class {@code Point} representing a location in (x,y)
 * coordinate space, specified in double precision.
 * {@code Point} class also has property {@code tangle}
 * which specify inclination of line crossing OX and connecting this {@code Point}
 * with the lowest point in the plane.
 */

public final class Point implements Comparable<Point>{
    private double x;
    private double y;
    private double tangle;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Don't let anyone instantiate this class with empty coordinates.
     */
    private Point() {}

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setTangle(double tangle) {
        this.tangle = tangle;
    }

    public double getTangle() {
        return tangle;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", tangle=" + tangle +
                '}';
    }

    /**
     * Determines whether or not two points are equal.
     * Two instances of Point are equal if the values
     * of their x and y member fields, representing their
     * position in the coordinate space, are the same.
     *
     * @param o - an object to be compared with this Point2D
     * @return true if the object to be compared is an instance
     * of Point and has the same values (only x and y coordinates are compared); false otherwise.
     */
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(tangle);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public int compareTo(Point o) {
        return Double.compare(y, o.getY());
    }
}
