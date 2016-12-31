package com.example.canvaspractice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.ImageView
import java.lang.Math.round

/**
 * Created by MunkyuShin on 12/31/16.
 */
class AvartarView : ImageView {

    lateinit var backgroundPaint: Paint
    lateinit var borderPaint: Paint
    lateinit var pressPaint: Paint
    lateinit var textPaint: Paint
    lateinit var bounds: RectF
    lateinit var borderBounds: RectF
    lateinit var textBounds: Rect

    constructor(context: Context?) : super(context) {

    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        backgroundPaint = Paint()
        backgroundPaint.isAntiAlias = true
        backgroundPaint.color = Color.BLUE
        backgroundPaint.style = Paint.Style.FILL

        bounds = RectF()

        borderBounds = RectF()
        borderPaint = Paint()
        borderPaint.isAntiAlias = true
        borderPaint.color = Color.WHITE
        borderPaint.alpha = 200
        borderPaint.style = Paint.Style.STROKE
        borderPaint.strokeWidth = 8f

        pressPaint = Paint()
        pressPaint.isAntiAlias = true
        pressPaint.color = Color.GREEN
        pressPaint.style = Paint.Style.FILL

        textBounds = Rect()

        textPaint = Paint()
        textPaint.isAntiAlias = true
        textPaint.color = Color.WHITE
        textPaint.textSize = 40f
        textPaint.textAlign = Paint.Align.CENTER
        textPaint.getTextBounds("M", 0, 1, textBounds)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        bounds.set(0f, 0f, measuredWidth.toFloat(), measuredHeight.toFloat())
        borderBounds.set(bounds)
        borderBounds.inset(4f, 4f)
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.let {
            it.drawOval(bounds, backgroundPaint)
            val textBottom = round((bounds.height() /2f) + (textBounds.height() / 2f))
            it.drawText("M", width/ 2f, textBottom.toFloat(), textPaint)
            it.drawOval(borderBounds, borderPaint)

            if(isPressed) {
                canvas.drawOval(bounds, pressPaint)
            }
        }
        super.onDraw(canvas)
    }

    override fun drawableStateChanged() {
        super.drawableStateChanged()
        invalidate()
    }
}
