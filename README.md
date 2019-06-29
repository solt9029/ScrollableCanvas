# ScrollableCanvas

[![](https://jitpack.io/v/solt9029/ScrollableCanvas.svg)](https://jitpack.io/#solt9029/ScrollableCanvas)

## Setup

( [https://jitpack.io/#solt9029/ScrollableCanvas](https://jitpack.io/#solt9029/ScrollableCanvas) )

- Add the JitPack repository to your build file.

```gradle
    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
```

- Add the dependency.

```gradle
    dependencies {
        implementation 'com.github.solt9029:ScrollableCanvas:Tag'
    }
```



## Example

### Layout

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:orientation="vertical"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">

    <com.solt9029.scrollablecanvas.ScrollableCanvasContainerLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:sc_height="5000dp">

        <com.solt9029.scrollablecanvas.example.CustomRedSurfaceView
                android:layout_width="match_parent"
                android:layout_height="match_parent"/>

        <com.solt9029.scrollablecanvas.example.CustomBlueSurfaceView
                android:layout_width="match_parent"
                android:layout_height="match_parent"/>
    </com.solt9029.scrollablecanvas.ScrollableCanvasContainerLayout>
</LinearLayout>
```

### Custom surface view

- Your custom surface view has to extend BaseSurfaceView and override draw function.

```kotlin
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
```

```kotlin
class CustomRedSurfaceView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : BaseSurfaceView(context, attrs, defStyle), SurfaceHolder.Callback {
    
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
```
