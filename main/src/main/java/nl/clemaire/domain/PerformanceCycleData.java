package nl.clemaire.domain;

import nl.clemaire.parse.LinearPairParser;
import nl.clemaire.parse.PairFilter;

import java.util.Map;

/**
 * Created by Chris Lemaire on 2-6-2017.
 */
public class PerformanceCycleData {

    LinearPairParser parser;
    PairFilter filter;

    String origData;
    Map<Metric, Object> data;

    public PerformanceCycleData(String origData, LinearPairParser parser, PairFilter filter) {
        this.origData = origData;
        this.parser = parser;
        this.filter = filter;
    }

    public void parseData() {
        Map allData = parser.parse(origData);
        data = filter.filter(allData);
    }

}
