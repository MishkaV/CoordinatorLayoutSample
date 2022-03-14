package io.mishkav.coordinatorlayoutsample.behaviors

import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.math.MathUtils
import androidx.core.view.ViewCompat
import io.mishkav.coordinatorlayoutsample.customView.PacManView

class PacmanBehavior(onScroll: () -> Unit = {}) : CoordinatorLayout.Behavior<PacManView>() {

    private val onScroll: () -> Unit

    init {
        this.onScroll = onScroll
    }

    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: PacManView,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL
    }

    override fun onNestedPreScroll(
        coordinatorLayout: CoordinatorLayout,
        child: PacManView,
        target: View,
        dx: Int,
        dy: Int,
        consumed: IntArray,
        type: Int
    ) {
        child.translationY = MathUtils.clamp(child.translationY + dy, 0f, child.minimumHeight.toFloat())
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)
    }
}