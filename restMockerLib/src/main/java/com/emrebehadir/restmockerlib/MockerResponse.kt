package com.emrebehadir.restmockerlib

import com.emrebehadir.restmockerlib.Constants.EMPTY_BODY
import com.emrebehadir.restmockerlib.Constants.MESSAGE
import com.emrebehadir.restmockerlib.annotations.Mocker
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType

import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

/**
 * Class generate response builder.
 *
 * @param annotation using for initializing response builder.
 * */
class MockerResponse(private val annotation: Mocker) {

    private var responseCode: Int = annotation.responseCode
    private var protocol: Protocol = annotation.responseProtocol
    private var mediaType: MediaType = annotation.responseType.toMediaType()
    private var message = MESSAGE
    private var body = EMPTY_BODY

    init {
        body = RestMocker.readFile(annotation.rawResourceId)
    }

    fun generate(): Response.Builder {
        return Response.Builder()
            .code(responseCode)
            .protocol(protocol)
            .message(message)
            .body(body.toResponseBody(mediaType))
    }
}