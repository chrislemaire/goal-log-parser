package nl.clemaire.domain.objects;

import nl.clemaire.domain.DOMObject;
import org.w3c.dom.Node;

/**
 * {@link DOMObject} for the level property
 * of a log record.
 *
 * @author Chris Lemaire
 */
public class Level extends DOMObject {

    /**
     * Creates a new {@link Level} using super constructor.
     *
     * @param node to form {@link Level} object for.
     * @throws Exception when parsing fails.
     */
    public Level(Node node) throws Exception {
        super(node);

        assert "level".equals(node.getNodeName());
    }

    @Override
    public void parse() {
        value = node.getTextContent();
    }

}
