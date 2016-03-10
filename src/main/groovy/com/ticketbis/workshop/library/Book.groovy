package com.ticketbis.workshop.library


class Book {

    String isbn
    String title
    String author
    Status status

    static enum Status {
        AVAILABLE,
        UNAVAILABLE
    }
}
