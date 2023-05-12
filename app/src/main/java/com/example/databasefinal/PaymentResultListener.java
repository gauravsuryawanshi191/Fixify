package com.example.databasefinal;

public interface PaymentResultListener {
    void onPaymentSuccess(String s);

    void onPaymentError(int i, String s);
}
