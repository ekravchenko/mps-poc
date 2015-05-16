package org.testingzone.dbl.base.query;

import org.testingzone.vo.base.PageFilter;
import org.testingzone.vo.base.SortFilter;
import org.testingzone.vo.base.SummaryPageInfo;

import java.util.List;

public interface SummaryQuery<Filter, SummaryInfo> {

    long count(Filter filter);

    SummaryPageInfo<SummaryInfo> getSummaryPageInfo(Filter filter, PageFilter pageFilter, SortFilter sortFilter);

    List<SummaryInfo> getSummaryInfoList(Filter filter);

    List<SummaryInfo> getSummaryInfoList(Filter filter, PageFilter pageFilter, SortFilter sortFilter);
}
