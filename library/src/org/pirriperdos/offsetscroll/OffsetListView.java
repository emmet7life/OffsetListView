package org.pirriperdos.offsetscroll;

import org.pirriperdos.offsetscroll.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ListView;

public class OffsetListView extends ListView {

	private int paddingTop;
	private int paddingBottom;
	private float relativeRatio;

	public OffsetListView(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
        init(context, attrs, defStyle);
	}

	public OffsetListView(Context context, AttributeSet attrs) {
		super(context, attrs);
        init(context, attrs, 0);
	}

	public OffsetListView(Context context) {
		super(context);
        init(context, null, 0);
	}

    private void init(Context context, AttributeSet attrs, int defStyle) {
        if (attrs != null) {
            TypedArray values = context.obtainStyledAttributes(attrs,
                    R.styleable.OffsetListView, defStyle, 0);
            paddingTop = values.getDimensionPixelSize(
            		R.styleable.OffsetListView_scrollBarPaddingTop, 0);
            paddingBottom = values.getDimensionPixelSize(
            		R.styleable.OffsetListView_scrollBarPaddingBottom, 0);
            values.recycle();
        }

	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		relativeRatio = 1.0f * (h - paddingTop - paddingBottom) / h;
	}


    protected void onDrawVerticalScrollBar(Canvas canvas, Drawable scrollBar,
            int l, int t, int r, int b) {
    	float center = (b + t) * relativeRatio / 2 + paddingTop;
    	float halfHeight = (b - t) * relativeRatio / 2;
        scrollBar.setBounds(l, (int) (center - halfHeight), r, (int) (center + halfHeight));
        scrollBar.draw(canvas);
    }
	
}
