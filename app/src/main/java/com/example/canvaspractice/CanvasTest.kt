package com.example.canvaspractice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Created by MunkyuShin on 12/30/16.
 */
class CanvasTest : View {
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    override fun onDraw(canvas: Canvas?) {
        val paint = Paint()
        paint.color = Color.WHITE
        canvas?.let {
           it.drawRect(5f, 5f, 50f, 50f, paint)
            it.translate(100f, 100f)
            it.drawOval(0f, 0f, 50f, 50f, paint)
        }

    }
}
