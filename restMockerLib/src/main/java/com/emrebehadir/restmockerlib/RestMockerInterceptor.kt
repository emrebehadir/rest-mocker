package com.emrebehadir.restmockerlib

import com.emrebehadir.restmockerlib.annotations.Mocker
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Invocation

/**
 *
 * RestMockerInterceptor intercept rest api call. If api flagged with mock, interceptor return mock response.
 *
 * */
class RestMockerInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val mockAnnotation = chain
            .request()
            .tag(Invocation::class.java)
            ?.method()
            ?.annotations
            ?.filterMockerAnnotation()

        if (mockAnnotation.isNullOrEmpty().not()) {
            return MockerResponse(mockAnnotation!!.first() as Mocker)
                .generate()
                .request(chain.request())
                .build()
        }

        return chain.proceed(chain.request())
    }
}