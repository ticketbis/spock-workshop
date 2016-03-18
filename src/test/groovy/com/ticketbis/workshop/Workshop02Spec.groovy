package com.ticketbis.workshop

import com.ticketbis.workshop.library.Book
import com.ticketbis.workshop.library.BookLoader
import com.ticketbis.workshop.library.Library
import groovy.json.JsonSlurper
import spock.lang.Shared
import spock.lang.Specification

import static com.ticketbis.workshop.library.Book.Status.AVAILABLE
import static com.ticketbis.workshop.library.Book.Status.UNAVAILABLE

/**
 * Second set of exercises for the Spock workshop. All you need
 * to do is write some feature methods to verify the behaviour of the methods
 * in {@link Library} and {@link BookLoader} classes. No mocking is required, but you will need
 * to use setup and setupSpec methods.
 *
 *
 * Also you will need to use the provide resource books.json file.
 */
class Workshop02Spec extends Specification {

    Library library

    @Shared
    def books

    def setupSpec() {
        URL booksResource = this.getClass().getClassLoader().getResource("books.json")
        books = getBookList(booksResource)
    }

    def setup() {
        library = new Library()
    }

    /**
     * <p>TODO Write a feature method for {@link Library#register(Book)}
     * in order to check that when we register a book it would be available to borrow.</p>
     */
    def "When I register a book it should be available"() {
        given: "a book"
        Book book = new Book()

        when: "adding a book to a library"
        library.register(book)

        then: "library has one book available"
        library.books.first().status == AVAILABLE
    }

    /**
     * <p>TODO Write a feature method for {@link Library#borrow(Book)}
     * in order to check that when we borrow a book it would be unavailable to borrow.</p>
     */
    def "When I borrow a book it should be unavailable"() {
        given: "a book registered in the library"
        Book book = new Book(isbn: "123", status: AVAILABLE)
        library.books << book

        when: "I borrow a book"
        Book borrowedBook = library.borrow(book)

        then: "a book should be unavailable"
        library.books.contains(borrowedBook)
        borrowedBook.status == UNAVAILABLE
    }

    /**
     * <p>TODO Write a feature method for {@link Library#borrow(Book)}
     * in order to check that when we try to borrow an unavailable book it would throw
     * an UnsupportedOperationException.</p>
     */
    def "When I try to borrow an unavailable book it will throw an exception"() {
        given: "a book registered in the library"
        Book book = new Book(isbn: "123", status: UNAVAILABLE)
        library.books << book

        when: "I borrow a book"
        library.borrow(book)

        then: "a book should be unavailable"
        thrown UnsupportedOperationException
    }

    /**
     * <p>TODO Write a feature method for {@link BookLoader#register(Book)}
     * in order to check that when we load a given list of books all of them are registered.</p>
     *
     * <p>You will need to use the provide resource books.json file.</p>
     */
    def "Should load a list of books using a file" () {
        given: "a book loader"
        BookLoader bookLoader = new BookLoader(library)

        when: "a list of books is loaded"
        bookLoader.register(books)

        then: "the library should have all the books registered"
        library.books.size() == old(library.books.size()) + 4
    }

    /**
     * <p>TODO Write a feature method for {@link BookLoader#register(Book)}
     * in order to check that when we load a given list of books and one of them is already
     * registered in the library, all the books would be registered except the repeated one.</p>
     *
     * <p>You will need to use the provide resource books.json file.</p>
     */
    def "Should load a list of books using a file adding only the new ones" () {
        given: "a book loader"
        BookLoader bookLoader = new BookLoader(library)

        and: "a book that is in the file is previously registered"
        def repeatedBook = new Book(title: "Other title", author: "Joshua Bloch", isbn: "0321356683")
        library.register(repeatedBook)

        when: "a list of books is loaded"
        bookLoader.register(books)

        then: "the library should register only not repeated books"
        library.books.size() == old(library.books.size()) + 3
        repeatedBook in library.books
    }

    private getBookList(URL booksResource) {
        new JsonSlurper().parse(booksResource).books
    }

}
