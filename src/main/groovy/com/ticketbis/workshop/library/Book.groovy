package com.ticketbis.workshop.library


class Book {

    String ISBN
    String name
    String author
    Status status

    static enum Status {
        AVAILABLE,
        UNAVAILABLE
    }
}
