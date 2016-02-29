package com.ticketbis.workshop

import com.ticketbis.workshop.library.Book

import com.ticketbis.workshop.library.Library
import spock.lang.Specification

/**
 * These are the second set of exercises for the Spock workshop. All you need
 * to do is write some feature methods to verify the behaviour of the methods
 * in the {@link Exercises} class. No mocking is required, but you will need
 * to handle exceptions and multiple data sets.
 */
class Workshop02Spec extends Specification {

    def "When I register a book in the library it should be available"() {
        given: "a library"
        Library library = new Library()

        and: "a book"
        Book book = new Book()

        when: "adding a book to a library"
        library.registerBook(book)

        then: "library has one book available"
        library.books.first().status == Book.Status.AVAILABLE
    }

    //TODO: reservar libro y ver que cambia el estado
    //TODO: ver que no se puede reservar un libro en estado unavailable
    //TODO: cargar una lista de libros de un fichero

}
