package org.testingzone.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import org.fusesource.restygwt.client.Defaults;
import org.testingzone.client.doctor.DoctorModule;
import org.testingzone.service.BaseConstants;

public class Main implements EntryPoint {

    @Override
    public void onModuleLoad() {
        Defaults.setServiceRoot("http://localhost:8080" + BaseConstants.Uri.CONTEXT_ROOT);

        DoctorModule module = GWT.create(DoctorModule.class);
        module.createAndStartModule();
        RootPanel.get().add((Widget) module.getStartView());
    }
}
