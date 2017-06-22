package com.paopaoshangwu.paopao.UI.Fragment.Errand;


import android.support.v4.app.Fragment;

import com.paopaoshangwu.paopao.Base.BaseFragment;
import com.paopaoshangwu.paopao.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ErrandFragment extends BaseFragment<ErrandPresenter> implements ErrandContract.View {


    public ErrandFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_errand;
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
    protected ErrandPresenter onCreatePresenter() {
        return new ErrandPresenter(this);
    }

}
