package com.spring.security.springsecurity.exception;

import com.spring.security.springsecurity.error.Error;


public class UserBusinessException extends RuntimeException{

    private Error error;
    private ErrorCode errorCode;

    public UserBusinessException(Error error, String errorCode) {
        this.error = error;
        this.errorCode = ErrorCode.valueOf(errorCode);
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public enum ErrorCode {
        INVALID_REQUEST("INVALID_REQUEST"),  // 400
        AUTHENTICATION_FAILURE("AUTHENTICATION_FAILURE"),  // 401
        NOT_AUTHORIZED("NOT_AUTHORIZED"),  // 403
        RESOURCE_NOT_FOUND("RESOURCE_NOT_FOUND"),  // 404
        METHOD_NOT_SUPPORTED("METHOD_NOT_SUPPORTED"),  // 405
        MEDIA_TYPE_NOT_ACCEPTABLE("MEDIA_TYPE_NOT_ACCEPTABLE"),  // 406
        PRECONDITION_FAILED("PRECONDITION_FAILED"),  // 412
        UNSUPPORTED_MEDIA_TYPE("UNSUPPORTED_MEDIA_TYPE"),  // 415
        UNPROCESSABLE_ENTITY("UNPROCESSABLE_ENTITY"),  // 422
        MISSING_PRECONDITION_HEADER("MISSING_PRECONDITION_HEADER"),  // 428
        RATE_LIMIT_REACHED("RATE_LIMIT_REACHED"),  // 429
        INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR"),  // 500
        SERVICE_UNAVAILABLE("SERVICE_UNAVAILABLE");
        // 503

        private String reasonPhrase;

        ErrorCode(String reasonPhrase){
            this.reasonPhrase = reasonPhrase;
        }

        public String getReasonPhrase() {
            return reasonPhrase;
        }

        public void setReasonPhrase(String reasonPhrase) {
            this.reasonPhrase = reasonPhrase;
        }
    }



}
