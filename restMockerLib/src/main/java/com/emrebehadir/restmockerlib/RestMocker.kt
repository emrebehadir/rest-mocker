package com.emrebehadir.restmockerlib

import android.content.res.Resources
import com.emrebehadir.restmockerlib.exception.LibraryInitializeException
import java.io.BufferedReader

object RestMocker {

    /**
     * Application resource
     */
    private lateinit var resources: Resources

    /**
     *Method initialize mocker library.
     *
     * @param resources must be the application resource.
     */
    fun initialize(resources: Resources) {
        this.resources = resources
    }

    /**
     * Read raw resource file.
     *
     * @return It returns file content as string.
     * */
     internal fun readFile(rawFileId: Int): String {
        if (this::resources.isInitialized.not()) {
            throw LibraryInitializeException()
        }

        val inputStream = resources.openRawResource(rawFileId)
        val reader = BufferedReader(inputStream.reader())
        return reader.use {
            it.readText()
        }
    }
}