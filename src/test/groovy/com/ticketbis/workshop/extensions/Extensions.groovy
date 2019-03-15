package com.ticketbis.workshop.extensions

import spock.lang.*
import spock.util.mop.Use

import java.util.concurrent.TimeUnit

@Narrative("""
Documentation link:
http://spockframework.github.io/spock/docs/1.0/extensions.html
""")
@Stepwise
class Extensions extends Specification {

    @Ignore
    def "Should not be executed"() {
        expect:
        false
    }

    //@IgnoreRest
    def "Should be the only one executed"() {
        expect:
        true
    }

    @IgnoreIf({ System.getProperty("os.name").contains("windows") })
    def "I'll run everywhere but on Windows"() {
        expect:
        !System.getProperty("os.name").contains("windows")
    }

    @Requires({ os.macOs })
    def "I'll only run on Mac os"() {
        expect:
        System.getProperty("os.name").contains("Mac")
    }

    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    def "I fail if I run for more than half a second"() {
        when:
        sleep(100)

        then:
        true
    }

    @Use(ListExtensions)
    def "Should use avg() method"() {
        expect:
        [1, 2, 3].avg() == 2
    }

    def "Should fail and stop the specification execution due to stepwise annotation"() {
        expect:
        false
    }

    def "Should not be executed if specification is annotated with stepwise"() {
        expect:
        true
    }

}

class ListExtensions {
    static avg(List list) { list.sum() / list.size() }
}
