package nl.clemaire.domain.objects.message;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Describes a set of types a {@link MessageLine}. This includes but is not
 * limited to for example a cycle separator, message base update, or performance
 * log.
 *
 * @author Chris Lemaire
 */
public enum MessageType {

    MESSAGE("['](.*)['] from ['](.*)['] has been (inserted|deleted) (?:into|from) the mailbox."),
    BELIEF("['](.*)['] from ['](.*)['] has been (inserted|deleted) (?:into|from) the belief base."),
    PERFORMANCE_DATA("env\\. actions: ([0-9]+), state queries: ([0-9]+), total\\[beliefs: ([0-9]+), " +
            "goals: ([0-9]+), messages: ([0-9]+), percepts: ([0-9]+)\\]"),
    CYCLE_SEPARATOR("\\+\\+\\+\\+\\+\\+\\+ Cycle ([0-9]+) \\+\\+\\+\\+\\+\\+\\+"),
    STARTED_AGENT("started agent.");

    /**
     * The regular expression that should match {@link MessageLine} content that
     * is of the type it matches.
     */
    private String regex;

    /**
     * Pre-built pattern to be compiled to a matcher upon getting the line String.
     */
    private Pattern pattern;

    /**
     * Creates a new {@link MessageType} from the {@link #regex} field.
     *
     * @param regex that defines type signature.
     */
    MessageType(String regex) {
        this.regex = regex;

        this.pattern = Pattern.compile(regex);
    }

    /**
     * Gets the matcher that is compiled from {@link #pattern} and the given String.
     *
     * @param str String to compile the matcher for.
     * @return matcher compiled for matching the String with {@link #regex}.
     */
    public Matcher getMatcher(String str) {
        return pattern.matcher(str);
    }

    /**
     * Classifies a given String as its corresponding {@link MessageType}.
     *
     * @param str String to check the type for.
     * @return type the String classifies as.
     */
    public static MessageType classify(String str) {
        for (MessageType type : MessageType.values()) {
            if (type.getMatcher(str).find()) {
                return type;
            }
        }
        throw new InputMismatchException(
                "Unclassified message string: '" + str + "'");
    }
}
