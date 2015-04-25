package org.testingzone.dbl.base.query;

import org.testingzone.vo.base.PageFilter;

import java.util.List;

public interface SummaryQuery<Filter, SummaryInfo> {

    long count(Filter filter);

    List<SummaryInfo> getSummaryInfoList(Filter filter);

    List<SummaryInfo> getSummaryInfoList(Filter filter, PageFilter pageFilter);
}
