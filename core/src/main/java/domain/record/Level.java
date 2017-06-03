package domain.record;

import domain.DOMObject;
import org.w3c.dom.Node;

/**
 * Created by Chris Lemaire on 3-6-2017.
 */
public class Level extends DOMObject {

    public Level(Node node) {
        super(node);

        assert node != null;
        assert "level".equals(node.getNodeName());
    }

    public void parse() {
        value = Integer.parseInt(node.getNodeValue());
    }

}
