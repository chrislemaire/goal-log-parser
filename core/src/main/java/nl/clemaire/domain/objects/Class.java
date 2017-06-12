package nl.clemaire.domain.objects;

import nl.clemaire.domain.DOMObject;
import org.w3c.dom.Node;

/**
 * {@link DOMObject} for the class property
 * of a log record.
 *
 * @author Chris Lemaire
 */
public class Class extends DOMObject {

    /**
     * Creates a new {@link Class} using super constructor.
     *
     * @param node to form {@link Class} object for.
     * @throws Exception when parsing fails.
     */
    public Class(Node node) throws Exception {
        super(node);

        assert "class".equals(node.getNodeName());
    }

    @Override
    public void parse() {
        value = node.getTextContent();
    }
}
