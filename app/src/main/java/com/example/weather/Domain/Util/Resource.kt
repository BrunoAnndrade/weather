package com.example.weather.Domain.Util


/* A sealed class representing a resource, which can be either a success or an error.
  This class is used to encapsulate the result of an operation that may succeed or fail,
 providing a consistent way to handle both successful and error outcomes.
 */
sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?): Resource<T>(data)
    class Error<T>(message: String, data: T? = null): Resource<T>(data, message)
}