package com.thegrafico.raul.evertectest.Modals.Response;

import com.thegrafico.raul.evertectest.Modals.Response.inheritance.DataResponse;

public class ResponseDebit extends DataResponse {

    private String
        postingdate     = null,
        systemTrace     = null,
        trxDatetime     = null;

    public ResponseDebit(){}

    @Override
    public String toString() {
        return "ResponseProcessDebit{" +
                "postingdate='" + postingdate + '\'' +
                ", systemTrace='" + systemTrace + '\'' +
                ", trxDatetime='" + trxDatetime + '\'' +
                '}';
    }

    public String getPostingdate() {
        return postingdate;
    }

    public void setPostingdate(String postingdate) {
        this.postingdate = postingdate;
    }

    public String getSystemTrace() {
        return systemTrace;
    }

    public void setSystemTrace(String systemTrace) {
        this.systemTrace = systemTrace;
    }

    public String getTrxDatetime() {
        return trxDatetime;
    }

    public void setTrxDatetime(String trxDatetime) {
        this.trxDatetime = trxDatetime;
    }
}