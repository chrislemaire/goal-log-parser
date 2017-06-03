package nl.clemaire.domain.objects;

import nl.clemaire.domain.DOMObject;
import org.w3c.dom.Node;

/**
 * Created by Chris Lemaire on 3-6-2017.
 */
public class Thread extends DOMObject {

    public Thread(Node node) {
        super(node);

        assert "thread".equals(node.getNodeName());
    }

    public void parse() {
        value = Integer.parseInt(node.getNodeValue());
    }

}
