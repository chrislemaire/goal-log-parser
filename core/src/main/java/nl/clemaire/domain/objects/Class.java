package nl.clemaire.domain.objects;

import nl.clemaire.domain.DOMObject;
import org.w3c.dom.Node;

/**
 * Created by Chris Lemaire on 3-6-2017.
 */
public class Class extends DOMObject {

    public Class(Node node) {
        super(node);

        assert "class".equals(node.getNodeName());
    }

    public void parse() {
        value = node.getTextContent();
    }
}
