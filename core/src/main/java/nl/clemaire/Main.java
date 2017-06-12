package nl.clemaire;

import nl.clemaire.matrix.LogViewer;

/**
 * Created by Chris Lemaire on 4-6-2017.
 */
public class Main {

    private static String PERFORMANCE_LOG_MODE = "PF_LOG_MODE";

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Not enough command line arguments: " + args.length
                    + "\n\tNeed 2 to run: log-parse-mode and logfile-path.");
        } else {
            if (PERFORMANCE_LOG_MODE.equals(args[0])) {
                try {
                    LogViewer.showLogFileMatrix(args[1]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
