package com.example.xvjia.camp3.assetsFile.Img;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by xvjia on 2016/3/21.
 */
public class AssetImg {
    public Bitmap getImageFromAssetsFile(Context context, String fileName) {
        Bitmap image = null;
        AssetManager am = context.getResources().getAssets();
        try {
            InputStream is = am.open(fileName);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            image = BitmapFactory.decodeStream(is, null, options);

            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;

    }

}
