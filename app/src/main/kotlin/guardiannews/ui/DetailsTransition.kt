package guardiannews.ui

import android.support.transition.*

/**
 * Created by hossam
 */
class DetailsTransition : TransitionSet() {
    init {
        ordering = ORDERING_TOGETHER
        addTransition(ChangeBounds())
        addTransition(ChangeTransform())
        addTransition(ChangeClipBounds())
        addTransition(ChangeImageTransform())
    }
}