package com.trm.dto;

public class Result {

    private Double value;

    public Result() {}

    public Result(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
