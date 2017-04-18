package com.quicker.mvpdemo.moudle.base;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;

import com.quicker.mvpdemo.R;
import com.quicker.mvpdemo.widget.EmptyLayout;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by ZhangYang on 2017/4/17.
 */

public abstract class BaseActivity<T extends IBasePresenter> extends RxAppCompatActivity implements IBaseView{


    /**
     * 空布局
     */
    @Nullable
//    @BindView(R.id.empty_layout)
    protected EmptyLayout mEmptyLayout;

    /**
     * 子类必须提供一个Presenter的注入方法
     */
    @Inject
    protected T mPresenter;

    @Nullable
//    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipRefreshLayout;

    /**
     * 绑定布局文件
     * @return 布局文件ID
     */
    @LayoutRes
    protected abstract int attachLayoutRes();

    /**
     * Dagger注入
     */
    protected abstract void initInjector();

    /**
     * 初始化视图
     */
    protected abstract void initViews();

    /**
     * 更新视图
     */
    protected abstract void updateViews(boolean isRefresh);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void showLoding() {

    }

    @Override
    public void hideLoding() {

    }

    @Override
    public void showNetError() {

    }

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return this.<T>bindToLifecycle();
    }

    @Override
    public void finishRefresh() {

    }
}
