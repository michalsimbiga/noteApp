package com.application.utility

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.RectF
import android.graphics.Shader
import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.application.R
import com.application.constants.zero
import com.application.domain.entity.Note

class SwipeToDeleteCallback(private val onSwipeDeleteCallback: (Note) -> Unit) :
    ItemTouchHelper.SimpleCallback(Int.zero, ItemTouchHelper.LEFT) {

    private val background = ColorDrawable()
    private val backgroundColor = Color.parseColor("#f44336")
    private val clearPaint = Paint().apply { xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR) }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean = false

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        if (direction == ItemTouchHelper.LEFT) {
            if (viewHolder is NoteViewHolder) viewHolder.abstractItem?.let {
                onSwipeDeleteCallback.invoke(it)
            }
        }
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {

        val itemView = viewHolder.itemView
        val itemHeight = itemView.bottom - itemView.top
        val isCanceled = dX == 0f && !isCurrentlyActive

        if (isCanceled) {
            clearCanvas(c,itemView.right + dX,itemView.top.toFloat(),itemView.right.toFloat(),itemView.bottom.toFloat())
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            return
        }

        // Draw the red delete background
        background.color = backgroundColor

//        val gradient = LinearGradient(0f, 0f, 0f, height.toFloat(), Color.YELLOW, Color.WHITE, Shader.TileMode.MIRROR)

        val leftBound = (itemView.right + dX.toInt()).toFloat()
        val topBound = itemView.top.toFloat()
        val rightBound = itemView.right.toFloat()
        val bottomBound = itemView.bottom.toFloat()

        val myPaint = Paint().apply {
            shader = LinearGradient(
                leftBound,
                topBound,
                itemView.right.toFloat(),
                bottomBound,
                Color.TRANSPARENT,
                Color.RED,
                Shader.TileMode.CLAMP
            )
        }
        c.drawRect(leftBound, topBound, rightBound, bottomBound, myPaint)

        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }

    private fun clearCanvas(c: Canvas?, left: Float, top: Float, right: Float, bottom: Float) {
        c?.drawRect(left, top, right, bottom, clearPaint)
    }
}