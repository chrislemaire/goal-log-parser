package nl.clemaire.domain;

import nl.clemaire.domain.objects.Class;
import nl.clemaire.domain.objects.*;
import nl.clemaire.domain.objects.Thread;
import nl.clemaire.domain.objects.message.Message;
import org.w3c.dom.Node;

/**
 * Created by Chris Lemaire on 3-6-2017.
 */
public enum RecordChildType {

    CLASS(Class.class, "class"),
    DATE(Date.class, "date"),
    LEVEL(Level.class, "level"),
    LOGGER(Logger.class, "logger"),
    METHOD(Method.class, "method"),
    MILLIS(Millis.class, "millis"),
    SEQUENCE(Sequence.class, "sequence"),
    THREAD(Thread.class, "thread"),
    MESSAGE(Message.class, "message");

    private NodeType type;

    RecordChildType(java.lang.Class<? extends DOMObject> fClass, String nodeName) {
        type = new NodeType(fClass, nodeName);
    }

    public static NodeType classify(Node node) {
        assert node != null;

        for (RecordChildType childType : values()) {
            if (childType.type.matches(node)) {
                return childType.type;
            }
        }
        return null;
    }

}
