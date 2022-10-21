package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static

    public static void oneMonthCalendar(int days, int firstDay)
    {
        int counter = 0;
        int firstSplit = 7 - firstDay;

        for (int i = 0; i < firstDay - 1; i++)
        {
            System.out.print("   ");
        }

        for (int i = 0; i < days; i++)
        {
            System.out.printf(String.format("%2d", (i + 1)) + " ");
            if (i == firstSplit)
            {
                counter = 7;
            }

            if (counter % 7 == 0 && counter >= 7)
            {
                System.out.println();
            }

            if (i + 1 == days && counter % 7 != 0)
            {
                System.out.println();
            }

            counter++;
        }
    }

    public static long[] lcg(long seed)
    {
        long m = ((long) Math.pow(2, 31));
        int a = 1103515245;
        int c = 12345;

        long[] result = new long[10];

        for (int i = 0; i < 10; i++)
        {
            if (i == 0)
            {
                result[i] = (a * seed + c) % m;
            }
            else
            {
                result[i] = (a * result[i-1] + c) % m;
            }
        }
        return result;
    }

    public static void guessingGame(int numberToGuess) {
        int numberOfTries = 10;
        int counter = 1;

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < numberOfTries; i++)
        {
            System.out.print("Guess number " + counter + ": ");
            int guessedNumber = scanner.nextInt();

            if (guessedNumber == numberToGuess)
            {
                System.out.println("You won wisenheimer!");
                break;
            }
            else
            {
                if (i + 1 == numberOfTries)
                {
                    System.out.println("You lost! Have you ever heard of divide & conquer?");
                    break;
                }
                if (guessedNumber > numberToGuess)
                {
                    System.out.println("The number AI picked is lower than your guess.");
                }
                else {
                    System.out.println("The number AI picked is higher than your guess.");
                }
            }
            counter++;
        }
    }

    public static int randomNumberBetweenOneAndHundred()
    {
        Random rdm = new Random();

        return rdm.nextInt(100-1+1) + 1;
    }

    public static boolean swapArrays(int[] firstArray, int[] secondArray)
    {
        if (firstArray.length != secondArray.length)
        {
            return false;
        }

        int[] copySecondArray = new int[secondArray.length];
        System.arraycopy(secondArray, 0, copySecondArray, 0, secondArray.length);

        for (int i = 0; i < firstArray.length; i++)
        {
            secondArray[i] = firstArray[i];
            firstArray[i] = copySecondArray[i];
        }
        return true;
    }

    public static String camelCase(String sentence)
    {
        char[] sentenceChars = sentence.toCharArray();
        char[] sentenceCharsFiltered = new char[sentenceChars.length];
        int count = 1;

        if(sentenceChars[0] >= 97 && sentenceChars[0] <= 122)
        {
            sentenceCharsFiltered[0] = (sentenceChars[0] -= 32);
        }

        for (int i = 1; i < sentenceChars.length; i++)
        {
            if ((sentenceChars[i] >= 65 && sentenceChars[i] <= 90) || (sentenceChars[i] >= 97 && sentenceChars[i] <= 122))
            {
                if((sentenceChars[i] >= 97 && sentenceChars[i] <= 122) && sentenceChars[i-1] == 32)
                {
                    sentenceCharsFiltered[count] = (sentenceChars[i] -= 32);
                    count++;
                }
                else if((sentenceChars[i] >= 65 && sentenceChars[i] <= 90) && sentenceChars[i-1] != 32 )
                {
                    sentenceCharsFiltered[count] = (sentenceChars[i] += 32);
                    count++;
                }
                else
                {
                    sentenceCharsFiltered[count] = sentenceChars[i];
                    count++;
                }
            }
        }

        char[] result = new char[count];

        System.arraycopy(sentenceCharsFiltered, 0, result, 0, count);

        return new String(result);
    }

    public static int checkDigit (int[] digitToCheck)
    {
        int result;
        int sum = 0;
        int weighting = 2;

        for (int i = 0; i < digitToCheck.length; i++)
        {
            sum += digitToCheck[i] * (i + weighting);
        }

        int mod = sum % 11;

        result = 11 - mod;

        if (result == 10)
        {
            result = 0;
        }

        if (result == 11)
        {
            result = 5;
        }
        return result;
    }

    public static void main(String[] args) {
        oneMonthCalendar(28,3);

        System.out.println();

        guessingGame(randomNumberBetweenOneAndHundred());

        System.out.println();

        long[] test = lcg(1);
        for (int i = 0; i < test.length; i++)
        {
            System.out.println(test[i]);
        }

        System.out.println();
    }
}