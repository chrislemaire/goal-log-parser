package nl.clemaire.domain;

/**
 * Created by Chris Lemaire on 2-6-2017.
 */
public class Metric {

    private String name;

    private MetricType type;

    public Metric(String name, MetricType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public MetricType getType() {
        return type;
    }
}
