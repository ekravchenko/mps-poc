package org.testingzone.client.doctor;

import com.github.gwtbootstrap.client.ui.Heading;
import com.github.gwtbootstrap.client.ui.base.DivWidget;

public class DoctorListView extends DivWidget implements DoctorListPresenter.DoctorListView {

    @Override
    public void createView() {
        add(new Heading(1, "Testing"));
    }
}
