package guardiannews.screens.feed

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import guardiannews.extensions.load
import guardiannews.model.Favourite
import guardiannews.ui.AdapterListener
import kotlinx.android.synthetic.main.fav_list_item.view.*
import theguardian.com.guardiannews.R

/**
 * Created by hossam
 */
class FavouriteAdapter : RecyclerView.Adapter<FavouriteAdapter.FavViewHolder>() {
    lateinit var listener: AdapterListener
    private var favList: MutableList<Favourite> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteAdapter.FavViewHolder {
        return FavViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fav_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return favList.size
    }

    override fun onBindViewHolder(holder: FavouriteAdapter.FavViewHolder, position: Int) {
        holder.bind(favList[position])
    }

    fun addFav(newFav: MutableList<Favourite>) {
        favList.clear()
        favList.addAll(newFav)
        notifyDataSetChanged()
    }

    inner class FavViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(favourite: Favourite) {
            itemView.apply {
                item_img.load(favourite.image)
                setOnClickListener { listener.onItemClick(favourite.body, favourite.title, item_img) }
            }
        }

    }
}