package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;



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
        // Verifies basic addition without any carry-over. This test is essential for confirming
        // that the fundamental addition logic is accurate when dealing with smaller numbers.
        List<Integer> left = Arrays.asList(2, 3);
        List<Integer> right = Arrays.asList(4, 2);
        List<Integer> expected = Arrays.asList(6, 5);
        assertEquals(expected, NumberUtils.add(left, right), "Adding 23 + 42 should equal 65");
    }

    @Test
    void testAddWithCarry() {
        // Checks the method's ability to handle carries, crucial for correct addition of larger numbers.
        // This test validates the functionality of the addition logic when the sum exceeds the value of 9.
        List<Integer> left = Arrays.asList(5, 5);
        List<Integer> right = Arrays.asList(6, 6);
        List<Integer> expected = Arrays.asList(1, 2, 1);
        assertEquals(expected, NumberUtils.add(left, right), "Adding 55 + 66 should equal 121 with carry");
    }

    @Test
    void testAddWithNullInput() {
        // Tests the method's response to null inputs, ensuring that it handles nulls properly by returning null.
        // It's important to verify the robustness of the method in handling absence of data.
        assertNull(NumberUtils.add(null, Arrays.asList(1, 2)), "Adding null should return null");
        assertNull(NumberUtils.add(Arrays.asList(1, 2), null), "Adding to null should return null");
    }

    @Test
    void testAddWithEmptyList() {
        // Evaluates how the method handles an empty list, which should logically represent zero.
        // This test ensures that adding zero does not alter the outcome of the addition.
        List<Integer> left = Arrays.asList();
        List<Integer> right = Arrays.asList(1, 2, 3);
        List<Integer> expected = Arrays.asList(1, 2, 3);
        assertEquals(expected, NumberUtils.add(left, right), "Adding empty list to 123 should return 123");
    }

    @Test
    void testAddWithLeadingZeros() {
        // Confirms that the method correctly processes inputs with leading zeros, ensuring
        // that these zeros do not affect the computational result of the addition.
        List<Integer> left = Arrays.asList(0, 0, 1);
        List<Integer> right = Arrays.asList(0, 9, 9);
        List<Integer> expected = Arrays.asList(1, 0, 0);
        assertEquals(expected, NumberUtils.add(left, right), "Adding 001 + 099 should handle leading zeros correctly");
    }

    @Test
    void testAddWithInvalidDigits() {
        // Verifies that the method throws an IllegalArgumentException when presented with digits
        // outside the valid range (0-9). This test is crucial for maintaining the integrity of the addition operation.
        List<Integer> left = Arrays.asList(-1, 10, 12);
        List<Integer> right = Arrays.asList(5);
        assertThrows(IllegalArgumentException.class, () -> NumberUtils.add(left, right), "Adding with invalid digits should throw IllegalArgumentException");
    }

    @Test
    void testAddHandlingOfZeros() {
        // Tests the addition of lists comprised solely of zeros. It's important to ensure
        // that the method simplifies the result to a single zero, reflecting correct processing of zero values.
        List<Integer> left = Arrays.asList(0, 0, 0);
        List<Integer> right = Arrays.asList(0, 0, 0);
        List<Integer> expected = Arrays.asList(0);
        assertEquals(expected, NumberUtils.add(left, right), "Adding zeros should return single zero");
    }

    @Test
    void testInputMutability() {
        // Ensures the method reverses the input lists as part of its operation. This test is crucial
        // for documenting the side effect of the method that it alters the input data, which must be considered when used.
        List<Integer> left = Arrays.asList(2, 3);
        List<Integer> right = Arrays.asList(4, 2);
        NumberUtils.add(left, right); // This operation will reverse 'left' and 'right'

        // Verifies if the lists are reversed as expected after the method call
        List<Integer> expectedLeft = Arrays.asList(3, 2); // Lists should be reversed post-operation
        List<Integer> expectedRight = Arrays.asList(2, 4);
        assertEquals(expectedLeft, left, "Input 'left' should be reversed after the operation.");
        assertEquals(expectedRight, right, "Input 'right' should be reversed after the operation.");
    }
}





