package com.quicker.mvpdemo.module.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.quicker.mvpdemo.R;
import com.quicker.mvpdemo.module.base.BaseActivity;
import com.quicker.mvpdemo.utils.RxHelper;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;

public class WelcomeActivity extends BaseActivity {

    @OnClick(R.id.wel_skip)
    public void onClick(){
        _doSkip();
    }

    @OnClick(R.id.welcomeBg)
    public void toHomeActivity(View view) {
        startActivity(new Intent(this, HomeActivity.class));
    }

    @BindView(R.id.testTv)
    TextView testTv;

    private boolean mIsSkip = false;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initViews() {
        //透明状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    protected void updateViews(boolean isRefresh) {
        RxHelper.countdown(5)
                .compose(this.<Integer>bindToLife())
                .subscribe(new Subscriber<Integer>() {

                    @Override
                    public void onCompleted() {
                        _doSkip();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        testTv.setText("跳过 "+integer);
                    }
                });
    }


    @Override
    protected void initInjecter() {

    }

    @Override
    public void onBackPressed() {
        return;
    }

    private void _doSkip() {
//        if (!mIsSkip) {
//            mIsSkip = true;
//            finish();
//            startActivity(new Intent(SplashActivity.this, HomeActivity.class));
//            overridePendingTransition(R.anim.hold, R.anim.zoom_in_exit);
//        }

        if (!mIsSkip) {
            mIsSkip = true;
            finish();
            startActivity(new Intent(this, HomeActivity.class));
            overridePendingTransition(R.anim.hold, R.anim.zoom_in_exit);
        }

    }
}
