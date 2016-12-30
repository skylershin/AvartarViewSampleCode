package com.example.canvaspractice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Created by MunkyuShin on 12/30/16.
 */
class RectTest : View {
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    override fun onDraw(canvas: Canvas?) {
        val paint = Paint()
        canvas?.let {
           it.drawRect(5f, 5f, 10f, 10f, paint)
        }

    }
}
