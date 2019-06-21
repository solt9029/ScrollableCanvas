package com.solt9029.scrollablecanvas

import android.databinding.BindingAdapter

object DataBindingHelper {
    @JvmStatic @BindingAdapter("sc:height") // default 2000px
    fun setHeight(view: ScrollableCanvasContainerLayout, height: Int) {
        val params = view.relativeLayout?.layoutParams
        params?.height = height
        view.relativeLayout?.layoutParams = params
    }
}
