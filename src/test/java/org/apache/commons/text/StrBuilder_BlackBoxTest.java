package org.apache.commons.text;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrBuilder_BlackBoxTest {

    @Test
    void testReverseEmptyString() {
        StrBuilder builder = new StrBuilder("");
        builder.reverse();
        assertEquals("", builder.toString());
    }

    @Test
    void testReverseSingleCharacter() {
        StrBuilder builder = new StrBuilder("A");
        builder.reverse();
        assertEquals("A", builder.toString());
    }

    @Test
    void testReversePalindrome() {
        StrBuilder builder = new StrBuilder("madam");
        builder.reverse();
        assertEquals("madam", builder.toString());
    }

    @Test
    void testReverseSimpleWord() {
        StrBuilder builder = new StrBuilder("hello");
        builder.reverse();
        assertEquals("olleh", builder.toString());
    }

    @Test
    void testReverseWithSpecialCharacters() {
        StrBuilder builder = new StrBuilder("a@b#c$");
        builder.reverse();
        assertEquals("$c#b@a", builder.toString());
    }
}
