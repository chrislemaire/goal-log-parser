package nl.clemaire.domain.objects;

import nl.clemaire.domain.DOMObject;
import org.w3c.dom.Node;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;

/**
 * Created by Chris Lemaire on 3-6-2017.
 */
public class Date extends DOMObject {

    public static final DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    public Date(Node node) {
        super(node);

        assert "date".equals(node.getNodeName());
    }

    public void parse() {
        try {
            value = format.parse(node.getTextContent());
        } catch (ParseException e) {
            System.out.println("Soemthing went really wrong with " + node.getTextContent());
            throw new InputMismatchException(
                    "The input '" + node.getTextContent() + "' could not be date-matched.");
        }
    }
}
