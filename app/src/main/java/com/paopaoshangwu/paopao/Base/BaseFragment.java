package com.paopaoshangwu.paopao.Base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

    protected P mPresenter;
    Unbinder unbinder;
    protected boolean isVisible;
    private boolean isPrepared;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getContentViewId(), container, false);
        unbinder = ButterKnife.bind(this, view);//绑定framgent
        if (null != onCreatePresenter()) {
            mPresenter = onCreatePresenter();
        }
        initView();
        initData();
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            initListener();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (null != onCreatePresenter()) {
            mPresenter = onCreatePresenter();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (null != mPresenter) {
            mPresenter.unSubscribe();
        }
    }

    protected abstract int getContentViewId();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initListener();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
            Log.e("222", "Fragment_unbinder --->执行了 ");
        }
    }

    protected abstract P onCreatePresenter();
}
