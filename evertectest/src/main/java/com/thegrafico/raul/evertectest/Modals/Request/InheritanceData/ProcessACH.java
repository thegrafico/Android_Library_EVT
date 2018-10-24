package com.thegrafico.raul.evertectest.Modals.Request.InheritanceData;

public class ProcessACH extends Data {

    private String
        backAccount     = null,
        routing         = null,
        accType         = null;

    public ProcessACH(){}

    @Override
    public String toString() {
        return "ProcessACH{" +
                "backAccount='" + backAccount + '\'' +
                ", routing='" + routing + '\'' +
                ", accType='" + accType + '\'' +
                '}';
    }

    public String getBackAccount() {
        return backAccount;
    }

    public void setBackAccount(String backAccount) {
        this.backAccount = backAccount;
    }

    public String getRouting() {
        return routing;
    }

    public void setRouting(String routing) {
        this.routing = routing;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }
}
