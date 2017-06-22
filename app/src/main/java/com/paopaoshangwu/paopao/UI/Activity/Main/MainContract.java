package com.paopaoshangwu.paopao.UI.Activity.Main;

import com.paopaoshangwu.paopao.Base.BaseModel;
import com.paopaoshangwu.paopao.Base.BasePresenter;
import com.paopaoshangwu.paopao.Base.BaseView;

/**
 * Created by Administrator on 2017/4/7.
 */

public interface MainContract {

    interface View extends BaseView {


    }

    interface Model extends BaseModel {

    }

    abstract class Presenter extends BasePresenter<View, Model> {

    }
}
