package nl.clemaire.domain.objects.message;

import nl.clemaire.domain.DOMObject;
import org.w3c.dom.Node;

/**
 * Created by Chris Lemaire on 3-6-2017.
 */
public class Message extends DOMObject {

    public Message(Node node) {
        super(node);

        assert "message".equals(node.getNodeName());
    }

    public void parse() {
        String[] lines = node.getNodeValue().split("\n");

        MessageLine[] buffer = new MessageLine[lines.length];
        for (int i = 0; i < lines.length; i++) {
            buffer[i] = new MessageLine(lines[i]);
        }

        value = buffer;
    }

}
