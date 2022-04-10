import java.util.*;
public class GreedyPath extends Path
{
    Point[] extendPoints;
    Point[] greedyPath;
    ArrayList<Point>visited=new ArrayList<>();
    double upperX,upperY;
    double lowerX,lowerY;
    public GreedyPath(String fileName)
    {
        super(fileName);
        extendPoints=getPoints();
        extendPoints=greedyPath();
    }
    public Point getUpper()
    {
        Point upper=new Point(getMaxX(),getMaxY());
        return upper;
    }
    public Point getLower()
    {
        Point lower=new Point(getMinX(),getMinY());
        return lower;
    }
    public Point[] greedyPath()
    {
        boolean change=false;
        visited.add(extendPoints[0]);
        visited.add(closestPoint(extendPoints[0]));
        Point tempClose;
        for(int i=1;i<extendPoints.length-1;i++)
        {
            tempClose=closestPoint(visited.get(i));
            for(int y=0;y<visited.size();y++)
            {
                if(tempClose.equals(visited.get(y)))
                {
                    change=false;
                    break;
                }
                else
                {
                    change=true;
                }
            }
            if(change==true)
            {
                visited.add(tempClose);
            }
        }
        greedyPath=new Point[visited.size()];
        for(int g=0;g<visited.size();g++)
        {
            greedyPath[g]=visited.get(g);
        }
        this.greedyPath=greedyPath;
        return greedyPath;
    }
    public double getDistance()
    {
        double totalDist=0;
        double tempDist;
        for(int i=0;i<greedyPath.length-1;i++)
        {
            tempDist=greedyPath[i].getDistance(greedyPath[i+1]);
            totalDist+=tempDist;
        }
        return totalDist; //replace
    }
    public Point getPoint(int i)
    {
        return greedyPath[i];
    }
    public Point closestPoint(Point a)
    {
        int closest=0;
        boolean change=false;
        double tempDist=1000000000;
        for(int i=0;i<extendPoints.length;i++)
        {
            if(tempDist>a.getDistance(extendPoints[i]) && a.getDistance(extendPoints[i])!=0)
            {
                for(int y=0;y<visited.size();y++)
                {
                    if(extendPoints[i].equals(visited.get(y)))
                    {
                        change=false;
                        break;
                    }
                    else
                    {
                        change=true;
                    }
                }
                if(change==true)
                {
                    tempDist=a.getDistance(extendPoints[i]);
                    closest=i;
                }
            }
        }
        return extendPoints[closest];
    }
    
    public String toString()
    {
        return "The points on greedy path are " + Arrays.toString(greedyPath);
    }
}
