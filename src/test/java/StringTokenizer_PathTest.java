package org.apache.commons.text;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StringTokenizer_PathTest {

    @Test
    void testEmptyInput() {
        StringTokenizer tokenizer = new StringTokenizer("");
        assertFalse(tokenizer.hasNext());
    }

    @Test
    void testTrailingDelimiter() {
        StringTokenizer tokenizer = new StringTokenizer("a,", ',');
        assertTrue(tokenizer.hasNext());
        assertEquals("a", tokenizer.next());
        assertFalse(tokenizer.hasNext()); // Avoid NoSuchElementException
    }

    @Test
    void testMultipleTokensCustomDelimiter() {
        StringTokenizer tokenizer = new StringTokenizer("x|y|z", '|');
        assertEquals("x", tokenizer.next());
        assertEquals("y", tokenizer.next());
        assertEquals("z", tokenizer.next());
    }

    @Test
    void testMultipleTokensDefaultDelimiter() {
        StringTokenizer tokenizer = new StringTokenizer("a b c");
        assertEquals("a", tokenizer.next());
        assertEquals("b", tokenizer.next());
        assertEquals("c", tokenizer.next());
    }

    @Test
    void testConsecutiveDelimiters() {
        StringTokenizer tokenizer = new StringTokenizer("a,,b", ',');
        assertEquals("a", tokenizer.next());
        assertEquals("b", tokenizer.next());  // previously missing
        assertFalse(tokenizer.hasNext());
    }

    @Test
    void testSingleToken() {
        StringTokenizer tokenizer = new StringTokenizer("onlyOneToken");
        assertEquals("onlyOneToken", tokenizer.next());
        assertFalse(tokenizer.hasNext());
    }
}
