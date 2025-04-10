package org.apache.commons.text;

import org.apache.commons.text.RandomStringGenerator.Builder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomStringGenerator_EquivalenceTest {

    @Test
    void testGenerateNegativeLength() {
        RandomStringGenerator generator = new Builder().build();
        assertThrows(IllegalArgumentException.class, () -> generator.generate(-1));
    }

    @Test
    void testGenerateLengthZero() {
        RandomStringGenerator generator = new Builder().build();
        String result = generator.generate(0);
        assertNotNull(result);
        assertEquals(0, result.length());
    }

    @Test
    void testGenerateLengthOne() {
        RandomStringGenerator generator = new Builder()
                .withinRange('a', 'z')  // ? Ensures length matches input
                .build();
        String result = generator.generate(1);
        assertNotNull(result);
        assertEquals(1, result.length());
    }

    @Test
    void testGenerateValidLength() {
        RandomStringGenerator generator = new Builder()
                .withinRange('a', 'z')
                .build();
        String result = generator.generate(10);
        assertNotNull(result);
        assertEquals(10, result.length());
    }
}
