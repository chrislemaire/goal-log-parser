package nl.clemaire.domain.objects;

import nl.clemaire.domain.DOMObject;
import org.w3c.dom.Node;

/**
 * Created by Chris Lemaire on 3-6-2017.
 */
public class Millis extends DOMObject {

    public Millis(Node node) {
        super(node);

        assert "millis".equals(node.getNodeName());
    }

    public void parse() {
        value = Long.parseLong(node.getNodeValue());
    }

}
