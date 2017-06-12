package nl.clemaire.domain.objects;

import nl.clemaire.domain.DOMObject;
import org.w3c.dom.Node;

/**
 * {@link DOMObject} for the method property
 * of a log record.
 *
 * @author Chris Lemaire
 */
public class Method extends DOMObject {

    /**
     * Creates a new {@link Method} using super constructor.
     *
     * @param node to form {@link Method} object for.
     * @throws Exception when parsing fails.
     */
    public Method(Node node) throws Exception {
        super(node);

        assert "method".equals(node.getNodeName());
    }

    @Override
    public void parse() {
        value = node.getTextContent();
    }

}
