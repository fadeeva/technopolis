package ru.kfadeeva.technopolis.task_1;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class FizzBuzzTaskTest {

    private static FizzBuzzTask fizzBuzzTask;

    @BeforeClass
    public static void createFizzBuzzTask() {
        fizzBuzzTask = new FizzBuzzTask();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectInput() {
        fizzBuzzTask.print(-1, 100);
        fizzBuzzTask.print(1, -100);
        fizzBuzzTask.print(0, 0);
    }

    @Test
    public void testCorrectInput() {
        fizzBuzzTask.print(10, 100);
        fizzBuzzTask.print(3, 3);
    }

    @Test
    public void testFizz() {
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("Fizz"));
        assertEquals(expected, fizzBuzzTask.print(3, 3));
        assertEquals(expected, fizzBuzzTask.print(6, 6));
        assertEquals(expected, fizzBuzzTask.print(9, 9));
    }

    @Test
    public void testBuzz() {
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("Buzz"));
        assertEquals(expected, fizzBuzzTask.print(5, 5));
        assertEquals(expected, fizzBuzzTask.print(10, 10));
        assertEquals(expected, fizzBuzzTask.print(20, 20));
    }

    @Test
    public void testFizzBuzz() {
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("FizzBuzz"));
        assertEquals(expected, fizzBuzzTask.print(15, 15));
        assertEquals(expected, fizzBuzzTask.print(30, 30));
        assertEquals(expected, fizzBuzzTask.print(45, 45));
    }

    @Test
    public void testNumber() {
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("1", "2"));
        assertEquals(expected, fizzBuzzTask.print(1, 2));
    }

    @Test
    public void testLoop() {
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("1", "2", "Fizz", "4", "Buzz"));
        assertEquals(expected, fizzBuzzTask.print(1, 5));
    }
}