package com.example.srm_ez2;

public class facts_model {
    String fact;

    facts_model(){

    }
    public facts_model(String fact) {
        this.fact = fact;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }
}
