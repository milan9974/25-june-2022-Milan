package com.example.myapplication

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import de.hdodenhof.circleimageview.CircleImageView
import java.io.IOException
import java.util.UUID

class Profile_Activity : AppCompatActivity()
{
    lateinit var firebaseUser: FirebaseUser
    lateinit var databaseReference: DatabaseReference
    lateinit var storage : FirebaseStorage
    lateinit var storageReference: StorageReference

    var filepath : Uri? = null // uniform resource identifier( image save karva mate lidhu che )
//    var PIC_IMAGE_RERQUEST : Int? =100


    lateinit var profileforprofile:CircleImageView
    lateinit var ed_profileusername : EditText


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        ed_profileusername =findViewById(R.id.ed_profile_username)
        profileforprofile=findViewById(R.id.profile_image_forprofile)
        var btn_save_profile = findViewById<Button>(R.id.btn_save_profile)


    requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE,
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE),2)



        profileforprofile.setOnClickListener {
            seletImg()
        }

        btn_save_profile.setOnClickListener {
            uploadImage()

//            var i = Intent(this,Dashboard_Activity::class.java)
//            finish()
//            startActivity(i)
        }


        storage = FirebaseStorage.getInstance()
        storageReference = storage.reference
        firebaseUser = FirebaseAuth.getInstance().currentUser!!

        databaseReference = FirebaseDatabase.getInstance().getReference("users").child(firebaseUser.uid)

        databaseReference.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                var user = snapshot.getValue(UserModel::class.java)

                ed_profileusername.setText(user!!.username)

                if (user!!.profile_pic == "")
                {
                    profileforprofile.setImageResource(R.mipmap.ic_launcher)
                }
                else
                {
                    Glide
                        .with(this@Profile_Activity)
                        .load(user.profile_pic)
                        .placeholder(R.drawable.ic_launcher_background)
                        .into(profileforprofile)
                }

            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }


    fun seletImg()
    {
        var intent: Intent = Intent()

        intent.type = "image/*"

        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent,"select image"),1000)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1000 && resultCode != null)
        {
            filepath = data!!.data

            try {
                var bitmap : Bitmap = MediaStore.Images.Media.getBitmap(contentResolver,filepath)
                profileforprofile.setImageBitmap(bitmap)
            }

            catch (e:IOException)
            {

            }
        }
    }

    fun uploadImage()
    {
        if(filepath!=null)
        {
            var ref : StorageReference =storageReference.child("image/"+UUID.randomUUID().toString())

            ref.putFile(filepath!!)
                .addOnSuccessListener {
                    var hashmap : HashMap<String,String> = HashMap()

                    hashmap.put("username",ed_profileusername.text.toString())
                    hashmap.put("profile_pic",filepath.toString())

                    databaseReference.updateChildren(hashmap as Map<String,Any>)
                }

                .addOnFailureListener{
                    Toast.makeText(this@Profile_Activity, "Something wrong", Toast.LENGTH_SHORT).show()
                }
        }

    }
}