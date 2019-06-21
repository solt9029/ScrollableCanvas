package com.solt9029.scrollablecanvas

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsoluteLayout
import android.widget.RelativeLayout


class ScrollableCanvasContainerLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : AbsoluteLayout(context, attrs, defStyle) {
    var views: MutableList<View> = mutableListOf() // views inside of container
    var scrollContainerView: ScrollContainerView? = null
    var content: AbsoluteLayout? = null
    var relativeLayout: RelativeLayout? = null

    fun setRelativeLayoutHeightPx(heightPx: Int) {
        val params = relativeLayout?.layoutParams
        params?.height = heightPx
        relativeLayout?.layoutParams = params
    }

    init {
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

        // style
        val a = context.obtainStyledAttributes(attrs, R.styleable.ScrollableCanvasContainerLayout, defStyle, 0)
        val heightPx = a.getDimensionPixelSize(R.styleable.ScrollableCanvasContainerLayout_sc_height, 2000)
        setRelativeLayoutHeightPx(heightPx)
        a.recycle()
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