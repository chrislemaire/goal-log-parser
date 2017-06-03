package domain.record;

import domain.DOMObject;
import org.w3c.dom.Node;

import java.text.ParseException;
import java.util.InputMismatchException;

/**
 * Created by Chris Lemaire on 3-6-2017.
 */
public class Millis extends DOMObject {

    public Millis(Node node) {
        super(node);

        assert node != null;
        assert "millis".equals(node.getNodeName());
    }

    public void parse() {
        value = Long.parseLong(node.getNodeValue());
    }

}
