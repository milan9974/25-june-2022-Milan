package com.example.myapplication

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import org.json.JSONObject

class Payment_Activity : AppCompatActivity(), PaymentResultListener {

     lateinit var ed:EditText
     var amount = 0
    // key-id : rzp_test_thMvIr98nRXGp4
    // itapan@gmail.com  tapan@razor
    // key-secret : AseXJyYpRD7oy7oidR3JLq9o

    // merchent Id   : KV8aX7P9QLCwCe
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        var btn_pay = findViewById<TextView>(R.id.btn_pay)
        ed = findViewById(R.id.ed_amount)


        btn_pay.setOnClickListener {
            var amt = ed.text.toString()
            amount = Math.round(amt.toFloat() * 100).toInt()
            startPayment()
        }
    }

    private fun startPayment() {
        /*
        *  You need to pass the current activity to let Razorpay create CheckoutActivity
        * */
//        val activity:Activity = this
        val co = Checkout()
        co.setKeyID("rzp_test_thMvIr98nRXGp4")

        try {
            val options = JSONObject()
            options.put("name","Milan")
            options.put("description","patel")
            //You can omit the image option to fetch the image from the dashboard
            options.put("image","https://s3.amazonaws.com/rzp-mobile/images/rzp.jpg")
            options.put("theme.color", "#3399cc");
            options.put("currency","INR");
//            options.put("order_id", "order_DBJOWzybf0sJbb");
            options.put("amount",amount)//pass amount in currency subunits

//            val retryObj = JSONObject();
//            retryObj.put("enabled", true);
//            retryObj.put("max_count", 4);
//            options.put("retry", retryObj);

            val prefill = JSONObject()
            prefill.put("email","itapan@gmail.com")
            prefill.put("contact","9876543210")
            options.put("prefill",prefill)
            co.open(this,options)
        }catch (e: Exception){
            Toast.makeText(this,"Error in payment: " ,Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    override fun onPaymentSuccess(p0: String?) {
        Toast.makeText(this, "Success $p0", Toast.LENGTH_SHORT).show()
    }

    override fun onPaymentError(p0: Int, p1: String?) {
        Toast.makeText(this, "Failed $p1", Toast.LENGTH_SHORT).show()
    }
}