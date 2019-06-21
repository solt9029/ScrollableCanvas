package com.solt9029.scrollablecanvas

import android.databinding.BindingAdapter

object DataBindingHelper {
    @JvmStatic @BindingAdapter("sc:height_px") // default 2000px
    fun setHeightPx(view: ScrollableCanvasContainerLayout, heightPx: Int) {
        view.setRelativeLayoutHeightPx(heightPx)
    }
}
