# Connecting-points-on-the-plane
Input: list of x and y coordinates of point on the plane,  which can be consecutive connected by a closed polygonal line  that has no self-intersections.Return ordered list of points.

Algorithm:
     1. Find the lowest point on the plane.
     2.  Find angle between the X axis and line that connects each point with the lowest point, while crossing X axis.
     3. Sort point in ascending order by angle (if the angle is the same, by distance from point to the lowest point)
     4. Add closed point to ordered list in order to close the polygonal line
     5. Return ordered list of points.
     
 Class {@code PlaneOfPoints} define methods to handle {@code Point}
 
 Methods:
 
 1) arrangePointsOrder(double [][] listOfCoordinates) 
 define list of points with x and y coordinates on the plane, which can be consecutive connected by 
 a closed polygonal line that has no self-intersections.
 @param listOfCoordinates input array of coordinates of points on the plane that need to be connected by polygonal line
 @return list of ordered points
 @throws java.lang.NullPointerException if input list of {@code Point} is empty or null
 
 
Class {@code Point} representing a location in (x,y) coordinate space, specified in double precision.
{@code Point} class also has property {@code tangle} which specify inclination of line crossing OX and connecting this {@code Point} with the lowest point in the plane.
