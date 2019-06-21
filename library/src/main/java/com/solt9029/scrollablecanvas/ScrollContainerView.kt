package com.solt9029.scrollablecanvas

import android.content.Context
import android.util.AttributeSet
import android.widget.ScrollView

class ScrollContainerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : ScrollView(context, attrs, defStyle) {
    var listener: OnScrollChangeListener? = null

    override fun onScrollChanged(x: Int, y: Int, oldX: Int, oldY: Int) {
        super.onScrollChanged(x, y, oldX, oldY)
        listener?.onScrollChange(x, y, oldX, oldY)
    }

    interface OnScrollChangeListener {
        fun onScrollChange(x: Int, y: Int, oldX: Int, oldY: Int)
    }
}