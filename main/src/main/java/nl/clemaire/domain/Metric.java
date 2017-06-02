package nl.clemaire.domain;

/**
 * Created by Chris Lemaire on 2-6-2017.
 */
public class Metric {

    private String name;

    private String identityString;

    private MetricType type;

    public Metric(String name, String identityString, MetricType type) {
        this.name = name;
        this.identityString = identityString;
        this.type = type;
    }

    public Object parseValue(String value) {
        return MetricType.parseValue(type, value);
    }

    public String getName() {
        return name;
    }

    public MetricType getType() {
        return type;
    }

    public String getIdentityString() {
        return identityString;
    }
}
