package com.kodilla.collections.adv.immutable;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void shouldReturnCorrectAuthorAndTitle() {
        // given
        String expectedAuthor = "George Orwell";
        String expectedTitle = "1984";

        // when
        Book book = new Book(expectedAuthor, expectedTitle);

        // then
        assertEquals(expectedAuthor, book.getAuthor());
        assertEquals(expectedTitle, book.getTitle());
    }

    @Test
    void shouldHandleEmptyStrings() {
        // given
        Book book = new Book("", "");

        // then
        assertEquals("", book.getAuthor());
        assertEquals("", book.getTitle());
    }

    @Test
    void shouldHandleNullValues() {
        // given
        Book book = new Book(null, null);

        // then
        assertNull(book.getAuthor());
        assertNull(book.getTitle());
    }
}