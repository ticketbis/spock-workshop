package com.ticketbis.workshop.library


class TimeService {

    String getNow() {
        def url = "http://www.timeapi.org/utc/now".toURL()
        url.text
    }

}
