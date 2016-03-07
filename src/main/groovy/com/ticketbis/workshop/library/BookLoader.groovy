package com.ticketbis.workshop.library

class BookLoader {

    Library library

    BookLoader(Library library) {
        this.library = library
    }

    def register(def json) {

        return json.books.collect { book ->
            library.register(new Book(
                    title: book.title,
                    author: book.author,
                    isbn: book.isbn))
        }
    }

}
