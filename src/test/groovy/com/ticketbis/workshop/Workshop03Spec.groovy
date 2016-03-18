package com.ticketbis.workshop

import com.ticketbis.workshop.library.Book
import com.ticketbis.workshop.library.BookLoader
import com.ticketbis.workshop.library.Library
import com.ticketbis.workshop.library.TimeService
import groovy.json.JsonSlurper
import spock.lang.Shared
import spock.lang.Specification


/**
 * Third set of exercises for the Spock workshop. All you need
 * to do is write some tests using Mocks and Stubs.
 * You will need the methods in {@link Library}, {@link BookLoader}
 * and {@link TimeService} classes.
 *
 * Also you will need to use the provide resource books.json file.
 */
class Workshop03Spec extends Specification {

    @Shared
    def books

    def setupSpec() {
        URL booksResource = this.getClass().getClassLoader().getResource("books.json")
        books = getBookList(booksResource)
    }

    /**
     * <p>TODO Write a feature method for {@link BookLoader#register(Book)}
     * in order to check that when we load a given list of books, it interacts
     * with library.register() four times.</p>
     *
     * <p>You will need to use the provide resource books.json file.</p>
     */


    /**
     * <p>TODO Write a feature method for {@link Library#setTime(Book)}
     * in order to check that when we set a time for a given book, the book creation
     * date is updated.</p>
     *
     * NOTE: You will need to Stub {@link TimeService#getNow()}
     */


    private getBookList(URL booksResource) {
        new JsonSlurper().parse(booksResource).books
    }

}
