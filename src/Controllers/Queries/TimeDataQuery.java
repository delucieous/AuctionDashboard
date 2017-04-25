package Controllers.Queries;

import Model.DBEnums.DateEnum;
import Model.DBEnums.attributes.Attribute;
import Views.MetricType;
import Views.ViewPresets.AttributeType;

import java.time.Instant;
import java.util.List;
import java.util.Map;

/**
 * Class which contains a a query for a series of data in terms of date.
 */
public class TimeDataQuery extends Query {

    private DateEnum granularity;
    private Instant startDate;
    private Instant endDate;
    private Map<AttributeType, List<String>> filters;

    public TimeDataQuery(TimeQueryBuilder b) {
        super(b);
        this.granularity = b.getGranularity();
        this.startDate = b.getStartDate();
        this.endDate = b.getEndDate();
    }

    public DateEnum getGranularity() {
        return granularity;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public Map<AttributeType, List<String>> getFilters() {
        return this.filters;
    }

    public TimeDataQuery deriveQuery(MetricType metric) {
        TimeQueryBuilder newBuilder = new TimeQueryBuilder(metric);
        TimeDataQuery newQuery = newBuilder.granularity(this.granularity)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .filters(this.getFilters())
                .build();

        return newQuery;

    }
}