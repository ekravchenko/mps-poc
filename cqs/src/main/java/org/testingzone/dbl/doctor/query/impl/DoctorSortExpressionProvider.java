package org.testingzone.dbl.doctor.query.impl;

import com.mysema.query.types.Expression;
import org.testingzone.dbl.base.query.builder.sort.AbstractSortExpressionProvider;
import org.testingzone.dbo.doctor.QDoctor;
import org.testingzone.vo.doctor.DoctorSortProperty;

import java.util.HashMap;
import java.util.Map;

public class DoctorSortExpressionProvider extends AbstractSortExpressionProvider {

    @Override
    protected Map<String, Expression> getExpressionMap() {
        return new HashMap<String, Expression>() {
            {
                put(DoctorSortProperty.NAME.toString(), QDoctor.doctor.doctorName);
            }
        };
    }
}
