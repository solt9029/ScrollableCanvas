package com.solt9029.scrollablecanvas

import android.content.Context
import android.util.AttributeSet
import android.widget.ScrollView

class ScrollContainerView : ScrollView {
    var listener: OnScrollChangeListener? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onScrollChanged(x: Int, y: Int, oldX: Int, oldY: Int) {
        super.onScrollChanged(x, y, oldX, oldY)
        listener?.onScrollChange(x, y, oldX, oldY)
    }

    interface OnScrollChangeListener {
        fun onScrollChange(x: Int, y: Int, oldX: Int, oldY: Int)
    }
}