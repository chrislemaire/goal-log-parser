package nl.clemaire.domain.objects;

import nl.clemaire.domain.DOMObject;
import org.w3c.dom.Node;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;

/**
 * {@link DOMObject} for the date property
 * of a log record.
 *
 * @author Chris Lemaire
 */
public class Date extends DOMObject {

    /**
     * The format of the dates properties in log records.
     */
    private static final DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    /**
     * Creates a new {@link Date} object using super constructor.
     *
     * @param node to form {@link Date} object for.
     * @throws Exception when parsing fails.
     */
    public Date(Node node) throws Exception {
        super(node);

        assert "date".equals(node.getNodeName());
    }

    @Override
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
