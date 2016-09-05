package com.dyx.drv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dyx.drv.ui.SlideInLeftAnimatorAct;

public class MenuActivity extends Activity implements View.OnClickListener {
    private Button mBtn_rv_animator1;
    private Button mBtn_rv_animator2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtn_rv_animator1 = (Button) findViewById(R.id.btn_rv_animator1);
        mBtn_rv_animator1.setOnClickListener(this);
        mBtn_rv_animator2 = (Button) findViewById(R.id.btn_rv_animator2);
        mBtn_rv_animator2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_rv_animator1:
                intentTo(SlideInLeftAnimatorAct.class);
                break;
            case R.id.btn_rv_animator2:
                break;
            default:
                break;
        }
    }

    private void intentTo(Class<?> cla) {
        startActivity(new Intent(this, cla));
    }
}
