package com.solt9029.scrollablecanvas

import android.databinding.BindingAdapter

object DataBindingHelper {
//    @JvmStatic @BindingAdapter("onScrollChange")
//    fun setOnScrollChangeListener(
//        view: ScrollableCanvasContainerLayout,
//        listener: ScrollContainerView.OnScrollChangeListener
//    ) {
//        view.binding?.scrollContainerView?.listener = listener
//    }

    @JvmStatic @BindingAdapter("height")
    fun setHeight(view: ScrollableCanvasContainerLayout, height: Int) {
        val params = view.binding?.relativeLayout?.layoutParams
        params?.height = height
        view.binding?.relativeLayout?.layoutParams = params
    }
}
