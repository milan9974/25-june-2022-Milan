package com.example.retrofit

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MyApiInterface {

    @FormUrlEncoded
    @POST("insert_api.php")
    fun MemberInsertData(@Field("firstname") firstname:String, @Field("lastname") lastname: String,
                   @Field("email") email:String, @Field("mobilenumber") mobilenummber: String,
                   @Field("familymember") familymember:String, @Field("occupation") occupation: String,
                   @Field("housenumber") housenumber:String ,@Field("password") password: String): Call<MemberDataItem>

    @GET("get_all_data.php")
    fun get_all_data():Call<List<MemberDataItem>>

}