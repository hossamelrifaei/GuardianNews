package guardiannews.screens.detail

import android.os.Bundle
import android.support.transition.Fade
import android.text.method.ScrollingMovementMethod
import base.BaseFragment
import guardiannews.extensions.load
import guardiannews.ui.DetailsTransition
import kotlinx.android.synthetic.main.fragment_detail.*
import theguardian.com.guardiannews.R
import javax.inject.Inject


/**
 * Created by hossam
 */
const val EXTRA_TRANSITION_NAME = "transition"


class DetailFragment : BaseFragment(), DetailContract.View {

    companion object {
        const val EXTRA_FEED_TITLE: String = "title"
        const val EXTRA_FEED_BODY = "body"
        const val EXTRA_FEED_IMAGE = "image"

        @JvmStatic
        fun newInstance(transitionName: String, title: String, body: String): DetailFragment {
            val bundle = Bundle()
            bundle.putString(EXTRA_TRANSITION_NAME, transitionName)
            bundle.putString(EXTRA_FEED_BODY, body)
            bundle.putString(EXTRA_FEED_TITLE, title)
            bundle.putString(EXTRA_FEED_IMAGE, transitionName)
            val fragment = DetailFragment()
            fragment.sharedElementEnterTransition = DetailsTransition()
            fragment.enterTransition = Fade()
            fragment.sharedElementReturnTransition = DetailsTransition()
            fragment.arguments = bundle
            return fragment
        }
    }

    @Inject
    lateinit var presenter: DetailPresenterImpl

    override fun showData(title: String?, body: String?) {
        body_txt.text = body
        title_txt.text = title
    }

    override fun detach() {
        presenter.detach()
    }


    override fun attach() {
        val transitionName = arguments?.getString(EXTRA_TRANSITION_NAME)
        item_img.load(transitionName)
        body_txt.movementMethod = ScrollingMovementMethod()
        fab.setOnClickListener { presenter.addToFavorite() }
        presenter.attachView(this)
    }


    override fun layoutRes(): Int {
        return R.layout.fragment_detail
    }
}