package com.dyx.drv;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.dyx.drv.adapter.RefreshLoadMoreAdapter;
import com.dyx.drv.base.BaseActivity;
import com.dyx.drv.constants.ApiConstants;
import com.dyx.drv.model.TopicsModel;
import com.dyx.drv.net.CNodeService;
import com.dyx.drv.view.DividerItemDecoration;
import com.dyx.drv.view.LoadMoreRecyclerView;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dayongxin on 2016/9/18.
 */
public class RefreshLoadMoreAct extends BaseActivity {
    @BindView(R.id.lmrv_root)
    LoadMoreRecyclerView lmrvRoot;
    @BindView(R.id.srl_root)
    SwipeRefreshLayout srlRoot;
    /**
     * 适配器
     */
    private RefreshLoadMoreAdapter mRefreshLoadMoreAdapter;
    /**
     * 初始页面
     */
    private int page = 1;
    private List<TopicsModel.DataBean> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_load_more);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        lmrvRoot.setHasFixedSize(true);
        lmrvRoot.setLayoutManager(new LinearLayoutManager(this));
        lmrvRoot.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        getDataFromServer(page);
        mRefreshLoadMoreAdapter = new RefreshLoadMoreAdapter(RefreshLoadMoreAct.this, mDatas);
        lmrvRoot.setAdapter(mRefreshLoadMoreAdapter);
        lmrvRoot.setAutoLoadMoreEnable(true);
        /**
         * 加载更多
         */
        lmrvRoot.setLoadMoreListener(new LoadMoreRecyclerView.LoadMoreListener() {
            @Override
            public void onLoadMore() {
                srlRoot.setRefreshing(false);
                page++;
                getDataFromServer(page);
                Logger.d(page);
            }
        });
        /**
         * 下拉刷新
         */
        srlRoot.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srlRoot.setRefreshing(false);
                page = 1;
                getDataFromServer(page);
            }
        });

    }

    private void getDataFromServer(final int page) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.HOST_URL).addConverterFactory(GsonConverterFactory.create())
                .build();

        CNodeService service = retrofit.create(CNodeService.class);

        Call<TopicsModel> results = service.getTopicsModelDatas(page, ApiConstants.CATEGORY_TAB, ApiConstants.LIMIT_NUM);

        results.enqueue(new Callback<TopicsModel>() {
            @Override
            public void onResponse(Call<TopicsModel> call, Response<TopicsModel> response) {
                if (response != null) {
                    TopicsModel topicsModel = response.body();
                    if (topicsModel.isSuccess()) {
                        if (page == 1) {
                            mDatas.clear();
                            mDatas.addAll(topicsModel.getData());
                            mRefreshLoadMoreAdapter.notifyDataSetChanged();
                            lmrvRoot.setAdapter(mRefreshLoadMoreAdapter);

                        } else {
                            mDatas.addAll(mDatas.size(), topicsModel.getData());
                            mRefreshLoadMoreAdapter.notifyItemInserted(mDatas.size());
                            lmrvRoot.setAdapter(mRefreshLoadMoreAdapter);

                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<TopicsModel> call, Throwable t) {

            }
        });
    }
}
