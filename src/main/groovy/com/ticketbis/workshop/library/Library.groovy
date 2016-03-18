package com.ticketbis.workshop.library

import static com.ticketbis.workshop.library.Book.Status.AVAILABLE
import static com.ticketbis.workshop.library.Book.Status.UNAVAILABLE


class Library {

    List<Book> books = []
    TimeService timeService = new TimeService()

    def register(Book book) {
        book.status = AVAILABLE
        books << book
    }

    Book borrow(Book book) {
        Book borrowedBook = books.find { it.isbn == book.isbn }

        if (borrowedBook.status != AVAILABLE) {
            throw new UnsupportedOperationException()
        }

        borrowedBook.status = UNAVAILABLE
        borrowedBook
    }

    Book setTime(Book book) {
        book.dateCreated = timeService.getNow()
        book
    }

}
