package com.paopaoshangwu.paopao.UI.Activity.Main;

/**
 * Created by Administrator on 2017/4/7.
 */

public class MainPresenter extends MainContract.Presenter {


    public MainPresenter(MainContract.View view) {
        mView = view;
        mModel = new MainModel();
    }

}
