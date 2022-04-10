import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Path
{
    private Point[] points;
    private double  minX, minY; //min X and Y values, for setting canvas scale
    private double  maxX, maxY; //maxes

    /** construct a path from a given file */
    public Path(String fileName)
    {
        File file=new File(fileName);
        try
        {
            Scanner sc=new Scanner(file);
            int count=0;
            int count1=0;
            while(sc.hasNextLine())
            {
                if(count==0)
                {
                    points=new Point[sc.nextInt()];
                    sc.nextLine();
                }
                else
                {
                    String line=sc.nextLine().trim();
                    String[] pointSplit=line.split("\\s+");
                    points[count1]=new Point(Double.parseDouble(pointSplit[0]),Double.parseDouble((pointSplit[1])));
                    count1++;
                }
                count++;
            }
        }
        catch (java.io.FileNotFoundException fnfe)
        {
            fnfe.printStackTrace();
        }
        
    }
    public Point[] getPoints()
    {
        return points;
    }
    public int getNumPoints()
    {
        return points.length;
    }
    public double getMaxX()
    {
        double MaxX=points[0].getX();
        for(int i=1;i<points.length;i++)
        {
            if(points[i].getX()>MaxX)
            {
                MaxX=points[i].getX();
            }
        }
        maxX=MaxX;
        return maxX;
    }
    public double getMinX()
    {
        double MinX=points[0].getX();
        for(int i=1;i<points.length;i++)
        {
            if(points[i].getX()<MinX)
            {
                MinX=points[i].getX();
            }
        }
        minX=MinX;
        return minX;
    }
    public double getMaxY()
    {
        double MaxY=points[0].getY();
        for(int i=1;i<points.length;i++)
        {
            if(points[i].getY()>MaxY)
            {
                MaxY=points[i].getY();
            }
        }
        maxY=MaxY;
        return maxY;
    }
    public double getMinY()
    {
        double MinY=points[0].getY();
        for(int i=1;i<points.length;i++)
        {
            if(points[i].getY()<MinY)
            {
                MinY=points[i].getY();
            }
        }
        minY=MinY;
        return minY;
    }
    public Point getPoint(int i)
    {
        return points[i];
    }
    /** returns the distance traveled going point to point, in order given in file */
    public double getDistance()
    {
        double totalDist=0;
        double tempDist;
        for(int i=0;i<points.length-1;i++)
        {
            tempDist=points[i].getDistance(points[i+1]);
            totalDist+=tempDist;
        }
        return totalDist; //replace
    }

    @Override
    public String toString()
    {
        return "The total distance is " + this.getDistance() + " ,the minimun X-coordinate is " + minX + ",the minimun Y-coordinate is " + minY + " ,the maximum X-coordinate is " + maxX + " ,the maximum Y-coordinate is " + maxY;
    }
}
