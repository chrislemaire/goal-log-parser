package nl.clemaire.crawler;

import nl.clemaire.domain.objects.message.Message;
import nl.clemaire.domain.objects.message.MessageLine;
import nl.clemaire.domain.objects.message.MessageType;

/**
 * Created by Chris Lemaire on 3-6-2017.
 */
public enum PerformanceMetric {

    ENV_ACTIONS(0),
    STATE_QUERIES(1),
    BELIEFS(2),
    GOALS(3),
    MESSAGES(4),
    PERCEPTS(5);

    private int index;

    PerformanceMetric(int index) {
        this.index = index;
    }

    public Integer parse(Message message) {
        MessageLine[] lines = (MessageLine[]) message.getValue();

        for (int i = 0; i < lines.length; i++) {
            if (lines[i].getType() == MessageType.PERFORMANCE_DATA) {
                return Integer.parseInt(lines[i].getCaptures()[index]);
            }
        }
        return -1;
    }

}
