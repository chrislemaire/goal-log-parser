package nl.clemaire.domain.objects;

import nl.clemaire.domain.DOMObject;
import nl.clemaire.domain.NodeType;
import nl.clemaire.domain.RecordChildType;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Lemaire on 3-6-2017.
 */
public class Record extends DOMObject {

    public Record(Node node) {
        super(node);

        assert "objects".equals(node.getNodeName());
    }

    public void parse() {
        NodeList childs = node.getChildNodes();

        List<DOMObject> buffer = new ArrayList<DOMObject>();
        for (int i = 0; i < childs.getLength(); i++) {
            Node child = childs.item(i);

            NodeType type = RecordChildType.classify(child);
            if (type == null) {
                System.err.println("Not a matching type available for node '" + child
                        + "'\n\tin objects: '" + node.getNodeValue());
            }
            buffer.add(type.instantiate(child));
        }

        value = buffer;
    }

}
