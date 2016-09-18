package com.dyx.drv.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dyx.drv.R;
import com.dyx.drv.model.TopicsModel;
import com.dyx.drv.utils.PicassoUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dayongxin on 2016/9/18.
 */
public class RefreshLoadMoreAdapter extends RecyclerView.Adapter<RefreshLoadMoreAdapter.RlmViewHolder> {
    private Context mContext;
    private List<TopicsModel.DataBean> mDatas;

    public RefreshLoadMoreAdapter(Context mContext, List<TopicsModel.DataBean> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @Override
    public RlmViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_refresh_more, parent, false);
        return new RlmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RlmViewHolder holder, int position) {
        /**
         * 加载图片
         */
        PicassoUtil.getInstance().showImg(mContext, mDatas.get(position).getAuthor().getAvatar_url(), holder.ivAvatarUrl);
        /**
         * 用户名称
         */
        holder.tvLoginname.setText(mDatas.get(position).getAuthor().getLoginname());
        /**
         * 帖子标题
         */
        holder.tvTitle.setText(mDatas.get(position).getTitle());
    }

    public void setData(List<TopicsModel.DataBean> mDatas) {
        mDatas = mDatas;
    }

    public void addDatas(List<TopicsModel.DataBean> mDatas) {
        mDatas.addAll(mDatas);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class RlmViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_avatar_url)
        ImageView ivAvatarUrl;
        @BindView(R.id.tv_loginname)
        TextView tvLoginname;
        @BindView(R.id.tv_title)
        TextView tvTitle;

        public RlmViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
