package ctorres.com.connectapp.Api

import ctorres.com.connectapp.Constants
import ctorres.com.connectapp.PostResponseModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface IRestApiService{
    @GET(Constants.API.GET_POSTS)
    fun getPosts():Call<ArrayList<PostResponseModel>>;
}