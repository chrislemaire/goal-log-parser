package nl.clemaire.domain;

import org.w3c.dom.Node;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Chris Lemaire on 3-6-2017.
 */
public class NodeType {

    private java.lang.Class<? extends DOMObject> fClass;
    private String nodeName;

    public NodeType(Class<? extends DOMObject> fClass, String nodeName) {
        this.fClass = fClass;
        this.nodeName = nodeName;
    }

    public boolean matches(Node node) {
        if (nodeName.equals(node.getNodeName())) {
            return true;
        }
        return false;
    }

    public DOMObject instantiate(Node node) {
        if (node != null) {
            try {
                return fClass.getConstructor(Node.class).newInstance(node);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return new DOMObjectEmpty(node);
    }

    public String toString() {
        return "NodeType<" + fClass.getName() + ", " + nodeName + ">";
    }

}
