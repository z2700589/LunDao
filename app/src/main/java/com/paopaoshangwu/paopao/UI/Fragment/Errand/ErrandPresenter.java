package com.paopaoshangwu.paopao.UI.Fragment.Errand;

/**
 * Created by Android-ZJ on 2017/6/22.
 */

public class ErrandPresenter extends ErrandContract.Presenter {
    public ErrandPresenter(ErrandContract.View view) {
        mView = view;
        mModel = new ErrandModel();
    }
}
