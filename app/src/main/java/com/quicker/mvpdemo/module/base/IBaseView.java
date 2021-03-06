package com.quicker.mvpdemo.module.base;

import com.trello.rxlifecycle.LifecycleTransformer;

/**
 * Created by ZhangYang on 2017/4/20.
 */

public interface IBaseView {

    void showLoading();
    void hideLoading();
    void finishRefresh();

    <T>LifecycleTransformer<T> bindToLife();

}
