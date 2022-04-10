import java.util.*;
public class Point 
{
    private double  x, y;
    private boolean visited;
    public Point()
    {
        x=0;
        y=0;
        visited=false;
    }
        public Point(double x, double y)
    {
        this.x=x;
        this.y=y;
    }
    /*
    public boolean hasVisited()
    {
          
    }
    */
    /** get the Euclidean distance between two points */
    public double getX()
    { 
        return x;
    }
    public double getY()
    { 
        return y;
    }
    public double getDistance(Point other)
    {
        return Math.sqrt(Math.pow((other.x-this.x),2) + Math.pow((other.y-this.y),2));
    }    
    @Override
    public String toString()
    {
        return "The point has an x-coordinate of " + x + " and a y-coordinate of " + y;
    }
    public boolean equals(Object obj)
    {
        Point p=(Point)obj;
        if(this.x==p.x && this.y==p.y)
        {
            return true;
        }
        return false;
    }
}
