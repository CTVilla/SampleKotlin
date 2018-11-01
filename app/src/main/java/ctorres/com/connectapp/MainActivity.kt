package ctorres.com.connectapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import ctorres.com.connectapp.Api.RestApiClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RestApiClient.RestApiClientCallback {

    lateinit var mRestApiClient: RestApiClient;
    init {
        this.mRestApiClient = RestApiClient(this);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.mRestApiClient.getPosts();
    }

    override fun getPostsResult(posts: ArrayList<PostResponseModel>?) {
        this.mRecyclerPosts.layoutManager = LinearLayoutManager(this)!!
        this.mRecyclerPosts.adapter = PostAdapter(this, posts);
    }
}
