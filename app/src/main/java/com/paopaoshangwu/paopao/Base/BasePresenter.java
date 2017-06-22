package com.paopaoshangwu.paopao.Base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by pao on 17-4-7.
 */

public class BasePresenter<V extends BaseView,M extends BaseModel> {
    protected V mView;
    protected M mModel;
    private CompositeSubscription mCompositeSubscription;

    protected void addSubscibe(Subscription subscription) {
        if (null == mCompositeSubscription){
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    public void unSubscribe(){
        if (null != mView){
            mView = null;
        }
        if (null != mCompositeSubscription && mCompositeSubscription .hasSubscriptions()){
            mCompositeSubscription.clear();
        }
    }
}
