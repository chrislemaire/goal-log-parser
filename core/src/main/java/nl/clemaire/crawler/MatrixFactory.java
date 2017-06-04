package nl.clemaire.crawler;

import org.ujmp.core.Matrix;
import org.w3c.dom.Document;

/**
 * Created by Chris Lemaire on 4-6-2017.
 */
public class MatrixFactory {

    public static Matrix fromLogFile(String logFile) {
        XMLParser parser = new XMLParser(logFile);
        Document doc = parser.getDocument();

        DOMCrawler crawler = new DOMCrawler(doc);

        MatrixBuilder builder = new MatrixBuilder(crawler.crawl());
        builder.addAllMetrics();

        return builder.build();
    }

}
