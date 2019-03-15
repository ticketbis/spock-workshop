package com.ticketbis.workshop

import com.ticketbis.workshop.library.Book
import com.ticketbis.workshop.library.BookLoader
import com.ticketbis.workshop.library.Library
import com.ticketbis.workshop.library.TimeService
import groovy.json.JsonSlurper
import groovy.json.internal.LazyMap
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
    List<Book> books

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
    def "Should load in the library a list of books, using a file"() {
        given: "a mocked library"
        Library library = Mock() {
            _ * getBooks() >> []
        }

        and: "a book loader"
        BookLoader bookLoader = new BookLoader(library)

        when: "a list of books is loaded"
        bookLoader.register(books)

        then: "the library should have all the books registered"
        4 * library.register(_ as Book)
    }

    /**
     * <p>TODO Write a feature method for {@link Library#setTime(Book)}
     * in order to check that when we set a time for a given book, the book creation
     * date is updated.</p>
     *
     * NOTE: You will need to Stub {@link TimeService#getNow()}
     */
    def "Should update book creation date when we set its time on the library"() {
        given: "a book"
        Book book = new Book()

        and: "a library with a stubbed getNow method"
        TimeService timeService = Stub(TimeService) {
            getNow() >> "Now"
        }
        Library library = new Library(timeService: timeService)

        when:
        library.setTime(book)

        then:
        book.dateCreated == "Now"
    }

    private List<Book> getBookList(URL booksResource) {
        new JsonSlurper().parse(booksResource).books.collect { LazyMap lM -> lM as Book }
    }

}
