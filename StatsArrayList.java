import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StatsArrayList {
    public static void main(String[] args) throws FileNotFoundException {
        //put the file in the Stats/csv folder and change the name of the path then hit run and enjoy

        //variables
        Scanner csvReader = new Scanner(new File("/Users/jaylenturner/Desktop/data_564705349.csv"));


        csvReader.useDelimiter(",| |\\n");
        boolean moreStuffLeft = true;


        //populating the array list
        ArrayList<Double> array = new ArrayList<>();

        for (int i = 0; moreStuffLeft == true; i++){
            String str = csvReader.nextLine();

            if (str.startsWith("\"")){
                str = str.substring(1,str.length() - 1);
            }

            if (!str.equals("")){
                array.add(Double.parseDouble(str));
            }
            moreStuffLeft = csvReader.hasNext();
        }
        csvReader.close();

        //first step sort
        Collections.sort(array);

        //printing the array list
        System.out.print("Data Set: ");
        for (int i = 0; i < array.size() - 1; i++){
            System.out.print(array.get(i) + ",");
        }
        System.out.println(array.get(array.size() - 1));


        //finding mean
        double mean = 0;
        for (int i = 0; i <array.size(); i++){
            mean += array.get(i);
        }
        mean = mean / array.size();


        //finding median
        double median = 0;
        if (array.size() % 2 != 0){
            median = (double) array.get(array.size() / 2);
        }else {
            median = (double) (array.get(((array.size() - 1) / 2)) + array.get((array.size() / 2))) / 2.0;
        }


        //finding mode
        double mode = mode(array, array.size());


        //finding midrange
        double midrange = (double)(array.get(array.size() - 1) + array.get(0)) / 2;


        //range
        double range = array.get(array.size() - 1) - array.get(0);


        //range rule of thumb to calculate SD calculation
        double ruleOfThumb = range / 4;


        //this is when it changes what is in the index of the array


        //finding variance
        double firstSum = 0;
        for (int i = 0; i < array.size(); i++){
            firstSum += array.get(i);
            array.set(i, array.get(i) * array.get(i));
        }


        //finding sum
        double sum = 0;
        for (int i = 0; i < array.size(); i++){
            sum += array.get(i);
        }


        //sample variance equation
        double SampleEqn = ((array.size() * sum) - Math.pow(firstSum,2)) / (array.size() * (array.size() - 1));

        //population variance equation
        double PopEqn = ((array.size() * sum) - Math.pow(firstSum,2)) / (array.size() * (array.size()));


        //sample standard deviation
        double SampleSD = Math.sqrt(SampleEqn);

        //population variance equation
        double PopSD = Math.sqrt(PopEqn);


        //coefficient of variation
        double sampleCoefficientOfVariationFormula = SampleSD / mean;

        //population coefficient of variation
        double popCoefficientOfVariation = PopSD / mean;


        //printing
        System.out.println();

        //Printing the amount of numbers your working with
        System.out.println("N: " + array.size());
        
        System.out.println("Mean: " + mean);
        System.out.println("Median: " + median);
        System.out.println("Mode: " + mode);
        System.out.println("Range: " + range);
        System.out.println("Midrange: " + midrange);
        System.out.println("Sample Variance: " + SampleEqn);
        System.out.println("Population Variance: " + PopEqn);
        System.out.println("Sample Standard Deviation: " + SampleSD);
        System.out.println("Population Standard Deviation: " + PopSD);
        System.out.println("Range Rule of Thumb: " + ruleOfThumb);
        System.out.println("Sample Coefficient of Variation: " + sampleCoefficientOfVariationFormula);
        System.out.println("Population Coefficient of Variation: " + popCoefficientOfVariation);

    }


    static double mode(ArrayList<Double> a, int n) {
        double maxValue = 0;
        int maxCount = 0, i, j;

        for (i = 0; i < n; ++i) {
            int count = 0;
            for (j = 0; j < n; ++j) {
                if (a.get(j).equals(a.get(i)))
                    ++count;
            }

            if (count > maxCount) {
                maxCount = count;
                maxValue = a.get(i);
            }
            if (maxValue == 1){
                return -1000;
            }
        }
        return maxValue;
    }
}
