package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;





/**
 *
 * Step 1: understand the requirement, input type and output type
 *        Requirement: Add two list of integer, index by index, and returns another list
 *
 * Step 2 (raw):  Perform partition and boundary analysis on input and output
 *        Each input: left | right
 *        Combination of input:
 *        Output:
 *  Step 3: Derive potential test cases
 *
 */


class NumberUtilsTest {

    @Test
    void testAddWithValidDigits() {
        List<Integer> left = Arrays.asList(2, 3);
        List<Integer> right = Arrays.asList(4, 2);
        List<Integer> expected = Arrays.asList(6, 5);
        assertEquals(expected, NumberUtils.add(left, right), "Adding 23 + 42 should equal 65");
    }

    @Test
    void testAddWithCarry() {
        List<Integer> left = Arrays.asList(9, 9);
        List<Integer> right = Arrays.asList(2, 2);
        List<Integer> expected = Arrays.asList(1, 2, 1);
        assertEquals(expected, NumberUtils.add(left, right), "Adding 99 + 22 should equal 121 with carry");
    }

    @Test
    void testAddWithNullInput() {
        assertNull(NumberUtils.add(null, Arrays.asList(1, 2)), "Adding null should return null");
        assertNull(NumberUtils.add(Arrays.asList(1, 2), null), "Adding to null should return null");
    }

    @Test
    void testAddWithEmptyList() {
        List<Integer> left = Arrays.asList();
        List<Integer> right = Arrays.asList(1, 2, 3);
        List<Integer> expected = Arrays.asList(1, 2, 3);
        assertEquals(expected, NumberUtils.add(left, right), "Adding empty list to 123 should return 123");
    }

    @Test
    void testAddWithLeadingZeros() {
        List<Integer> left = Arrays.asList(0, 0, 1);
        List<Integer> right = Arrays.asList(0, 9, 9);
        List<Integer> expected = Arrays.asList(1, 0, 0);
        assertEquals(expected, NumberUtils.add(left, right), "Adding 001 + 099 should handle leading zeros correctly");
    }

    @Test
    void testAddWithInvalidDigits() {
        List<Integer> left = Arrays.asList(-1, 10);
        List<Integer> right = Arrays.asList(1, 2);
        assertThrows(IllegalArgumentException.class, () -> NumberUtils.add(left, right), "Adding with invalid digits should throw IllegalArgumentException");
    }

    @Test
    void testAddHandlingOfZeros() {
        List<Integer> left = Arrays.asList(0, 0, 0);
        List<Integer> right = Arrays.asList(0, 0, 0);
        List<Integer> expected = Arrays.asList(0);
        assertEquals(expected, NumberUtils.add(left, right), "Adding zeros should return single zero");
    }

    @Test
    void testLongerListsWithCarry() {
        List<Integer> left = Arrays.asList(9, 9, 9, 9);
        List<Integer> right = Arrays.asList(1);
        List<Integer> expected = Arrays.asList(1, 0, 0, 0, 0);
        assertEquals(expected, NumberUtils.add(left, right), "Adding 9999 + 1 should handle long list with carry correctly");
    }

    @Test
    void testBothListsEmpty() {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();
        assertEquals(expected, NumberUtils.add(left, right), "Adding two empty lists should return an empty list");
    }

    @Test
    void testInputMutability() {
        List<Integer> left = Arrays.asList(2, 3);
        List<Integer> right = Arrays.asList(4, 2);
        NumberUtils.add(left, right);

        List<Integer> expectedLeft = Arrays.asList(3, 2);
        List<Integer> expectedRight = Arrays.asList(2, 4);
        assertEquals(expectedLeft, left, "Input 'left' should be reversed after the operation.");
        assertEquals(expectedRight, right, "Input 'right' should be reversed after the operation.");
    }

    @Test
    void testExtremeCarry() {
        List<Integer> left = Arrays.asList(9, 9, 9, 9, 9);
        List<Integer> right = Arrays.asList(1);
        List<Integer> expected = Arrays.asList(1, 0, 0, 0, 0, 0);
        assertEquals(expected, NumberUtils.add(left, right), "Adding 99999 + 1 should produce 100000");
    }

    @Test
    void testVariableLengthInputs() {
        List<Integer> left = Arrays.asList(1, 2, 3);
        List<Integer> right = Arrays.asList(9, 8);
        List<Integer> expected = Arrays.asList(2, 2, 1);
        assertEquals(expected, NumberUtils.add(left, right), "Adding 123 + 98 should produce 221");
    }

}





