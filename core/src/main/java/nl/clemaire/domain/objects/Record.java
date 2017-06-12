package nl.clemaire.domain.objects;

import nl.clemaire.domain.DOMObject;
import nl.clemaire.domain.NodeType;
import nl.clemaire.domain.RecordChildType;
import nl.clemaire.domain.SuperDOMObject;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link DOMObject} for the record property
 * of a full log.
 *
 * @author Chris Lemaire
 */
public class Record extends SuperDOMObject {

    /**
     * Creates a new {@link Record} using super constructor.
     *
     * @param node to form {@link Record} object for.
     * @throws Exception when parsing fails.
     */
    public Record(Node node) throws Exception {
        super(node);

        assert "record".equals(node.getNodeName());
    }

    @Override
    public void parse()
            throws Exception {
        NodeList childs = node.getChildNodes();

        List<DOMObject> buffer = new ArrayList<>();
        for (int i = 0; i < childs.getLength(); i++) {
            Node child = childs.item(i);

            NodeType type = RecordChildType.classify(child);
            if (type == null) {
                System.err.println("Not a matching type available for node '" + child
                        + "'\n\tin objects: '" + node.getTextContent());
            } else {
                buffer.add(type.instantiate(child));
            }
        }

        value = buffer;
    }

    /**
     * Checks whether this record has a message containing
     * performance data and is valid otherwise (i.e. it has
     * a millis property).
     *
     * @return <code>true</code> when the record has performance
     *          data and is valid.
     */
    public boolean isPerformanceComplete() {
        return hasChild("message") && hasChild("millis");
    }

}
