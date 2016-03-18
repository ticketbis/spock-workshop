package com.ticketbis.workshop.library


class BookLoader {

    Library library

    BookLoader(Library library) {
        this.library = library
    }

    def register(def books) {
        books.collect { book ->
            if (isNotRegistered(book)) {
                library.register(new Book(
                        title: book.title,
                        author: book.author,
                        isbn: book.isbn))
            }
        }
    }

    private boolean isNotRegistered(book) {
        !library.books.find { it.isbn == book.isbn }
    }

}
