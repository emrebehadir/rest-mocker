package com.emrebehadir.restmockerlib.annotations

import com.emrebehadir.restmockerlib.Constants
import okhttp3.Protocol
import java.net.HttpURLConnection

/**
 * Annotation specify which function mockable.
 *
 * @param rawResourceId indicate your raw resource id in res/raw/<file>.
 * @param responseCode indicate your mock response code.
 * @param responseType indicate your mock response type.
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class Mocker(
    val rawResourceId: Int,
    val responseCode: Int = HttpURLConnection.HTTP_OK,
    val responseType: String = Constants.MEDIA_TYPE_JSON,
    val responseProtocol: Protocol = Protocol.HTTP_2
)