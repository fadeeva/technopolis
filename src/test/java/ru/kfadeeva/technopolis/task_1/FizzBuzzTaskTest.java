package ru.kfadeeva.technopolis.task_1;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class FizzBuzzTaskTest {

    private static FizzBuzzTask fizzBuzzTask;
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeClass
    public static void createFizzBuzzTask() {
        fizzBuzzTask = new FizzBuzzTask();
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
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
        fizzBuzzTask.print(1, 1);
    }

    @Test
    public void testFizz() {
        String fizz = "Fizz";
        assertEquals(fizz, fizzBuzzTask.transformNumber(3));
        assertEquals(fizz, fizzBuzzTask.transformNumber(6));
        assertEquals(fizz, fizzBuzzTask.transformNumber(9));
    }

    @Test
    public void testBuzz() {
        String buzz = "Buzz";
        assertEquals(buzz, fizzBuzzTask.transformNumber(5));
        assertEquals(buzz, fizzBuzzTask.transformNumber(10));
        assertEquals(buzz, fizzBuzzTask.transformNumber(20));
    }

    @Test
    public void testFizzBuzz() {
        String fizzBuzz = "FizzBuzz";
        assertEquals(fizzBuzz, fizzBuzzTask.transformNumber(15));
        assertEquals(fizzBuzz, fizzBuzzTask.transformNumber(30));
        assertEquals(fizzBuzz, fizzBuzzTask.transformNumber(45));
    }

    @Test
    public void testNumber() {
        String number = "1";
        assertEquals(number, fizzBuzzTask.transformNumber(1));

        number = "7";
        assertEquals(number, fizzBuzzTask.transformNumber(7));

        number = "79";
        assertEquals(number, fizzBuzzTask.transformNumber(79));
    }

    @Test
    public void testLoop() {
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("1", "2", "Fizz", "4", "Buzz"));
        assertEquals(expected, fizzBuzzTask.print(1, 5));
    }

    @Test
    public void testConsole() {
        String delimiter = "\n";

        fizzBuzzTask.print(1, 1);
        assertEquals("1" + delimiter, output.toString());

        output.reset();

        fizzBuzzTask.print(3, 3);
        assertEquals("Fizz" + delimiter, output.toString());

        output.reset();

        fizzBuzzTask.print(5, 5);
        assertEquals("Buzz" + delimiter, output.toString());

        output.reset();

        fizzBuzzTask.print(15, 15);
        assertEquals("FizzBuzz" + delimiter, output.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}