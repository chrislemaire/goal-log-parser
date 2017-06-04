package nl.clemaire.domain;

import nl.clemaire.domain.objects.Record;
import org.w3c.dom.Node;

/**
 * Created by Chris Lemaire on 3-6-2017.
 */
public enum LogType {

    RECORD(Record.class, "record");

    private NodeType type;

    LogType(java.lang.Class<? extends DOMObject> fClass, String nodeName) {
        type = new NodeType(fClass, nodeName);
    }

    public static NodeType classify(Node node) {
        assert node != null;

        for (LogType childType : values()) {
            if (childType.type.matches(node)) {
                return childType.type;
            }
        }
        return null;
    }

}
