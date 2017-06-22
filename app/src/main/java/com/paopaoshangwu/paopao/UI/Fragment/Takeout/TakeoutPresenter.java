package com.paopaoshangwu.paopao.UI.Fragment.Takeout;

/**
 * Created by Android-ZJ on 2017/6/22.
 */

public class TakeoutPresenter extends TakeoutContract.Presenter {

    public TakeoutPresenter(TakeoutContract.View view) {
        mView = view;
        mModel = new TakeoutModel();
    }
}
