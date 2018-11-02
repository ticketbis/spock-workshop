package com.ticketbis.workshop.library

import groovy.transform.CompileStatic

@CompileStatic
class Book {

    String isbn
    String title
    String author
    Status status
    String dateCreated

    static enum Status {
        AVAILABLE,
        UNAVAILABLE
    }

}
