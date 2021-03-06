package com.azheng.hami.presenter.implePresenter;

import com.azheng.hami.presenter.BasePresenter;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class BasePresenterImpl implements BasePresenter {
    private CompositeSubscription compositeSubscription;

    protected void addSubscription(Subscription s) {
        if (this.compositeSubscription == null) {
            this.compositeSubscription = new CompositeSubscription();
        }
        this.compositeSubscription.add(s);
    }

    /**
     * 取消订阅
     */
    @Override
    public void unsubcrible() {
        if (this.compositeSubscription != null) {
            this.compositeSubscription.unsubscribe();
        }
    }
}
