package nl.clemaire.domain.objects;

import nl.clemaire.domain.DOMObject;
import org.w3c.dom.Node;

/**
 * {@link DOMObject} for the thread property
 * of a log record.
 *
 * @author Chris Lemaire
 */
public class Thread extends DOMObject {

    /**
     * Creates a new {@link Thread} using super constructor.
     *
     * @param node to form {@link Thread} object for.
     * @throws Exception when parsing fails.
     */
    public Thread(Node node) throws Exception {
        super(node);

        assert "thread".equals(node.getNodeName());
    }

    @Override
    public void parse() {
        value = Integer.parseInt(node.getTextContent());
    }

}
