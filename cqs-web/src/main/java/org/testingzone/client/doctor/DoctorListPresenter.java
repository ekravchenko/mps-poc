package org.testingzone.client.doctor;

import com.google.gwt.core.client.GWT;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;
import com.mvp4g.client.view.LazyView;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import org.testingzone.client.service.DoctorService;
import org.testingzone.client.service.ErrorInfoDecoder;
import org.testingzone.vo.base.SortOrder;
import org.testingzone.vo.base.SummaryPageInfo;
import org.testingzone.vo.doctor.query.DoctorDetailsInfo;
import org.testingzone.vo.doctor.DoctorSortProperty;
import org.testingzone.vo.doctor.query.DoctorSummaryInfo;
import org.testingzone.vo.error.ErrorInfo;


@Presenter(view = DoctorListView.class)
public class DoctorListPresenter extends LazyPresenter<DoctorListPresenter.DoctorListView, DoctorEventBus> {

    interface DoctorListView extends LazyView {

    }

    @Override
    public void createPresenter() {
        super.createPresenter();

        DoctorService doctorService = GWT.create(DoctorService.class);
        doctorService.getDoctorSummaryPageInfo("3FBA226B3FF370D6", null, 0, 20, DoctorSortProperty.NAME, SortOrder.DESC,
                new MethodCallback<SummaryPageInfo<DoctorSummaryInfo>>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                System.out.println("Failed!");
            }

            @Override
            public void onSuccess(Method method, SummaryPageInfo<DoctorSummaryInfo> pageInfo) {
                System.out.println("Success!");
            }
        });

        doctorService.getDoctorDetails("31", new MethodCallback<DoctorDetailsInfo>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                System.out.println("Failed!");
                ErrorInfo errorInfo = ErrorInfoDecoder.decode(method.getResponse().getText());
                System.out.println(errorInfo);
            }

            @Override
            public void onSuccess(Method method, DoctorDetailsInfo doctorDetailsInfo) {
                System.out.println("Success!");
                System.out.println("Response:" + method.getResponse().getText());
            }
        });
    }
}
