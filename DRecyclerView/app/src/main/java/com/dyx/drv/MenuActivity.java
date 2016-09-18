package com.dyx.drv;

import android.os.Bundle;
import android.widget.Button;

import com.dyx.drv.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuActivity extends BaseActivity {


    @BindView(R.id.btn_rv_animator1)
    Button btnRvAnimator1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_rv_animator1)
    public void onClick() {
        intentTo(RefreshLoadMoreAct.class);
    }
}
