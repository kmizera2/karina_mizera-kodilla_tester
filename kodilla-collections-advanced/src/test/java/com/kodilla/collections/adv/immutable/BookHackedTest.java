package com.kodilla.collections.adv.immutable;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookHackedTest {

    @Test
    void shouldModifyTitle() {
        // given
        BookHacked book = new BookHacked("J.K. Rowling", "Harry Potter");

        // when
        book.modifyTitle("Hacked Title");

        // then
        assertEquals("Hacked Title", book.getTitle());
    }

    @Test
    void shouldKeepAuthorUnchanged() {
        // given
        BookHacked book = new BookHacked("J.R.R. Tolkien", "The Hobbit");

        // when
        book.modifyTitle("The Lord of the Rings");

        // then
        assertEquals("J.R.R. Tolkien", book.getAuthor());
    }

    @Test
    void shouldAllowEmptyOrNullTitle() {
        // given
        BookHacked book = new BookHacked("Author", "Original Title");

        // when & then
        book.modifyTitle("");
        assertEquals("", book.getTitle());

        book.modifyTitle(null);
        assertNull(book.getTitle());
    }
}