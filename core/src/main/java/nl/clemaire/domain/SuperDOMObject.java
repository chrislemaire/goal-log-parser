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
        return getChilds().stream()
                .filter(obj -> obj.getNode().getNodeName().equals(name))
                .findFirst().orElse(null);
    }

    public boolean hasChild(String name) {
        return getChilds().stream()
                .anyMatch(obj -> obj.getNode().getNodeName().equals(name));
    }

}
