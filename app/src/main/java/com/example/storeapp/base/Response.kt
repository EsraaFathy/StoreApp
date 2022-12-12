package com.example.storeapp.base

import java.lang.Error

sealed class Response{
    class SuccessResponse<T>(val offClass: Class<T>) : Response()
    class ErrorResponse(val error: Error) : Response()
}
