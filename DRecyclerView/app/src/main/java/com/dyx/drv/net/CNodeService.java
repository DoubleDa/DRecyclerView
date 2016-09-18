package com.dyx.drv.net;

import com.dyx.drv.model.TopicsModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dayongxin on 2016/9/18.
 */
public interface CNodeService {
    @GET("/api/v1/topics")
    Call<TopicsModel> getTopicsModelDatas(@Query("page") int page, @Query("tab") String tab, @Query("limit") int limit);
}
