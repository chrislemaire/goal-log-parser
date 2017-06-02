package nl.clemaire.domain;

/**
 * Created by Chris Lemaire on 2-6-2017.
 */
public enum PerformanceMetric {

    N_ACTIONS("actions", "env. actions", MetricType.INTEGER),
    STATE_QUERIES("state-queries", "state queries", MetricType.INTEGER),
    TOTAL_BELIEFS("beliefs", "total[beliefs", MetricType.INTEGER),
    TOTAL_GOALS("goals", "goals", MetricType.INTEGER),
    TOTAL_MESSAGES("messages", "messages", MetricType.INTEGER),
    TOTAL_PERCEPT("percepts", "percepts", MetricType.INTEGER);

    private final Metric metric;

    private PerformanceMetric(String name, String identityString, MetricType type) {
        metric = new Metric(name, identityString, type);
    }

}
