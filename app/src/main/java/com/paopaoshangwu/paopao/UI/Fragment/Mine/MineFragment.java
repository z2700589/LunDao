package com.paopaoshangwu.paopao.UI.Fragment.Mine;


import android.support.v4.app.Fragment;

import com.paopaoshangwu.paopao.Base.BaseFragment;
import com.paopaoshangwu.paopao.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment<MinePresenter> implements MineContract.View {


    public MineFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_mine;
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
    protected MinePresenter onCreatePresenter() {
        return null;
    }

}
