package solutions.kyu6.theTrainDriver;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class KataTest {

    @Test
    void testSingleDestination() {
        String[] route = { "Crystalium" };
        String departureTime = "10:00";
        String expected = "12:15";
        String result = Kata.arrivalTime(route, departureTime);
        String msg = "Input: " + Arrays.toString(route) + ", " + departureTime;
        assertEquals(expected, result, msg);
    }

    @Test
    void testMultipleDestinations() {
        String[] route = { "Crystalium", "Skyport", "Oasis" };
        String departureTime = "10:00";
        String expected = "17:45";
        String result = Kata.arrivalTime(route, departureTime);
        String msg = "Input: " + Arrays.toString(route) + ", " + departureTime;
        assertEquals(expected, result, msg);
    }

    @Test
    void testDepartingFromMidnight() {
        String[] route = { "Nexus", "Skyport", "Oasis" };
        String departureTime = "21:30";
        String expected = "09:15";
        String result = Kata.arrivalTime(route, departureTime);
        String msg = "Input: " + Arrays.toString(route) + ", " + departureTime;
        assertEquals(expected, result, msg);
    }

    @Test
    void testNoDestinations() {
        String[] route = {};
        String departureTime = "12:00";
        String expected = "The Train Driver has the day off";
        String result = Kata.arrivalTime(route, departureTime);
        String msg = "Input: " + Arrays.toString(route) + ", " + departureTime;
        assertEquals(expected, result, msg);
    }

    @Test
    void testOasisNexus(){
        String[] route = {"Oasis", "Nexus"};
        String departureTime = "06:30";
        String expected = "17:20";
        String result = Kata.arrivalTime(route, departureTime);
        String msg = "Input: " + Arrays.toString(route) + ", " + departureTime;
        assertEquals(expected, result, msg);
        assertEquals("17:20", result, msg);
    }

}