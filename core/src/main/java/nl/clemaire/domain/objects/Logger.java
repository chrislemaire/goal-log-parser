package nl.clemaire.domain.objects;

import nl.clemaire.domain.DOMObject;
import org.w3c.dom.Node;

/**
 * {@link DOMObject} for the logger property
 * of a log record.
 *
 * @author Chris Lemaire
 */
public class Logger extends DOMObject {

    /**
     * Creates a new {@link Logger} using super constructor.
     *
     * @param node to form {@link Logger} object for.
     * @throws Exception when parsing fails.
     */
    public Logger(Node node) throws Exception {
        super(node);

        assert "logger".equals(node.getNodeName());
    }

    @Override
    public void parse() {
        value = node.getTextContent();
    }

}
