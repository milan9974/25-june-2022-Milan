package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*

class Dashboard_Activity : AppCompatActivity() {

    lateinit var firebaseAuth : FirebaseAuth
    lateinit var databaseReference: DatabaseReference
    lateinit var firebaseuser : FirebaseUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        firebaseAuth= FirebaseAuth.getInstance()
        firebaseuser = firebaseAuth.currentUser!!

        var recyclerview = findViewById<RecyclerView>(R.id.rv_displayalluser)
        var fb_logout =findViewById<FloatingActionButton>(R.id.fb_logout)

        fb_logout.setOnClickListener {

//            firebaseAuth.signOut()
            var i = Intent(this, Login_Activity::class.java)
            finish()
            startActivity(i)
        }

        recyclerview.layoutManager= LinearLayoutManager(this@Dashboard_Activity)

        var userlist = ArrayList<UserModel>()

        var firebase:FirebaseUser?  = firebaseAuth.currentUser
        var user_id:String=firebase!!.uid

        databaseReference= FirebaseDatabase.getInstance().getReference("users")

        databaseReference.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                userlist.clear()

                for (dataSnapshot: DataSnapshot in snapshot.children)
                {
                    var usermodel = dataSnapshot.getValue(UserModel::class.java)
                    if (!usermodel!!.uid.equals(firebase.uid))
                    {
                        userlist.add(usermodel)
                    }
                }
                var myUserAdapter = MyUserAdapter(this@Dashboard_Activity,userlist)
                recyclerview.adapter=myUserAdapter
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mymenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.op_profile ->
            {
                var i = Intent(this, Profile_Activity::class.java)
                startActivity(i)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
