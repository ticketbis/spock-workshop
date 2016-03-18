package com.ticketbis.workshop


class Exercises {

    double calculateTriangleArea(Double base, Double height) {
        if (hasInvalidTriangleArguments(base, height)) {
            throw new IllegalArgumentException('Not valid arguments')
        }
        (base * height) / 2
    }

    private boolean hasInvalidTriangleArguments(Double base, Double height) {
        !base || !height || base <= 0 || height <= 0
    }

}
