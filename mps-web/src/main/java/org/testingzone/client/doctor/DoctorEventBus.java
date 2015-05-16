package org.testingzone.client.doctor;

import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.event.EventBusWithLookup;

@Events(module = DoctorModule.class, startPresenter = DoctorListPresenter.class)
public interface DoctorEventBus extends EventBusWithLookup {
}
