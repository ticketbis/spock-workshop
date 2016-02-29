package com.ticketbis.workshop.library


class Library {

    List<Book> books = []

    def registerBook(Book book) {
        book.status = Book.Status.AVAILABLE
        books << book
    }
}
