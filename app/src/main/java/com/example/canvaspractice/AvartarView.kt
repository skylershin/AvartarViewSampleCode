package com.example.canvaspractice

import android.content.Context
import android.content.res.TypedArray
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

    var borderWidth: Int = 0
    constructor(context: Context?) : super(context) {

    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        val a: TypedArray = context!!.obtainStyledAttributes(attrs, R.styleable.AvartarView, 0, 0)
        val borderColor = a.getColor(
                R.styleable.AvartarView_borderColor, Color.WHITE)
        borderWidth = a.getDimensionPixelSize(
                R.styleable.AvartarView_borderWidth, 8)
        val textColor = a.getColor(R.styleable.AvartarView_android_textColor, Color.WHITE)
        val textSize = a.getDimensionPixelSize(R.styleable.AvartarView_android_textSize, 40)
        val pressColor = a.getColor(R.styleable.AvartarView_pressColor, Color.WHITE)


        a.recycle()

        backgroundPaint = Paint()
        backgroundPaint.isAntiAlias = true
        backgroundPaint.color = Color.BLUE
        backgroundPaint.style = Paint.Style.FILL

        bounds = RectF()

        borderBounds = RectF()
        borderPaint = Paint()
        borderPaint.isAntiAlias = true
        borderPaint.color = borderColor
        borderPaint.alpha = 200
        borderPaint.style = Paint.Style.STROKE
        borderPaint.strokeWidth = borderWidth.toFloat()

        pressPaint = Paint()
        pressPaint.isAntiAlias = true
        pressPaint.color = pressColor
        pressPaint.style = Paint.Style.FILL

        textBounds = Rect()

        textPaint = Paint()
        textPaint.isAntiAlias = true
        textPaint.color = textColor
        textPaint.textSize = textSize.toFloat()
        textPaint.textAlign = Paint.Align.CENTER
        textPaint.getTextBounds("M", 0, 1, textBounds)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        bounds.set(0f, 0f, measuredWidth.toFloat(), measuredHeight.toFloat())
        borderBounds.set(bounds)
        borderBounds.inset(borderWidth/2f, borderWidth / 2f)
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
