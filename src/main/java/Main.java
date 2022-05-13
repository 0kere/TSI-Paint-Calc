import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        double wallSize, excludeSize, bucketSize, bucketCoverage, nBuckets, coats;
        Scanner input = new Scanner(System.in);
        List<String> wallsOutput = new ArrayList<String>();

        int nWalls = 0;
        while(nWalls == 0)
        {
            System.out.println("How many walls are we calculating?");
            nWalls = input.nextInt();
            if (nWalls == 0)
            {
                System.out.println("Are you sure there aren't any walls?");
            }
        }
        for (int i = 0; i < nWalls; i++)
        {
            System.out.println("Wall "+(i+1)+":\nWhat is the length of the wall? (in meters)");
            wallSize = input.nextDouble(); //store length
            System.out.println("What is the width of the wall? (in meters)");
            wallSize *= input.nextDouble(); //times length by width for area

            System.out.println("How many areas to exclude are there? (e.g. doors, windows, sockets)");
            int excludeAreas = input.nextInt();
            excludeSize = 0;
            for (int j = 0; j < excludeAreas; j++)
            {
                System.out.println("Area "+(j+1)+":");
                double thisArea;
                System.out.println("What is the length of the area that you would like to exclude? (in meters)");
                thisArea = input.nextDouble();
                System.out.println("What is the width of the area that you would like to exclude? (in meters)");
                thisArea *= input.nextDouble();
                excludeSize += thisArea;
            }

            System.out.println("What is the coverage of the paint in m^2 per litre that you are using?");
            bucketCoverage = input.nextDouble();
            System.out.println("How many litres can your buckets hold?");
            bucketSize = input.nextDouble();
            System.out.println("How many coats will be needed?");
            coats = input.nextDouble();

            nBuckets = ((wallSize - excludeSize)*coats / bucketCoverage) / bucketSize;
            wallsOutput.add("The area to cover for wall "+(i+1)+" is "+(wallSize-excludeSize)+"m^2 and you will need " + nBuckets + " bucket(s) to apply "+coats+" coat(s) to the wall.");
        }

        for (String item : wallsOutput)
        {
            System.out.println(item);
        }
    }
}
