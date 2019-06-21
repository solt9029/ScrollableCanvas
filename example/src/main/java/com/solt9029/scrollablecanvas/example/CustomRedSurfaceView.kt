package com.solt9029.scrollablecanvas.example

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.view.SurfaceHolder
import com.solt9029.scrollablecanvas.BaseSurfaceView

class CustomRedSurfaceView : BaseSurfaceView, SurfaceHolder.Callback {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    init {
        holder.setFormat(PixelFormat.TRANSLUCENT)
    }

    override fun draw() {
        val canvas = holder.lockCanvas()

        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR)

        val paint = Paint()
        paint.setARGB(255, 255, 0, 0)
        paint.style = Paint.Style.FILL
        canvas.drawCircle((width / 2).toFloat(), (height - translateYPx).toFloat(), 100f, paint)

        holder.unlockCanvasAndPost(canvas)
    }
}
