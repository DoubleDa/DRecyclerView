package com.dyx.drv.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by dayongxin on 2016/9/18.
 */
public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void intentTo(Class<?> cla) {
        startActivity(new Intent(this, cla));
    }
}
