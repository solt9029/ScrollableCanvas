package com.solt9029.scrollablecanvas

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsoluteLayout
import android.widget.RelativeLayout

class ScrollableCanvasContainerLayout : AbsoluteLayout {
    var views: MutableList<View> = mutableListOf() // views inside of container
    var scrollContainerView: ScrollContainerView? = null
    var content: AbsoluteLayout? = null
    var relativeLayout: RelativeLayout? = null

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
        LayoutInflater.from(context).inflate(R.layout.scrollable_canvas_container_layout, this)
        
        scrollContainerView = findViewById(R.id.scroll_container_view)
        content = findViewById(R.id.content)
        relativeLayout = findViewById(R.id.relative_layout)

        scrollContainerView?.listener = object : ScrollContainerView.OnScrollChangeListener {
            override fun onScrollChange(x: Int, y: Int, oldX: Int, oldY: Int) {
                views.forEach {
                    if (it is BaseSurfaceView) {
                        it.updateTranslateYPx(y)
                    }
                }
            }
        }
    }

    override fun addView(child: View, index: Int, params: ViewGroup.LayoutParams) {
        if (content == null) {
            super.addView(child, index, params)
            return
        }

        content?.addView(child, index, params)
        views.add(child)
    }
}