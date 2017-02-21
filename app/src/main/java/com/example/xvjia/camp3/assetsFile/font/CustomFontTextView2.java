package com.example.xvjia.camp3.assetsFile.font;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by xvjia on 2016/3/22.
 */
public class CustomFontTextView2 extends TextView {
    public CustomFontTextView2(Context context) {
        super(context);
        init(context);
    }

    public CustomFontTextView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomFontTextView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        AssetManager am = context.getAssets();
        Typeface font = Typeface.createFromAsset(am, "fonts/STXINWEI.TTF");
        setTypeface(font);
    }
}
