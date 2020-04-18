package ru.kfadeeva.technopolis.task_1;

public class FizzBuzzTask implements FizzBuzz {

    private static final int FROM = 1;
    private static final int TO = 100;

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzzTask();
        fizzBuzz.print(FROM, TO);
    }

    @Override
    public void print(int from, int to) {
        if(from < to) {
            for(int i = from; i <= to; i++) {
                if(i % 15 == 0) {
                    System.out.println(FIZZ + BUZZ);
                } else if(i % 3 == 0) {
                    System.out.println(FIZZ);
                } else if(i % 5 == 0) {
                    System.out.println(BUZZ);
                } else {
                    System.out.println(i);
                }
            }
        } else {
            System.out.println("Incorrect input.");
        }
    }

    @Override
    public String printWithTest(int number) {
        return null;
    }
}