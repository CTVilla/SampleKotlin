package ctorres.com.connectapp.Api

import ctorres.com.connectapp.Constants
import ctorres.com.connectapp.PostResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestApiClient {
    lateinit var mRetrofit: Retrofit;
    lateinit var mRestApiCallback: RestApiClientCallback;
    constructor(restApiClientCallback: RestApiClientCallback) {
        this.mRetrofit = Retrofit.Builder().baseUrl(Constants.API.BASEPATH)
            .addConverterFactory(GsonConverterFactory.create()).build()
        this.mRestApiCallback = restApiClientCallback;
    }

    fun getPosts() {
        val service = this.mRetrofit.create<IRestApiService>(IRestApiService::class.java)
        service.getPosts().enqueue(object : Callback<ArrayList<PostResponseModel>>{
                override fun onFailure(call: Call<ArrayList<PostResponseModel>>, t: Throwable) {
                    t.toString();
                }
                override fun onResponse(call: Call<ArrayList<PostResponseModel>>,
                    response: Response<ArrayList<PostResponseModel>>) {
                    this@RestApiClient.mRestApiCallback.getPostsResult(response.body())
                }
            }
        )
    }

    interface RestApiClientCallback{
        fun getPostsResult(posts: ArrayList<PostResponseModel>?)
    }
}