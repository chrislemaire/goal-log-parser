package nl.clemaire.domain;

import org.w3c.dom.Node;

import java.lang.reflect.InvocationTargetException;

/**
 * A type of {@link Node} that may be found in a {@link org.w3c.dom.Document}.
 * This type couples the name of the {@link Node} with a {@link DOMObject}
 * extending representation of the type of {@link Node}
 *
 * Adding a class representation of a {@link Node} lets certain {@link NodeType}s
 * be interpreted in different ways, as this parsing of the {@link Node}
 * may be customized in the class.
 *
 * @author Chris Lemaire
 */
public class NodeType {

    /**
     * Class representation of the {@link Node} type.
     */
    private java.lang.Class<? extends DOMObject> fClass;

    /**
     * Name of the {@link Node} as displayed in the parsed XML file.
     */
    private String nodeName;

    /**
     * Create a {@link NodeType} by its fields.
     *
     * @param fClass representation of the {@link Node}.
     * @param nodeName tag name of the linked {@link Node}.
     */
    public NodeType(Class<? extends DOMObject> fClass, String nodeName) {
        this.fClass = fClass;
        this.nodeName = nodeName;
    }

    /**
     * Whether this {@link NodeType} matches with a certain {@link Node}.
     * Determined by checking whether nodeName fields match.
     *
     * @param node to check names with.
     * @return <code>true</code> when <code>nodeName==Node.getNodeName()</code>
     */
    public boolean matches(Node node) {
        return nodeName.equals(node.getNodeName());
    }

    /**
     * Instantiates a {@link DOMObject} from a given {@link Node}
     * with the type of this {@link NodeType}'s {@link #fClass} field.
     *
     * @param node to instantiate the {@link DOMObject} with.
     * @return instantiated {@link DOMObject} representing given {@link Node}.
     */
    public DOMObject instantiate(Node node)
            throws Exception {
        assert node != null;

        try {
            return fClass.getConstructor(Node.class).newInstance(node);
        } catch (IllegalAccessException|InvocationTargetException|InstantiationException|NoSuchMethodException e) {
            System.err.println("Couldn't instantiate class '" + fClass.getName() + "'");
            throw e;
        }
    }

    /**
     * Returns a String representing this {@link NodeType}
     * by the {@link #nodeName} and the {@link #fClass} fields.
     *
     * @return String representation of this {@link NodeType}.
     */
    public String toString() {
        return "NodeType<" + fClass.getName() + ", " + nodeName + ">";
    }

}
