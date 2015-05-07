package org.testingzone.dbl.base.query;

import org.testingzone.vo.base.PageFilter;
import org.testingzone.vo.base.SortFilter;
import org.testingzone.vo.base.SummaryPageInfo;

import java.util.List;

public abstract class AbstractSummaryQuery<Filter, SummaryInfo>
        implements SummaryQuery<Filter, SummaryInfo> {

    @Override
    public SummaryPageInfo<SummaryInfo> getSummaryPageInfo(Filter filter, PageFilter pageFilter, SortFilter sortFilter) {
        long total = count(filter);
        if (total == 0) {
            return new SummaryPageInfo<>(total);
        }

        List<SummaryInfo> list = getSummaryInfoList(filter, pageFilter, sortFilter);
        return new SummaryPageInfo<>(total, list);
    }

    @Override
    public List<SummaryInfo> getSummaryInfoList(Filter filter) {
        return getSummaryInfoList(filter, PageFilter.NONE, SortFilter.NONE);
    }
}
