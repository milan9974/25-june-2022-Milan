package com.example.retrofit_example_kotlin

import retrofit2.Call
import retrofit2.http.*

interface apiinterface {

    // insert / store data in database
    @FormUrlEncoded
    @POST("insert_api.php")
    fun insertData(@Field("name") name:String, @Field("email") email: String, @Field("password") password: String): Call<studentdataitem>


    // fetch data from database
    @GET("login.php")
    fun login(@Query("email") email: String, @Query("password") password:String): Call<List<studentdataitem>>


    // fetch all data from database
    @GET("get_all_data.php")
    fun get_all_data():Call<List<studentdataitem>>

    @GET("get_specific_student_by_id.php")
    fun specific_student(@Query("id") id:String):Call<List<studentdataitem>>
}