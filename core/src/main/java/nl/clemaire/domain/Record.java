package nl.clemaire.domain;

import org.w3c.dom.Node;

/**
 * Created by Chris Lemaire on 3-6-2017.
 */
public class Record extends DOMObject {

    public Record(Node node) {
        super(node);

        assert node != null;
        assert "record".equals(node.getNodeName());
    }

    public void parse() {

    }

}
