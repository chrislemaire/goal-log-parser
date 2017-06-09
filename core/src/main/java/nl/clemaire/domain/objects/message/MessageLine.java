package nl.clemaire.domain.objects.message;

import java.util.regex.Matcher;

/**
 * Class representing a single line in the {@link Message}
 * type text content. This might be a cycle separator,
 * performance log, belief base update or anything else
 * logged.
 *
 * @author Chris Lemaire
 */
public class MessageLine {

    /**
     * The original line of text this {@link MessageLine} represents.
     */
    private String line;


    /**
     * The {@link MessageType} of this {@link MessageLine}.
     */
    private MessageType type;

    /**
     * The parts of the {@link #line} that are of interest as indicated
     * in the {@link MessageType} enumeration.
     */
    private String[] captures;

    /**
     * Creates a new {@link MessageLine} from the original text {@link #line}.
     *
     * @param line original text.
     */
    public MessageLine(String line) {
        this.line = line;

        classify();
        capture();
    }

    /**
     * Classifies the {@link #line} field by {@link MessageType} and stores
     * the resulting type in {@link #type}.
     */
    private void classify() {
        type = MessageType.classify(line);
    }

    /**
     * Capture all important information in the text line and store the results
     * in {@link #captures}. Defining the captures is done in {@link MessageType}.
     */
    private void capture() {
        assert type != null;

        Matcher matcher = type.getMatcher(line);
        if (matcher.find()) {
            captures = new String[matcher.groupCount()];
            for (int i = 1; i <= matcher.groupCount(); i++) {
                captures[i - 1] = matcher.group(i);
            }
        }
    }

    /**
     * Gets the {@link #type} field
     *
     * @return the {@link #type} field.
     */
    public MessageType getType() {
        return type;
    }

    /**
     * Gets the {@link #captures} field.
     *
     * @return the {@link #captures} field.
     */
    public String[] getCaptures() {
        return captures;
    }
}
