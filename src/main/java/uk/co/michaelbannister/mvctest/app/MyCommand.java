package uk.co.michaelbannister.mvctest.app;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MyCommand {

    @Size(max = 10, min = 1)
    @NotNull
    private String myValue;

    public String getMyValue() {

        return myValue;
    }

    public void setMyValue(String myValue) {

        this.myValue = myValue;
    }

}
