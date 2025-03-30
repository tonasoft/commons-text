package org.apache.commons.text;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringEscapeUtils_BoundaryTest {

    @Test
    void testEscapeEmptyString() {
        String input = "";
        String result = StringEscapeUtils.escapeHtml4(input);
        assertEquals("", result);
    }

    @Test
    void testEscapeSingleChar() {
        String input = "<";
        String result = StringEscapeUtils.escapeHtml4(input);
        assertEquals("&lt;", result);
    }

    @Test
    void testEscapeCommonHtml() {
        String input = "<div>Hello & Goodbye</div>";
        String result = StringEscapeUtils.escapeHtml4(input);
        assertEquals("&lt;div&gt;Hello &amp; Goodbye&lt;/div&gt;", result);
    }

    @Test
    void testEscapeLargeInput() {
        // Java 8 compatible: use StringBuilder instead of repeat()
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 333; i++) {
            builder.append("<>&");
        }
        builder.append("<");
        String input = builder.toString();

        String result = StringEscapeUtils.escapeHtml4(input);
        assertTrue(result.length() > input.length());
    }
}
