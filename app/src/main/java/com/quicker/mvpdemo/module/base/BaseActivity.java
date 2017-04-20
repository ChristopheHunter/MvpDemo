package com.quicker.mvpdemo.module.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by ZhangYang on 2017/4/20.
 */

public abstract class BaseActivity<T extends IBasePresenter> extends RxAppCompatActivity implements IBaseView{

    @Override
    public void showLoading() {

    }
    @Override
    public void hideLoading() {

    }
    @Override
    public void finishRefresh() {

    }

    @LayoutRes
    protected abstract int attachLayoutRes();
    protected abstract void initViews();
    protected abstract void updateViews(boolean isRefresh);
    protected abstract void initInjecter();

    protected void initSwipRefresh(){

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(attachLayoutRes());
        ButterKnife.bind(this);
        initInjecter();
        initViews();
        initSwipRefresh();
        updateViews(false);
    }
}
