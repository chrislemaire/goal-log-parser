package nl.clemaire.domain;

import org.w3c.dom.Node;

import java.util.List;

/**
 * Parent {@link DOMObject} that should contain children
 * nodes in the {@link org.w3c.dom.Document} structure.
 *
 * @author Chris Lemaire
 */
public abstract class SuperDOMObject extends DOMObject {

    /**
     * Create a new {@link SuperDOMObject} from the {@link org.w3c.dom.Document}
     * {@link Node} object it should represent.
     *
     * @param node with children from {@link org.w3c.dom.Document}.
     */
    public SuperDOMObject(Node node) throws Exception {
        super(node);
    }

    /**
     * Gets all child {@link Node}s by casting the value
     * field for a {@link DOMObject}.
     *
     * @return list of {@link DOMObject}s representing child {@link Node}s.
     */
    public List<DOMObject> getChilds() {
        return (List<DOMObject>) value;
    }

    /**
     * Gets a single child {@link Node} representing {@link DOMObject}
     * with given name from the list given by {@link #getChilds()}.
     *
     * @param name the {@link Node} should have.
     * @return {@link DOMObject} representing requested child {@link Node}.
     */
    public DOMObject getChild(String name) {
        for (DOMObject child : getChilds()) {
            if (child.getNode().getNodeName().equals(name)) {
                return child;
            }
        }
        return null;
    }

    /**
     * Checks whether this {@link SuperDOMObject} contains a child
     * {@link Node} representation with given name.
     *
     * @param name to check against.
     * @return <code>true</code> when a {@link Node} with given name
     *          is in the list of childs for this object.
     */
    public boolean hasChild(String name) {
        return getChild(name) != null;
    }

}
