package com.example.databasefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.razorpay.Checkout;

import org.json.JSONObject;

public class RPaymentMain extends AppCompatActivity implements PaymentResultListener {

    private TextView txtPaymentStatus;
    private Button btnPayNow;
    private EditText editAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rpayment_main);

        txtPaymentStatus=findViewById(R.id.paymentStatus);
        editAmount=findViewById(R.id.edit_amount);
        btnPayNow=findViewById(R.id.btn_pay);
        Checkout.preload(RPaymentMain.this);

        btnPayNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starPayment(Integer.parseInt(editAmount.getText().toString()));
            }
        });

    }

    public void starPayment(int Amount){
        Checkout checkout=new Checkout();
        checkout.setKeyID("rzp_test_SO8qBYUmquJWx6");
        checkout.setImage(R.drawable.logo2);

        try{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("name","Home Service App Pay Demo");
            jsonObject.put("description","Home Service App");

            jsonObject.put("theme.color","#3399cc");
            jsonObject.put("currency","INR");
            jsonObject.put("amount",Amount*100);
            // jsonObject.put("prefill.contact", "+12234567890");
            //jsonObject.put("Prefill.email","demo@gmail.com");

            JSONObject retryObj=new JSONObject();
            retryObj.put("enabled",true);
            retryObj.put("max_count",4);

            jsonObject.put("retry",retryObj);
            checkout.open(RPaymentMain.this,jsonObject);

            Intent intent = new Intent(RPaymentMain.this,RpaymentContinue.class);
            startActivity(intent);

        }
        catch (Exception e){
            Toast.makeText(RPaymentMain.this, "Something went wrong !!", Toast.LENGTH_SHORT).show();
        }
    }
    /*Intent intent;

    {
        intent = new Intent(MainActivity.this, THActivity.class);
    }*/

    @Override
    public void onPaymentSuccess(String s){
        txtPaymentStatus.setText(s);
    }

    @Override
    public void onPaymentError(int i, String s){
        txtPaymentStatus.setText("Error : "+s);
    }

}