package ctorres.com.connectapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_post_main.view.*

class PostAdapter : RecyclerView.Adapter<PostAdapter.ViewHolder>{

    var mLstPosts : ArrayList<PostResponseModel>?
    lateinit var mContext: Context

    constructor(context: Context,lstPosts : ArrayList<PostResponseModel>?) {
        this.mContext = context
        this.mLstPosts = lstPosts
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder
            = ViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.item_post_main,null))

    override fun getItemCount(): Int = this.mLstPosts!!.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int)
            = viewHolder.bind(this.mLstPosts?.get(position))

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(post: PostResponseModel?){
            itemView.lblTitle.text = post?.title;
        }
    }
}