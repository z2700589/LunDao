package com.paopaoshangwu.paopao.UI.Fragment.Errand;

import com.paopaoshangwu.paopao.Base.BaseModel;
import com.paopaoshangwu.paopao.Base.BasePresenter;
import com.paopaoshangwu.paopao.Base.BaseView;

/**
 * Created by Android-ZJ on 2017/6/22.
 */

public interface ErrandContract {
    interface View extends BaseView {

    }

    interface Model extends BaseModel {

    }

    abstract class Presenter extends BasePresenter<View, Model> {

    }
}