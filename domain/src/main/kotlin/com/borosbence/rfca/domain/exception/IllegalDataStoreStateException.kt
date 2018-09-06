package com.borosbence.rfca.domain.exception

class IllegalDataStoreStateException : RuntimeException() {

    override val cause: Throwable?
        get() = super.cause
    override val message: String?
        get() = "Connection is not available and other data stores couldn't handle the given request."
}