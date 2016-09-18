package com.dyx.drv.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dyx.drv.R;
import com.orhanobut.logger.Logger;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dayongxin on 2016/9/5.
 */
public class AnimatorAdapter extends RecyclerView.Adapter<AnimatorAdapter.AnimatorViewHolder> {
    private List<String> mDatas;
    private Context mContext;

    public AnimatorAdapter(List<String> mDatas, Context mContext) {
        this.mDatas = mDatas;
        this.mContext = mContext;
        Logger.d(mDatas);
    }

    @Override
    public AnimatorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_image, parent, false);
        return new AnimatorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AnimatorViewHolder holder, int position) {
        Picasso.with(mContext).load(mDatas.get(position)).into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class AnimatorViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_image)
        ImageView ivImage;

        public AnimatorViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
