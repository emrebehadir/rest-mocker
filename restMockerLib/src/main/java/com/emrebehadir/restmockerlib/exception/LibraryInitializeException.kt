package com.emrebehadir.restmockerlib.exception

import java.lang.RuntimeException

class LibraryInitializeException : RuntimeException(){
    override val message: String?
        get() = "Rest mocker library not initialized !!"
}