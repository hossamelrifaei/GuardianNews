package ui

import android.widget.ImageView

/**
 * Created by hossam
 */
interface Router {
    fun goToDetail(bodyText: String, webTitle: String, item_img: ImageView)
    fun pop(): Boolean
}