package nl.clemaire.domain.objects;

import nl.clemaire.domain.DOMObject;
import org.w3c.dom.Node;

/**
 * {@link DOMObject} for the sequence property
 * of a log record.
 *
 * @author Chris Lemaire
 */
public class Sequence extends DOMObject {

    /**
     * Creates a new {@link Sequence} using super constructor.
     *
     * @param node to form {@link Sequence} object for.
     * @throws Exception when parsing fails.
     */
    public Sequence(Node node) throws Exception {
        super(node);

        assert "sequence".equals(node.getNodeName());
    }

    @Override
    public void parse() {
        value = Integer.parseInt(node.getTextContent());
    }

}
