package com.net.alkye

import com.net.alkye.utils.network.MockHttpClient
import junit.framework.TestCase.assertEquals
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

       /* val mockUrl = mockWebServer.url("/").toString()
        println("Mock URL: $mockUrl")


        val client = MockHttpClient()
        val request = Request.Builder().url(mockUrl).build()

        client.newCall(request).execute().use { response ->
            assertEquals(200, response.code)
            assertEquals("Success", response.body?.string())
        }

        client.newCall(request).execute().use { response ->
            assertEquals(401, response.code)
            assertEquals("Unauthorized", response.body?.string())
        }

        val mockHttpClient = MockHttpClient()
        mockHttpClient.makeRequest(mockUrl)
*/
        mockWebServer.shutdown()
    }
}