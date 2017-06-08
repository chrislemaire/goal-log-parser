package nl.clemaire.domain.objects.message;

import nl.clemaire.domain.DOMObject;
import org.w3c.dom.Node;

import java.util.InputMismatchException;

/**
 * {@link DOMObject} for the message {@link nl.clemaire.domain.NodeType}.
 * Adds methods for getting and checking the presence of individual
 * {@link MessageLine}s.
 *
 * @see MessageLine
 * @see MessageType
 *
 * @author Chris Lemaire
 */
public class Message extends DOMObject {

    /**
     * Creates a new {@link Message} from super constructor.
     *
     * @param node this {@link Message} object should represent.
     */
    public Message(Node node) {
        super(node);

        assert "message".equals(node.getNodeName());
    }

    @Override
    public void parse() {
        String[] lines = node.getTextContent().split("\n");

        MessageLine[] buffer = new MessageLine[lines.length];
        for (int i = 0; i < lines.length; i++) {
            try {
                buffer[i] = new MessageLine(lines[i]);
            } catch (InputMismatchException e) {
                System.err.println("Couldn't match '" + lines[i] + "' to an existing MessageType.");
            }
        }

        value = buffer;
    }

    /**
     * Gets all {@link MessageLine}s contained in this one
     * {@link Message}.
     *
     * @return a list of all {@link MessageLine}s in this {@link Message}.
     */
    public MessageLine[] getLines() {
        return (MessageLine[]) getValue();
    }

    /**
     * The first line of a certain {@link MessageType}. This assumes
     * there is only a single {@link MessageLine} of the
     * requested type.
     *
     * @param type the returned line must match.
     * @return first {@link MessageLine} of given type or <code>null</code>
     *          if none is found.
     */
    public MessageLine getLine(MessageType type) {
        for (MessageLine line : getLines()) {
            if (line != null && line.getType() == type) {
                return line;
            }
        }
        return null;
    }

    /**
     * Checks whether there is a {@link MessageLine} of given
     * {@link MessageType}.
     *
     * @param type the matched {@link MessageLine} must be.
     * @return <code>true</code> when a {@link MessageLine} is
     *          found of the given type.
     */
    public boolean hasLine(MessageType type) {
        return getLine(type) != null;
    }

}
