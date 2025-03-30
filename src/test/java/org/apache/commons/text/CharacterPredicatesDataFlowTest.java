package org.apache.commons.text;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterPredicatesDataFlowTest {

    // Test case: lowercase alphabetic character (e.g., 'g' => ASCII 103)
    @Test
    void testLowercaseAlphabetic() {
        int codePoint = 'g';
        boolean result = CharacterPredicates.ASCII_ALPHA_NUMERALS.test(codePoint);
        assertTrue(result, "Expected 'g' to be alphanumeric.");
    }

    // Test case: uppercase alphabetic character (e.g., 'Z' => ASCII 90)
    @Test
    void testUppercaseAlphabetic() {
        int codePoint = 'Z';
        boolean result = CharacterPredicates.ASCII_ALPHA_NUMERALS.test(codePoint);
        assertTrue(result, "Expected 'Z' to be alphanumeric.");
    }

    // Test case: numeric character (e.g., '5' => ASCII 53)
    @Test
    void testNumericCharacter() {
        int codePoint = '5';
        boolean result = CharacterPredicates.ASCII_ALPHA_NUMERALS.test(codePoint);
        assertTrue(result, "Expected '5' to be alphanumeric.");
    }

    // Test case: symbol (e.g., '#' => ASCII 35), should return false
    @Test
    void testSymbolCharacter() {
        int codePoint = '#';
        boolean result = CharacterPredicates.ASCII_ALPHA_NUMERALS.test(codePoint);
        assertFalse(result, "Expected '#' not to be alphanumeric.");
    }

    // Test case: non-ASCII character (e.g., 'ñ' => ASCII 241), should return false
    @Test
    void testNonAsciiCharacter() {
        int codePoint = 'ñ';
        boolean result = CharacterPredicates.ASCII_ALPHA_NUMERALS.test(codePoint);
        assertFalse(result, "Expected 'ñ' not to be alphanumeric.");
    }
}
