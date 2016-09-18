package com.dyx.drv.utils;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by dayongxin on 2016/9/18.
 */
public class PicassoUtil {
    private static PicassoUtil ourInstance = new PicassoUtil();

    public static PicassoUtil getInstance() {
        return ourInstance;
    }

    private PicassoUtil() {
    }

    public void showImg(Context context, String imgUrl, ImageView imageView) {
        Picasso.with(context).load(imgUrl).into(imageView);
    }
}
