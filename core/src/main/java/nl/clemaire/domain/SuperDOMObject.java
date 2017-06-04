package nl.clemaire.domain;

import org.w3c.dom.Node;

import java.util.List;

/**
 * Created by Chris Lemaire on 3-6-2017.
 */
public abstract class SuperDOMObject extends DOMObject {

    public SuperDOMObject(Node node) {
        super(node);
    }

    public List<DOMObject> getChilds() {
        return (List<DOMObject>) value;
    }

    public DOMObject getChild(String name) {
        for (DOMObject child : getChilds()) {
            if (child.getNode().getNodeName().equals(name)) {
                return child;
            }
        }
        return null;
    }

    public boolean hasChild(String name) {
        return getChild(name) != null;
    }

}
