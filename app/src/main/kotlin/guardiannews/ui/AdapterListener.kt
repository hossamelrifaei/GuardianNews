package guardiannews.ui

import android.widget.ImageView

interface AdapterListener {
    fun onLoadMore()
    fun onItemClick(bodyText: String, webTitle: String, item_img: ImageView)
}
