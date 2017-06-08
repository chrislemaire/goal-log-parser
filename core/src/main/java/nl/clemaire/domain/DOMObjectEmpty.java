package nl.clemaire.domain;

import org.w3c.dom.Node;

/**
 * Created by Chris Lemaire on 3-6-2017.
 */
@Deprecated
public class DOMObjectEmpty extends DOMObject {

    public DOMObjectEmpty(Node node) {
        super(node);
    }

    public void parse() {
        value = "";
    }

}
