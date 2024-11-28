import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Algorithms {
    private static File f;
    private static Scanner s;
    public static void main(String[] args) throws FileNotFoundException {
        f = new File("Numbers.txt");
        int odds = odds();
        int evens = evens();
        int tens = twoDigits();
        int greaterThan = moreThanFiveHundred();
        int max = max();
        int min = min();
        double average = average();

        System.out.println(odds);
        System.out.println(evens);
        System.out.println(tens);
        System.out.println(greaterThan);
        System.out.println(max);
        System.out.println(min);
        System.out.println(average);

        s.close();
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
        double average = 0;
        while (s.hasNext()) {
            sum += s.nextInt();
            nums++;
        }
        average = Math.round(sum/nums * 1000) / 1000.0;
        return average;
    }
}