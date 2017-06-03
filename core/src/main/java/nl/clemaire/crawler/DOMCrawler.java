package nl.clemaire.crawler;

import nl.clemaire.domain.DOMObject;
import nl.clemaire.domain.LogType;
import nl.clemaire.domain.NodeType;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Lemaire on 3-6-2017.
 */
public class DOMCrawler {

    private Document doc;

    public DOMCrawler(Document doc) {
        this.doc = doc;
    }

    public List<DOMObject> crawl() {
        List<DOMObject> objects = new ArrayList<DOMObject>();

        Node current = doc.getElementsByTagName("log").item(0).getFirstChild();
        do {
            NodeType type = LogType.classify(current);
            if (type == null) {
                System.err.println("Not a matching type available for log-node '" + current + "'");
            }
            objects.add(type.instantiate(current));
        } while ((current = current.getNextSibling()) != null);

        return objects;
    }

}
