package guardiannews.screens.feed

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import guardiannews.extensions.load
import guardiannews.model.Result
import guardiannews.ui.AdapterListener
import kotlinx.android.synthetic.main.feed_list_item.view.*
import theguardian.com.guardiannews.R


/**
 * Created by hossam
 */
private const val SCROLL_THRESHOLD = 2

class FeedAdapter : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {
    lateinit var listener: AdapterListener
    private var feedList: MutableList<Result> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        return FeedViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.feed_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return feedList.size
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bind(feedList[position])
        if (position == feedList.size - SCROLL_THRESHOLD) {
            listener.onLoadMore()
        }
    }

    fun addFeed(newFeedList: MutableList<Result>) {
        feedList.addAll(newFeedList)
        notifyItemInserted(itemCount - 1)
    }

    inner class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(result: Result) {
            itemView.apply {
                item_img.load(result.fields.thumbnail)
                item_title.text = result.webTitle
                item_section.text = result.sectionName
                setOnClickListener { listener.onItemClick(result.fields.bodyText, result.webTitle, item_img) }
            }
        }

    }
}