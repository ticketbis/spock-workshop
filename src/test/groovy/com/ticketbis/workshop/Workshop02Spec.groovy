package com.ticketbis.workshop

import com.ticketbis.workshop.library.Book
import com.ticketbis.workshop.library.BookLoader
import com.ticketbis.workshop.library.Library
import groovy.json.JsonSlurper
import spock.lang.Specification


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
    
    /**
     * <p>TODO Write a feature method for {@link Library#register(Book)}
     * in order to check that when we register a book it would be available to borrow.</p>
     */


    /**
     * <p>TODO Write a feature method for {@link Library#borrow(Book)}
     * in order to check that when we borrow a book it would be unavailable to borrow.</p>
     */


    /**
     * <p>TODO Write a feature method for {@link Library#borrow(Book)}
     * in order to check that when we try to borrow an unavailable book it would throw
     * an UnsupportedOperationException.</p>
     */


    /**
     * <p>TODO Write a feature method for {@link BookLoader#register(Book)}
     * in order to check that when we load a given list of books all of them are registered.</p>
     *
     * <p>You will need to use the provide resource books.json file.</p>
     */


    /**
     * <p>TODO Write a feature method for {@link BookLoader#register(Book)}
     * in order to check that when we load a given list of books and one of them is already
     * registered in the library, all the books would be registered except the repeated one.</p>
     *
     * <p>You will need to use the provide resource books.json file.</p>
     */


    private getBookList() {
        URL booksResource = this.getClass().getClassLoader().getResource("books.json")
        new JsonSlurper().parse(booksResource).books
    }

}
