package com.kodilla.rest.controller;

import com.kodilla.rest.domain.BookDto;
import com.kodilla.rest.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BookControllerTest {

    @Test
    void shouldFetchBooks() {
        //given
        BookService bookServiceMock= Mockito.mock(BookService.class);
        BookController bookController= new BookController(bookServiceMock);
        List<BookDto> booksList = new ArrayList<>();
        booksList.add(new BookDto("Title 1", "Author 1"));
        booksList.add(new BookDto("Title 2", "Author 2"));
        Mockito.when(bookServiceMock.getBooks()).thenReturn(booksList);
        //when
        List<BookDto> result = bookController.getBooks();
        //then
        assertThat(result).hasSize(2);
    }

    @Test
    void shouldAddBook() {
        //given
        BookService bookServiceMock= Mockito.mock(BookService.class);
        BookController bookController= new BookController(bookServiceMock);
        BookDto book = new BookDto("New Title", "New Author");
        //when
        bookServiceMock.addBook(book);
        //then
        Mockito.verify(bookServiceMock, Mockito.times(1)).addBook(book);
    }
}