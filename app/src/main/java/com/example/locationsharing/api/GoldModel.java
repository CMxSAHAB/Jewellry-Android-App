package com.example.locationsharing.api;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;

import java.text.DecimalFormat;

@Keep
public class GoldModel {
    private final Double price_gram_24k;
    private final Double price_gram_22k;
    private final Double price_gram_21k;
    private final Double price_gram_20k;
    private final Double price_gram_18k;
    private final DecimalFormat df = new DecimalFormat("0.00");

    public GoldModel(Double price_gram_24k, Double price_gram_22k, Double price_gram_21k, Double price_gram_20k, Double price_gram_18k) {
        this.price_gram_24k = price_gram_24k;
        this.price_gram_22k = price_gram_22k;
        this.price_gram_21k = price_gram_21k;
        this.price_gram_20k = price_gram_20k;
        this.price_gram_18k = price_gram_18k;
    }

    public String getPrice_gram_24k() {
        return df.format( price_gram_24k);
    }

    public String getPrice_gram_22k() {
        return df.format( price_gram_22k);
    }

    public String getPrice_gram_21k() {

        return df.format( price_gram_21k);
    }

    public String getPrice_gram_20k()
    {
        return df.format( price_gram_20k);
    }

    public String getPrice_gram_18k() {

        return df.format( price_gram_18k);
    }

    @NonNull
    @Override
    public String toString() {
        return "24k Gold 1gm=" + price_gram_24k +"\n"+
                "22k Gold 1gm=" + price_gram_22k +"\n"+
                "21k Gold 1gm=" + price_gram_21k +"\n"+
                "20k Gold 1gm=" + price_gram_20k+"\n"+
                "18k Gold 1gm=" + price_gram_18k ;
    }
}
