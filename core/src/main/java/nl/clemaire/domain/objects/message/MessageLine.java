package nl.clemaire.domain.objects.message;

import java.util.regex.Matcher;

/**
 * Created by Chris Lemaire on 3-6-2017.
 */
public class MessageLine {

    private String line;

    private MessageType type;
    private String[] captures;

    public MessageLine(String line) {
        this.line = line;

        classify();
        capture();
    }

    public void classify() {
        type = MessageType.classify(line);
    }

    public void capture() {
        Matcher matcher = type.getMatcher(line);
        matcher.find();

        captures = new String[matcher.groupCount()];
        for (int i = 1; i <= matcher.groupCount(); i++) {
            captures[i-1] = matcher.group(i);
        }
    }

    public MessageType getType() {
        return type;
    }

    public String[] getCaptures() {
        return captures;
    }
}
