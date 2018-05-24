package com.ticketbis.workshop.library

import groovy.transform.CompileStatic

@CompileStatic
class BookLoader {

    Library library

    BookLoader(Library library) {
        this.library = library
    }

    def register(List<Book> books) {
        books.collect { book ->
            if (isNotRegistered(book)) {
                library.register(new Book(
                        title: book.title,
                        author: book.author,
                        isbn: book.isbn))
            }
        }
    }

    private boolean isNotRegistered(Book book) {
        !library.books.find { it.isbn == book.isbn }
    }

}
