package com.example.googlesignin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    lateinit var auth:FirebaseAuth
    lateinit var googleSignInClient:GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn=findViewById<Button>(R.id.btn_google_sign_in)

        auth = FirebaseAuth.getInstance()

        var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this,gso)

        btn.setOnClickListener {
            signInGoole()
        }
    }

    fun signInGoole(){
        var signInIntent = googleSignInClient.signInIntent
        launcher.launch(signInIntent)
    }

    var launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result ->
        if (result.resultCode == Activity.RESULT_OK){
            var task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            handleResults(task)
        }
    }

    fun handleResults(task:Task<GoogleSignInAccount>){
        if (task.isSuccessful){
            var account : GoogleSignInAccount?=task.result
            if (account!=null){
                updateUI(account)
            }else{
                Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun updateUI(account: GoogleSignInAccount){
        var credentials = GoogleAuthProvider.getCredential(account.idToken,null)

        auth.signInWithCredential(credentials)
            .addOnCompleteListener({
                if (it.isSuccessful){
                    var i = Intent(this,dashboard_Activity::class.java)
                    i.putExtra("email",account.email)
                    i.putExtra("username",account.displayName)

                    Log.d("mydata","email"+account.email)
                    Log.d("mydata","username"+account.displayName)
                    startActivity(i)
                }
            })
    }
}