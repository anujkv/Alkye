package com.net.alkye.utils.network

object NetworkCodes {
    // 2xx Success
    const val OK = 200               // The request was successful
    const val CREATED = 201          // The resource was successfully created
    const val ACCEPTED = 202         // The request has been accepted for processing

    // 3xx Redirection
    const val MOVED_PERMANENTLY = 301 // The resource has been moved permanently
    const val FOUND = 302            // The resource has been temporarily moved
    const val NOT_MODIFIED = 304     // The resource has not been modified

    // 4xx Client Error
    const val BAD_REQUEST = 400      // The request could not be understood or was missing required parameters
    const val UNAUTHORIZED = 401     // Authentication failed or user does not have permissions
    const val FORBIDDEN = 403        // The server understood the request but refuses to authorize it
    const val NOT_FOUND = 404        // The requested resource could not be found
    const val METHOD_NOT_ALLOWED = 405 // The request method is not allowed
    const val CONFLICT = 409         // Request could not be completed due to a conflict

    // 5xx Server Error
    const val INTERNAL_SERVER_ERROR = 500 // The server encountered an unexpected condition
    const val NOT_IMPLEMENTED = 501        // The server does not support the functionality required
    const val BAD_GATEWAY = 502            // The server received an invalid response from the upstream server
    const val SERVICE_UNAVAILABLE = 503    // The server is currently unable to handle the request
    const val GATEWAY_TIMEOUT = 504        // The server did not receive a timely response from the upstream server
}
