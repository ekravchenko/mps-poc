package org.testingzone.dbo.query;

import java.util.LinkedList;
import java.util.List;

public class InfoWrapperList {

    public static <T> List<T> unwrap(List<? extends AbstractInfoWrapper<T>> listToUnwrap) {
        List<T> result = new LinkedList<>();
        for(AbstractInfoWrapper<T> wrapper : listToUnwrap) {
            T t = wrapper.get();
            result.add(t);
        }
        return result;
    }
}
