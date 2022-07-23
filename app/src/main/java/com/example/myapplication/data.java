package com.example.myapplication;

public class data {
    String docode;
    String translate;

    public String getDocode() {
        return docode;
    }

    public void setDocode(String docode) {
        this.docode = docode;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    @Override
    public String toString() {
        return "data{" +
                "docode='" + docode + '\'' +
                ", translate='" + translate + '\'' +
                '}';
    }
}
