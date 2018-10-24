package com.thegrafico.raul.evertectest.Modals.Response;

import com.thegrafico.raul.evertectest.Modals.Response.inheritance.DataResponse;

public class ResponseCredit extends DataResponse {


private String
        postingdate     = null,
        systemTrace     = null,
        trxDatetime     = null,
        trxoper         = null;

    public ResponseCredit(){}


    @Override
    public String toString() {
        return "ResponseProcessCredit{" +
                "postingdate='" + postingdate + '\'' +
                ", systemTrace='" + systemTrace + '\'' +
                ", trxDatetime='" + trxDatetime + '\'' +
                ", trxoper='" + trxoper + '\'' +
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

    public String getTrxoper() {
        return trxoper;
    }

    public void setTrxoper(String trxoper) {
        this.trxoper = trxoper;
    }
}
