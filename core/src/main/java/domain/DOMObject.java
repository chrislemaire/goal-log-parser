package domain;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 * Created by Chris Lemaire on 3-6-2017.
 */
public abstract class DOMObject {

    protected Node node;

    protected Object value;

    public DOMObject(Node node) {
        assert node != null;
        this.node = node;
    }

    public abstract void parse();

    public Object getValue() {
        return value;
    }
}
