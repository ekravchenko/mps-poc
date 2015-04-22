package org.testingzone.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import org.testingzone.client.doctor.DoctorModule;

public class Main implements EntryPoint {

    @Override
    public void onModuleLoad() {
        DoctorModule module = GWT.create(DoctorModule.class);
        module.createAndStartModule();
        RootPanel.get().add((Widget) module.getStartView());
    }
}
