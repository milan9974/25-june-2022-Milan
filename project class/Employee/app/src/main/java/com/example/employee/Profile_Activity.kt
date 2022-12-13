package com.example.employee

import android.app.Notification.Action
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Video.Media
import android.util.Log
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import com.bumptech.glide.Glide
import com.google.android.gms.common.api.Api.ApiOptions.HasAccountOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
//import com.google.firebase.database.ktx.getValue
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import de.hdodenhof.circleimageview.CircleImageView
import java.io.IOException
import java.util.UUID

class Profile_Activity : AppCompatActivity() {

    lateinit var firebaseUser : FirebaseUser
    lateinit var databaseReference : DatabaseReference
    lateinit var storage : FirebaseStorage
    lateinit var storageReference : StorageReference

    var filepath : Uri? = null // uniform resource identifier
    var PIC_IMAGE_RERQUEST  = 1002

    lateinit var profileforprofile : CircleImageView
    lateinit var ed_profilename : EditText
    lateinit var ed_profilecontact :EditText
    lateinit var ed_profileemail : EditText


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        ActivityCompat.requestPermissions(this@Profile_Activity,arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE),2)


        var back_fromprofile = findViewById<ImageView>(R.id.back_fromprofile)
        var profile_save = findViewById<TextView>(R.id.profile_save)
        profileforprofile = findViewById(R.id.profile_image_profile)
        ed_profilename = findViewById(R.id.ed_profilename)
        ed_profilecontact = findViewById(R.id.ed_profilecontact)
        ed_profileemail = findViewById(R.id.ed_profileemail)

        profileforprofile.setOnClickListener {
            selectImage()
        }

        profile_save.setOnClickListener {
            uploadImage()
        }


        back_fromprofile.setOnClickListener {
            var i = Intent(this, Dashboard_Activity::class.java)
            finish()
            startActivity(i)
        }

//        storage = FirebaseStorage.getInstance()
//        storageReference = storage.reference
//        firebaseUser = FirebaseAuth.getInstance().currentUser!!

        firebaseUser = FirebaseAuth.getInstance().currentUser!!
        storage = FirebaseStorage.getInstance()
        storageReference = storage.reference
//        Log.d("mydata","---->currentuser"+firebaseUser)
//        Log.d("mydata","--> current id "+firebaseUser.uid)
//        databaseReference = FirebaseDatabase.getInstance().getReference(" My Users").child(firebaseUser.uid)
        databaseReference = FirebaseDatabase.getInstance().getReference("My Users").child(firebaseUser.uid)


        databaseReference.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var user = snapshot.getValue(EmployeeModel::class.java)
//                Log.d("mydata","---> all data "+user)
//                Log.d("mydata","username ----->"+user)
                ed_profilename.setText(user!!.name)
                ed_profilecontact.setText(user!!.contact)
                ed_profileemail.setText(user!!.email)

                if(user!!.profile_pic == "")
                {
                    profileforprofile.setImageResource(R.mipmap.ic_launcher)
                }
                else
                {
                    Glide
                        .with(this@Profile_Activity)
                        .load(user.profile_pic)
                        .placeholder(R.drawable.google)
                        .into(profileforprofile);

                    Log.d("mydata","profile....."+user.profile_pic)
                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Profile_Activity, ""+error.message, Toast.LENGTH_SHORT).show()
            }

        })

    }


    fun selectImage()
    {
        var intent: Intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent,"select image"),PIC_IMAGE_RERQUEST)
    }


//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
//    {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if(requestCode == 1001 && resultCode != null)
//        {
//            filepath = data!!.data
//
//            try {
//                var bitmap:Bitmap = MediaStore .Images.Media.getBitmap(contentResolver,filepath)
//                profileforprofile.setImageBitmap(bitmap)
//            }
//            catch (e:IOException)
//            {
//
//            }
//
//        }
//    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == PIC_IMAGE_RERQUEST && resultCode != null)
        {
            filepath = data!!.data
            try {
                var bitmap:Bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver,filepath)
                profileforprofile.setImageBitmap(bitmap!!)
            } catch (e:IOException) {
                Toast.makeText(this@Profile_Activity, "Failed", Toast.LENGTH_SHORT).show()
            }

        }
    }

    fun uploadImage()
    {
        if(filepath != null)
        {
            var ref :StorageReference = storageReference.child("image/"+UUID.randomUUID().toString())

            ref.putFile(filepath!!)
                .addOnSuccessListener {
                    var hashmap : HashMap<String,String> = HashMap()


                    hashmap.put("name",ed_profilename.text.toString())
                    hashmap.put("email",ed_profileemail.text.toString())
                    hashmap.put("contact",ed_profilecontact.text.toString())
                    hashmap.put("profile_pic",filepath.toString())
                    databaseReference.updateChildren(hashmap as Map<String,Any>)
                    Toast.makeText(this@Profile_Activity, "Successfully updated", Toast.LENGTH_SHORT).show()

                    var intent=Intent(this,Dashboard_Activity::class.java)
                    finish()
                    startActivity(intent)
                }
                .addOnFailureListener{
                    Toast.makeText(this@Profile_Activity, "Something went wrong", Toast.LENGTH_SHORT).show()
                }
        }
    }


}