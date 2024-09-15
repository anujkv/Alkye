package com.net.alkye

import com.net.alkye.utils.network.MockHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Test

class MockServerTest {
    @Test
    fun testMockServer() {
        val mockWebServer = MockWebServer()

        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody("Success"))
        mockWebServer.enqueue(MockResponse().setResponseCode(401).setBody("Unauthorized"))
        mockWebServer.start()

        val mockUrl = mockWebServer.url("/test").toString()

        val mockHttpClient = MockHttpClient()
        mockHttpClient.makeRequest(mockUrl)

        mockWebServer.shutdown()
    }
}