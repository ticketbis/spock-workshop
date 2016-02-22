package com.ticketbis.workshop

import spock.lang.Specification
import spock.lang.Unroll

/**
 * These are the first set of exercises for the Spock workshop. All you need
 * to do is write some feature methods to verify the behaviour of the methods
 * in the {@link Exercises} class. No mocking is required, but you will need
 * to handle exceptions and multiple data sets.
 */
class Workshop01Spec extends Specification {
    def exercises = new Exercises()

    def "calculate triangle area using the given base and height"() {
        given: "the base and height"
        def base = 3
        def height = 2

        when: "calculate triangle area"
        def area = exercises.calculateTriangleArea(base, height)

        then: "area must be the expected"
        area == 3
    }

    @Unroll
    def "Calculate triangle area using multiple #base and #height data sets"() {
        expect: "triangle area calculate correctly"
        exercises.calculateTriangleArea(base, height) == area

        where:
        base | height || area
        1    | 3      || 1.5
        2    | 2      || 2
        1.4  | 4      || 2.8
    }
}
