package com.solt9029.scrollablecanvas.example

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.view.SurfaceHolder
import com.solt9029.scrollablecanvas.BaseSurfaceView

class CustomBlueSurfaceView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : BaseSurfaceView(context, attrs, defStyle), SurfaceHolder.Callback {
    
    override fun draw() {
        val canvas = holder.lockCanvas()

        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR)

        val paint = Paint()
        paint.setARGB(255, 0, 0, 255)
        paint.style = Paint.Style.FILL
        canvas.drawCircle((width / 2).toFloat(), (height / 2 - translateYPx).toFloat(), 100f, paint)

        holder.unlockCanvasAndPost(canvas)
    }
}
