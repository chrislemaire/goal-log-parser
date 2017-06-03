package nl.clemaire.domain.objects.message;

import nl.clemaire.domain.DOMObject;
import org.w3c.dom.Node;

import java.util.Arrays;

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

    public MessageLine[] getLines() {
        return (MessageLine[]) getValue();
    }

    public boolean hasLine(MessageType type) {
        return Arrays.stream(getLines())
                .anyMatch(obj -> obj.getType() == type);
    }

    public MessageLine getLine(MessageType type) {
        return Arrays.stream(getLines())
                .filter(obj -> obj.getType() == type)
                .findFirst().orElse(null);
    }

}
