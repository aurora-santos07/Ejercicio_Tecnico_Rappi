package com.example.ejerciciotcnicorappi.testutils

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

open class MockWebServerRule : TestRule {

    val server = MockWebServer()

    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                server.start()
                base.evaluate()
                 server.shutdown()
            }

        }
    }

    fun givenMockitoResponse(responseCode: Int = 200, json: String? = ""){
        val mockResponse = MockResponse()
        mockResponse.setResponseCode(responseCode)
        val jsonResponse = ResourceLoader.loadContentFromFile(json)
        mockResponse.setBody(jsonResponse)
        server.enqueue(mockResponse)
    }

    fun getBaseUrl(path: String = "/") = server.url(path).toString()
}