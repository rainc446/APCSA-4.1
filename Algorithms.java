import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Algorithms {
    private static File f;
    private static Scanner s;
    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        f = new File("Numbers.txt");
        int odds = odds();
        int evens = evens();
        int tens = twoDigits();
        int greaterThan = moreThanFiveHundred();
        int max = max();
        int min = min();
        int sum = sum();
        double average = average();
        double mode = mode();

        System.out.println(odds);
        System.out.println(evens);
        System.out.println(tens);
        System.out.println(greaterThan);
        System.out.println(max);
        System.out.println(min);
        System.out.println(sum);
        System.out.println(average);
        System.out.println(mode);
        s.close();

        long endTime = System.currentTimeMillis();  // Get the end time
        long duration = endTime - startTime;      // Calculate the runtime duration

        System.out.println("Runtime: " + duration + " milliseconds");  // Output the runtime


    }

    public static int odds() throws FileNotFoundException{
        s = new Scanner(f);
        int odds = 0;
        while (s.hasNext()) {
            if (s.nextInt() % 2 != 0)
                odds++;
        }
        return odds;
    }

    public static int evens() throws FileNotFoundException{
        s = new Scanner(f);
        int evens = 0;
        while (s.hasNext()) {
            if (s.nextInt() % 2 == 0)
                evens++;
        }
        return evens;
    }

    public static int twoDigits() throws FileNotFoundException{
        s = new Scanner(f);
        int twoDigits = 0;
        while (s.hasNext()) {
            if (s.nextInt() >=10 && s.nextInt() < 1000)
                twoDigits++;
        }
        return twoDigits;
    }

    public static int moreThanFiveHundred() throws FileNotFoundException{
        s = new Scanner(f);
        int fiveHundredPlus = 0;
        while (s.hasNext()) {
            if (s.nextInt() > 500)
                fiveHundredPlus++;
        }
        return fiveHundredPlus;
    }


    public static int max() throws FileNotFoundException{
        s = new Scanner(f);
        int max = 0;
        int nextNum = s.nextInt();
        while (s.hasNext()) {
            if (nextNum > max)
                max = nextNum;
            nextNum = s.nextInt();
        }
        return max;
    }

    public static int min() throws FileNotFoundException{
        s = new Scanner(f);
        int min = Integer.MAX_VALUE;
        int nextNum = s.nextInt();
        while (s.hasNext()) {
            if (nextNum < min)
                min = nextNum;
            nextNum = s.nextInt();
        }
        return min;
    }

    public static double average() throws FileNotFoundException{
        s = new Scanner(f);
        double sum = 0;
        int nums = 0;
        double average;
        while (s.hasNext()) {
            sum += s.nextInt();
            nums++;
        }
        average = Math.round(sum/nums * 1000) / 1000.0;
        return average;
    }

    public static int sum() throws FileNotFoundException{
        s = new Scanner(f);
        int sum = 0;
        while (s.hasNext()){
            sum += s.nextInt();
        }
        return sum;
    }

    public static double mode() throws FileNotFoundException{
        s = new Scanner(f);
        int nextInt;
        boolean inHashMap = false;
        int instances = 0;
        int modeNums = 0;
        double numOfModes = 0;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        while (s.hasNext()){
            nextInt = s.nextInt();
            //checks if the number is stored as a key in the frequencyMap
            for (int i : frequencyMap.keySet()) {
                if (nextInt == i) {
                    frequencyMap.put(i, frequencyMap.get(i) + 1); //adds one the frequency of the number being checked
                    inHashMap = true;
                }
            }
            //if nextInt is not in the Hashmap then it will be added
            if (inHashMap){
                inHashMap = false;
            }
            else {
                frequencyMap.put(nextInt, 1);
            }
        }
        for (int i : frequencyMap.keySet()) //finding the largest frequency of numbers
        {
            if (frequencyMap.get(i) > instances) instances = frequencyMap.get(i);
        }
        for (int i : frequencyMap.keySet()) //finding the numbers that appear the most
        {
            if (frequencyMap.get(i) == instances)
            {
                modeNums += i;
                numOfModes++;
            }
        }
        return modeNums / numOfModes;
    }
}