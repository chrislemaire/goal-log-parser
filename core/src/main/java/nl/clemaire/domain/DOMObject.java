package nl.clemaire.domain;

import org.w3c.dom.Node;

/**
 * Simple superclass for classes representing {@link Node}
 * objects. Holds a reference to the original {@link Node}
 * and an {@link Object} field that represents the value of
 * the {@link Node}.
 *
 * @author Chris Lemaire
 */
public abstract class DOMObject {

    /**
     * Reference to the original {@link Node}
     * this {@link DOMObject} represents.
     */
    protected Node node;

    /**
     * Object representing the (important) value(s)
     * recorded in the DOM {@link Node}.
     */
    protected Object value;

    /**
     * Creates a new {@link DOMObject} from the {@link Node}
     * it represents.
     *
     * @param node this {@link DOMObject} should represent.
     */
    public DOMObject(Node node) throws Exception {
        assert node != null;
        this.node = node;

        parse();
    }

    /**
     * Parses the {@link Node} to get all interesting values
     * from it and store it as a single {@link Object} in the
     * {@link #value} field.
     */
    public abstract void parse() throws Exception;

    /**
     * Gets the {@link #node} field.
     *
     * @return the {@link #node} field.
     */
    public Node getNode() {
        return node;
    }

    /**
     * Gets the {@link #value} field.
     *
     * @return the {@link #value} field as an {@link Object}.
     */
    public Object getValue() {
        return value;
    }

}
