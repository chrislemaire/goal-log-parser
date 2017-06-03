package nl.clemaire.domain.record;

import nl.clemaire.domain.DOMObject;
import org.w3c.dom.Node;

/**
 * Created by Chris Lemaire on 3-6-2017.
 */
public class Logger extends DOMObject {

    public Logger(Node node) {
        super(node);

        assert "logger".equals(node.getNodeName());
    }

    public void parse() {
        value = node.getNodeValue();
    }

}
