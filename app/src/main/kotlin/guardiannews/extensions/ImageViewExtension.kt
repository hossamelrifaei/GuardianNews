package guardiannews.extensions

import android.support.v4.view.ViewCompat
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by hossam
 */
fun ImageView.load(url: String?) {
    if (url == null) {
        this.visibility = View.GONE
        ViewCompat.setTransitionName(this, "")
    } else {
        this.visibility = View.VISIBLE
        ViewCompat.setTransitionName(this, url);
        Glide.with(this.context)
                .load(url)
                .into(this)
    }
}