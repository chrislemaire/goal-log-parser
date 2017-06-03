package nl.clemaire.domain;

import nl.clemaire.domain.record.Class;
import nl.clemaire.domain.record.*;
import nl.clemaire.domain.record.Thread;
import nl.clemaire.domain.record.message.Message;
import org.w3c.dom.Node;

import java.lang.reflect.InvocationTargetException;

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

    private java.lang.Class<? extends DOMObject> fClass;
    private String nodeName;

    RecordChildType(java.lang.Class<? extends DOMObject> fClass, String nodeName) {
        this.fClass = fClass;
        this.nodeName = nodeName;
    }

    public static RecordChildType classify(Node node) {
        assert node != null;

        for (RecordChildType childType : values()) {
            if (childType.nodeName.equals(node.getNodeName())) {
                return childType;
            }
        }
        return null;
    }

    public DOMObject instantiate(Node node) {
        try {
            return (DOMObject) fClass.getConstructors()[0].newInstance(node);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return new DOMObjectEmpty(node);
    }

}
