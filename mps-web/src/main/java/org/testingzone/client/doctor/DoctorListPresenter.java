package org.testingzone.client.doctor;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;
import com.mvp4g.client.view.LazyView;
import org.testingzone.service.doctor.RpcDoctorServiceAsync;
import org.testingzone.vo.base.*;
import org.testingzone.vo.doctor.DoctorSortProperty;
import org.testingzone.vo.doctor.query.DoctorDetailsInfo;
import org.testingzone.vo.doctor.query.DoctorSummaryInfo;


@Presenter(view = DoctorListView.class)
public class DoctorListPresenter extends LazyPresenter<DoctorListPresenter.DoctorListView, DoctorEventBus> {

    @Inject
    private RpcDoctorServiceAsync doctorService;

    interface DoctorListView extends LazyView {
    }

    @Override
    public void createPresenter() {
        super.createPresenter();

        doctorService.getDoctorSummaryPageInfo(
                SimpleFilter.EMPTY,
                new PageFilter(0, 20),
                new SortFilter(DoctorSortProperty.NAME.toString(), SortOrder.ASC),
                new AsyncCallback<SummaryPageInfo<DoctorSummaryInfo>>() {

                    @Override
                    public void onFailure(Throwable throwable) {

                    }

                    @Override
                    public void onSuccess(SummaryPageInfo<DoctorSummaryInfo> doctorSummaryInfoSummaryPageInfo) {

                    }
                });

        doctorService.getDoctorDetails("31", new AsyncCallback<DoctorDetailsInfo>() {
            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onSuccess(DoctorDetailsInfo doctorDetailsInfo) {

            }
        });
    }
}
