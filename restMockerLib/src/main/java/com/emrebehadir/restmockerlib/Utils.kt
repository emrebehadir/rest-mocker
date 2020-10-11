package com.emrebehadir.restmockerlib

import com.emrebehadir.restmockerlib.annotations.Mocker

/**
 * Annotation extension filters rest mocker annotation.
 */
fun Array<Annotation>.filterMockerAnnotation(): List<Annotation> {
    return this.filterIsInstance<Mocker>()
}