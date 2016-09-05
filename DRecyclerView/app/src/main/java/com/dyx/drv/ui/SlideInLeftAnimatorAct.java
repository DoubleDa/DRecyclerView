package com.dyx.drv.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.OvershootInterpolator;

import com.dyx.drv.R;
import com.dyx.drv.adapter.AnimatorAdapter;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInDownAnimator;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;
import jp.wasabeef.recyclerview.animators.SlideInRightAnimator;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * Created by dayongxin on 2016/9/5.
 * https://github.com/wasabeef/recyclerview-animators
 */
public class SlideInLeftAnimatorAct extends Activity {
    private RecyclerView mRv_item;
    private AnimatorAdapter mAnimatorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_in_left_animator);
        initRecyclerView();
    }

    private void initRecyclerView() {
        mRv_item = (RecyclerView) findViewById(R.id.rv_item);
        mRv_item.setLayoutManager(new LinearLayoutManager(this));
        mRv_item.setHasFixedSize(true);
        //mRv_item.setItemAnimator(new SlideInDownAnimator());
        //mRv_item.setItemAnimator(new SlideInLeftAnimator());
        //mRv_item.setItemAnimator(new SlideInRightAnimator());
        mRv_item.setItemAnimator(new SlideInUpAnimator(new OvershootInterpolator(1f)));
        mAnimatorAdapter = new AnimatorAdapter(getData(), this);
        mRv_item.setAdapter(mAnimatorAdapter);
    }

    private List<String> getData() {
        List<String> mDatas = new ArrayList<>();
        mDatas.add("http://tnfs.tngou.net/image/lore/160901/c7850bd63b1a30b44406ade1f25d3fda.jpg");
        mDatas.add("http://tnfs.tngou.net/image/lore/160901/acae627b752dde41b2074eb1e50fe321.jpg");
        mDatas.add("http://tnfs.tngou.net/image/lore/160901/097b82b27c75ac1a15c9d5461ede79ae.jpg");
        mDatas.add("http://tnfs.tngou.net/image/lore/160901/f051d97d84571c14e52716de4229da58.jpg");
        mDatas.add("http://tnfs.tngou.net/image/lore/160901/35aa48fef78cdfe88bc37b6d443f8aad.jpg");
        mDatas.add("http://tnfs.tngou.net/image/lore/160901/791f0b6e7e5d0c141c9a051a39191186.jpg");
        mDatas.add("http://tnfs.tngou.net/image/lore/160901/878457777dd036a4c2850e58a4cad260.jpg");
        mDatas.add("http://tnfs.tngou.net/image/lore/160901/348c00f0ae24f397b4ea915eb1451177.jpg");
        mDatas.add("http://tnfs.tngou.net/image/lore/160901/af58719444a416be08574d0f6b6b9f30.jpg");
        mDatas.add("http://tnfs.tngou.net/image/lore/160901/f01920594770ed205a4260be42a71cc6.jpg");
        mDatas.add("http://tnfs.tngou.net/image/lore/160901/25e886718d20f7e368fc09fd1f1fd405.jpg");
        mDatas.add("http://tnfs.tngou.net/image/lore/160901/0f57903947089598ac3f5479a65fd4e2.jpg");
        mDatas.add("http://tnfs.tngou.net/image/lore/160901/2cc91880d7a7a407011c96234c6404e6.jpg");
        mDatas.add("http://tnfs.tngou.net/image/lore/160901/ca784cfaafd6b7a019a404e8b0bd9055.jpg");
        mDatas.add("http://tnfs.tngou.net/image/lore/160831/789fe8ec034ffbf5e958a95bc1fea159.jpg");
        return mDatas;
    }
}
