package com.paopaoshangwu.paopao.UI.Fragment.Takeout;


import android.support.v4.app.Fragment;

import com.paopaoshangwu.paopao.Base.BaseFragment;
import com.paopaoshangwu.paopao.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TakeoutFragment extends BaseFragment<TakeoutPresenter> implements TakeoutContract.View{


    public TakeoutFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_takeout;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected TakeoutPresenter onCreatePresenter() {
        return new TakeoutPresenter(this);
    }

}
