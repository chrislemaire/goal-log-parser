package nl.clemaire.crawler;

import nl.clemaire.domain.DOMObject;
import nl.clemaire.domain.objects.Record;
import nl.clemaire.domain.objects.message.Message;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;

import java.util.*;

/**
 * Created by Chris Lemaire on 3-6-2017.
 */
public class MatrixBuilder {

    private List<DOMObject> logObjects;
//    private Map<String, Map<Long, Integer>> columns;
    private Matrix matrix;


    private SortedMap<Long, List<Integer>> rows;
    private List<String> titles;
    private int nextRow;


    public MatrixBuilder(List<DOMObject> logObjects) {
        this.logObjects = logObjects;
        this.rows = new TreeMap<Long, List<Integer>>();
        this.titles = new ArrayList<String>();
        this.nextRow = 0;
    }

    public MatrixBuilder addAllMetrics() {
        for (PerformanceMetric metric : PerformanceMetric.values()) {
            addMetric(metric);
        }

        return this;
    }

    public MatrixBuilder addMetric(PerformanceMetric type) {
        addMetric(type.name(), type);

        return this;
    }

    public MatrixBuilder addMetric(String title, PerformanceMetric type) {
        assert type != null && title != null;

        titles.add(title);
        for (DOMObject obj : logObjects) {
            if (!(obj instanceof Record)) {
                continue;
            }

            Record rec = (Record) obj;

            if (rec.isPerformanceComplete()) {
                Message mess = (Message) rec.getChild("message");
                Long millis = Long.parseLong((String) rec.getChild("millis").getValue());

                fillEmptySpace(millis);

                rows.get(millis).add(nextRow, type.parse(mess));
            }
        }

        return this;
    }

    private void fillEmptySpace(Long millis) {
        if (!rows.containsKey(millis))
            rows.put(millis, new ArrayList<>());

        List<Integer> list = rows.get(millis);
        for (int i = list.size(); i < nextRow; i++) {
            list.add(-1);
        }
    }

    public MatrixBuilder setLogObjects(List<DOMObject> logObjects) {
        this.logObjects = logObjects;

        return this;
    }

    public Matrix build() {
        matrix = DenseMatrix.Factory.zeros(rows.size(), nextRow+1);



        return matrix;
    }

}
