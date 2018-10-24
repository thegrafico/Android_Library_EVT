package com.thegrafico.raul.evertectest.Modals.Response;

public class ResponseOnlineResponse {

    private String
        code        = null,
        message     = null,
        requestId   = null;

    public ResponseOnlineResponse(){}

    @Override
    public String toString() {
        return "ResponseProcessOnlineResponse{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", requestId='" + requestId + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
