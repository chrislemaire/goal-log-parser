package nl.clemaire.domain;

import nl.clemaire.parse.XMLParser;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Chris Lemaire on 3-6-2017.
 */
public class PerformanceMatrixGenerator {

    private String logPath;

    private Map<Integer, PerformanceCycleData> performanceCycleData;

    public PerformanceMatrixGenerator(String logPath) throws ParserConfigurationException, SAXException, IOException {
        this.logPath = logPath;

        parseFile();
    }

    public void parseFile() throws IOException, SAXException, ParserConfigurationException {
        File logFile = new File(logPath);

        XMLParser xmlParser = new XMLParser();
        Document doc = xmlParser.parse(logFile);

        
    }

}
