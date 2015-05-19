package org.testingzone.dbo.base;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;

public class SystemDataAwareDecorator {

    public static final String DEFAULT_USER = "system";

    public static void prepare(SystemDataAware systemDataAware) {
        String oldCreatedBy = systemDataAware.getCreatedBy();
        Date oldCreateTime = systemDataAware.getCreatedTime();

        Date now = new Date();
        String currentUser = getCurrentUser();

        Date createdTime = oldCreateTime != null ? oldCreateTime : now;
        String createdBy = oldCreatedBy != null ? oldCreatedBy : currentUser;

        systemDataAware.setUpdatedTime(now);
        systemDataAware.setCreatedTime(createdTime);
        systemDataAware.setCreatedBy(createdBy);
        systemDataAware.setUpdatedBy(currentUser);
    }

    private static String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getName() != null) {
            return authentication.getName();
        }
        return DEFAULT_USER;
    }
}
