package com.ticketbis.workshop

import com.ticketbis.workshop.library.Book

import com.ticketbis.workshop.library.Library
import spock.lang.Specification

import static com.ticketbis.workshop.library.Book.Status.AVAILABLE
import static com.ticketbis.workshop.library.Book.Status.UNAVAILABLE

/**
 * These are the second set of exercises for the Spock workshop. All you need
 * to do is write some feature methods to verify the behaviour of the methods
 * in the {@link Exercises} class. No mocking is required, but you will need
 * to handle exceptions and multiple data sets.
 */
class Workshop02Spec extends Specification {

    Library library

    def setup() {
        library = new Library()
    }

    def "When I register a book it should be available"() {
        given: "a book"
        Book book = new Book()

        when: "adding a book to a library"
        library.register(book)

        then: "library has one book available"
        library.books.first().status == AVAILABLE
    }


    def "when I borrow a book it should be unavailable"() {
        given: "a book registered in the library"
        Book book = new Book(ISBN: "123", status: AVAILABLE)
        library.books << book

        when: "I borrow a book"
        Book borrowedBook = library.borrow(book)

        then: "a book should be unavailable"
        library.books.contains(borrowedBook)
        borrowedBook.status == UNAVAILABLE
    }

    def "when I try to borrow an unavailable book it will throw an exception"() {
        given: "a book registered in the library"
        Book book = new Book(ISBN: "123", status: UNAVAILABLE)
        library.books << book

        when: "I borrow a book"
        library.borrow(book)

        then: "a book should be unavailable"
        thrown UnsupportedOperationException
    }

    //TODO: cargar una lista de libros de un fichero

}
