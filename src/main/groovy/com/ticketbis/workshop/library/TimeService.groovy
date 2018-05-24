package com.ticketbis.workshop.library

import groovy.transform.CompileStatic

@CompileStatic
class TimeService {

    String getNow() {
        def url = "http://www.timeapi.org/utc/now".toURL()
        url.text
    }

}
