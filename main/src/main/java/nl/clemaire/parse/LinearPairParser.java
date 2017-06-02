package nl.clemaire.parse;

import jdk.internal.util.xml.impl.Input;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

/**
 * Created by Chris Lemaire on 2-6-2017.
 */
public class LinearPairParser {

    public static final char DEFAULT_SEPERATOR = ',';
    public static final char DEFAULT_COUPLER = ':';

    private char separator;
    private char coupler;

    public LinearPairParser() {
        this(DEFAULT_SEPERATOR, DEFAULT_COUPLER);
    }

    public LinearPairParser(char seperator) {
        this(seperator, DEFAULT_COUPLER);
    }

    public LinearPairParser(char seperator, char coupler) {
        this.separator = seperator;
        this.coupler = coupler;
    }

    public Map<String, String> parse(String str) {
        int isKeyCurrent = 0;

        String[] singlePair = new String[] {"", ""};
        Map<String, String> pairs = new HashMap<String, String>();

        for (char character : str.toCharArray()) {
            if (character == coupler) {
                if (isKeyCurrent == 1) {
                    throw new InputMismatchException(
                            "Second coupler matched in performance data string: '" + str + "'");
                }
                isKeyCurrent++;
            } else if (character == separator) {
                if (isKeyCurrent != 1) {
                    throw new InputMismatchException(
                            "Coupler not matched in performance data string: '" + str + "'");
                }
                isKeyCurrent = 0;
                pairs.put(singlePair[0], singlePair[1]);
                singlePair = new String[] {"", ""};
            }
            singlePair[isKeyCurrent] += character;
        }
        if (isKeyCurrent != 1) {
            throw new InputMismatchException(
                    "No coupler matched in last element of performance data string: '" + str + "'");
        }
        pairs.put(singlePair[0], singlePair[1]);

        return pairs;
    }

}
