package com.paopaoshangwu.paopao.Base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P mPresenter;
    Unbinder unbinder;
    private InputMethodManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        //StatusBar.setTransparentStatusBar(this, R.color.colorPrimaryDark);
        manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        ButterKnife.bind(this);
        if (null != onCreatePresenter()) {
            mPresenter = onCreatePresenter();
        }
        initView();
        initData();
        initListener();
    }

    protected abstract int getContentViewId();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();

    protected abstract P onCreatePresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mPresenter) {
            mPresenter.unSubscribe();
        }
        if (unbinder != null) {
            unbinder.unbind();
            Log.e("111", "Actiyity_unbinder --->执行了");
        }
    }

    /**
     * 点击空白处隐藏软键盘
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null) {
                manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
        return super.onTouchEvent(event);
    }

}
