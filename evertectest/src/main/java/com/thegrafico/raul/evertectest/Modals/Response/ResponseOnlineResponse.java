package com.thegrafico.raul.evertectest.Modals.Response;

public class ResponseOnlineResponse {

    private String
        code        = null,
        message     = null,
        requestID   = null;

    public ResponseOnlineResponse(){}

    @Override
    public String toString() {
        return "ResponseProcessOnlineResponse{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", requestId='" + requestID + '\'' +
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
        return requestID;
    }

    public void setRequestId(String requestId) {
        this.requestID = requestId;
    }
}
