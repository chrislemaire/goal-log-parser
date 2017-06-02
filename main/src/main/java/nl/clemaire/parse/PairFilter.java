package nl.clemaire.parse;

import nl.clemaire.domain.Metric;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Chris Lemaire on 3-6-2017.
 */
public class PairFilter {

    private List<Metric> metricFilters;

    public PairFilter(List<Metric> metricFilters) {
        this.metricFilters = metricFilters;
    }

    public Map<String, String> filter(Map<String, String> pairs) {
        Map<String, String> filteredPairs = new HashMap<String, String>();

        for (Metric metric : metricFilters) {
            if (pairs.containsKey(metric.getName())) {
                filteredPairs.put(metric.getName(), pairs.get(metric.getName()));
            }
        }

        return filteredPairs;
    }
}
