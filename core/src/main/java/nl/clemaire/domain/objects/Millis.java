package nl.clemaire.domain.objects;

import nl.clemaire.domain.DOMObject;
import org.w3c.dom.Node;

/**
 * {@link DOMObject} for the millis property
 * of a log record.
 *
 * @author Chris Lemaire
 */
public class Millis extends DOMObject {

    /**
     * Creates a new {@link Millis} using super constructor.
     *
     * @param node to form {@link Millis} object for.
     * @throws Exception when parsing fails.
     */
    public Millis(Node node) throws Exception {
        super(node);

        assert "millis".equals(node.getNodeName());
    }

    @Override
    public void parse() {
        value = Long.parseLong(node.getTextContent());
    }

}
