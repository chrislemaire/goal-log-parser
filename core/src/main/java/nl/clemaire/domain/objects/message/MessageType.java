package nl.clemaire.domain.objects.message;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Chris Lemaire on 3-6-2017.
 */
public enum MessageType {

    MESSAGE("['](.*)['] from ['](.*)['] has been (inserted|deleted) (?:into|from) the mailbox."),
    BELIEF("['](.*)['] from ['](.*)['] has been (inserted|deleted) (?:into|from) the belief base."),
    PERFORMANCE_DATA("env. actions: ([0-9]+), state queries: ([0-9]+), total[beliefs: ([0-9]+), " +
            "goals: ([0-9]+), messages: ([0-9]+), percepts: ([0-9]+)]"),
    CYCLE_SEPARATOR("+++++++ Cycle ([0-9]+) +++++++");

    private String regex;

    private Pattern pattern;

    MessageType(String regex) {
        this.regex = regex;

        this.pattern = Pattern.compile(regex);
    }

    public Matcher getMatcher(String str) {
        return pattern.matcher(str);
    }

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
