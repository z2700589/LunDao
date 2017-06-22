package com.paopaoshangwu.paopao.UI.Fragment.Mine;

/**
 * Created by Android-ZJ on 2017/6/22.
 */

public class MinePresenter extends MineContract.Presenter {
    public MinePresenter(MineContract.View view) {
        mView = view;
        mModel = new MineModel();
    }
}
