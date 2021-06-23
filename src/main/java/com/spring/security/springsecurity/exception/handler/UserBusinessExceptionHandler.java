package com.spring.security.springsecurity.exception.handler;

import com.spring.security.springsecurity.exception.UserBusinessException;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.HashMap;
import java.util.Map;

@Component
@Provider
public class UserBusinessExceptionHandler implements ExceptionMapper<UserBusinessException> {
    private static Map<String, ResponseStatus> errorMap= new HashMap();
    static {
        errorMap.put("INTERNAL_SERVER_ERROR", ResponseStatus.INTERNAL_SERVER_ERROR);
        errorMap.put("UNPROCESSABLE_ENTITY", ResponseStatus.UNPROCESSABLE_ENTITY);
        errorMap.put("INVALID_REQUEST", ResponseStatus.INVALID_REQUEST);
        errorMap.put("VALIDATION_ERROR", ResponseStatus.INVALID_REQUEST);
        errorMap.put("NOT_AUTHORIZED", ResponseStatus.NOT_AUTHORIZED);
    }

    @Override
    public Response toResponse(UserBusinessException e) {
        ResponseStatus responseStatus = errorMap.get(e.getErrorCode().getReasonPhrase());

        return Response.status(Response.Status.fromStatusCode(responseStatus.statusCode))
                .entity(e.getError())
                .build();
    }


    public enum ResponseStatus {
        UNPROCESSABLE_ENTITY(422, "Unprocessable Entity"), INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
        INVALID_REQUEST(400, "Bad Request"), NOT_AUTHORIZED(403, "Permission Denied");

        private int statusCode;
        private String reasonPhrase;

        ResponseStatus(int statusCode, String reasonPhrase){
            this.statusCode = statusCode;
            this.reasonPhrase = reasonPhrase;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        public String getReasonPhrase() {
            return reasonPhrase;
        }

        public void setReasonPhrase(String reasonPhrase) {
            this.reasonPhrase = reasonPhrase;
        }

        public Response.Status.Family getFamily() {
            return Response.Status.Family.familyOf(statusCode);
        }
    }


}
