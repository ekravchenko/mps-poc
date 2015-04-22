package org.testingzone.client.doctor;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;
import com.mvp4g.client.view.LazyView;

@Presenter(view = DoctorListView.class)
public class DoctorListPresenter extends LazyPresenter<DoctorListPresenter.DoctorListView, DoctorEventBus>{

    interface DoctorListView extends LazyView {

    }

    @Override
    public void createPresenter() {
        super.createPresenter();
        System.out.println("I can test here!");
    }
}
