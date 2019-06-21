package com.solt9029.scrollablecanvas

import android.content.Context
import android.databinding.DataBindingUtil
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsoluteLayout
import com.solt9029.scrollablecanvas.databinding.ScrollableCanvasContainerLayoutBinding


class ScrollableCanvasContainerLayout : AbsoluteLayout {
    var binding: ScrollableCanvasContainerLayoutBinding? = null

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    private fun init() {
        val inflater = LayoutInflater.from(context)
        binding = DataBindingUtil.inflate(inflater, R.layout.scrollable_canvas_container_layout, this, true)
    }

    override fun addView(child: View, index: Int, params: ViewGroup.LayoutParams) {
        if (binding?.content == null) {
            super.addView(child, index, params)
            return
        }
        binding?.content?.addView(child, index, params)

    }
}