package domain.record;

import domain.DOMObject;
import org.w3c.dom.Node;

/**
 * Created by Chris Lemaire on 3-6-2017.
 */
public class Sequence extends DOMObject {

    public Sequence(Node node) {
        super(node);

        assert node != null;
        assert "sequence".equals(node.getNodeName());
    }

    public void parse() {
        value = Integer.parseInt(node.getNodeValue());
    }

}
