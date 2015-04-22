package org.testingzone.client.doctor;

import org.gwtbootstrap3.client.ui.Heading;
import org.gwtbootstrap3.client.ui.constants.HeadingSize;
import org.gwtbootstrap3.client.ui.html.Div;

public class DoctorListView extends Div implements DoctorListPresenter.DoctorListView {

    @Override
    public void createView() {
        add(new Heading(HeadingSize.H1, "Testing"));
    }
}
