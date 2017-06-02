package nl.clemaire.domain;

/**
 * Created by Chris Lemaire on 2-6-2017.
 */
public enum MetricType {

    INTEGER;

    public static Object parseValue(MetricType type, String value) {
        switch (type) {
            case INTEGER:
                return Integer.parseInt(value);
            default:
                throw new IllegalArgumentException(
                        "Unknown MetricType '" + type + "'");
        }
    }

}
