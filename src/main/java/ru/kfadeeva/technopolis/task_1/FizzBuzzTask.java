package ru.kfadeeva.technopolis.task_1;

import java.util.ArrayList;

public class FizzBuzzTask implements FizzBuzz {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";

    private static final int FIZZ_DIV = 3;
    private static final int BUZZ_DIV = 5;
    private static final int FIZZBUZZ_DIV = 15;

    private static final String DELIMITER = "\n";

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzzTask();
        fizzBuzz.print(LOWER_BOUND, UPPER_BOUND);
    }

    @Override
    public ArrayList<String> print(int from, int to) {
        ArrayList<String> result = new ArrayList<String>();

        if(isArgumentsCorrect(from, to)) {
            for(int i = from; i <= to; i++) {
                if(i % FIZZBUZZ_DIV == 0) {
                    result.add(FIZZ + BUZZ);
                } else if(i % FIZZ_DIV == 0) {
                    result.add(FIZZ);
                } else if(i % BUZZ_DIV == 0) {
                    result.add(BUZZ);
                } else {
                    result.add(String.valueOf(i));
                }
            }
        } else {
            throw new IllegalArgumentException("Incorrect Input. You can better. Try again.");
        }

        printInConsole(result);

        return result;
    }

    public void printInConsole(ArrayList<String> arr) {
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + DELIMITER);
        }
    }

    public Boolean isArgumentsCorrect(int from, int to) {
        return from <= to &&
              (from >= LOWER_BOUND && to >= LOWER_BOUND) &&
              (from <= UPPER_BOUND && to <= UPPER_BOUND);
    }

}