package com.example.canvaspractice

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.Rect
import android.graphics.drawable.Drawable

/**
 * Created by MunkyuShin on 12/31/16.
 */
class AvatarPlaceholder : Drawable() {

    // same with onMeasure when it extends View.
    override fun setBounds(bounds: Rect?) {
        super.setBounds(bounds)
    }

    override fun draw(canvas: Canvas?) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setAlpha(alpha: Int) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOpacity(): Int {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
