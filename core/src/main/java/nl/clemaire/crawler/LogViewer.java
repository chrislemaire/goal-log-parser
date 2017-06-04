package nl.clemaire.crawler;

import org.apache.commons.io.FileUtils;
import org.ujmp.core.Matrix;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Chris Lemaire on 4-6-2017.
 */
public class LogViewer {

    private static URL loggerDtd = LogViewer.class.getResource("/logger/logger.dtd");

    private static FileFilter dtdFilter = new FileFilter() {
        @Override
        public boolean accept(File pathname) {
            return "logger.dtd".equals(pathname.getName());
        }
    };

    public static void showLogFileMatrix(String logFile) throws IOException {
        File log = new File(logFile);
        File dir = new File(log.getParent());
        File[] files = dir.listFiles(dtdFilter);

        if (files == null || files.length == 0) {
            File targetDtd = new File(dir.getPath() + "\\logger.dtd");
            System.out.println("Copying over dtd...\n"
                    + loggerDtd
                    + "\n" + targetDtd);
            FileUtils.copyURLToFile(loggerDtd, targetDtd);
        }

        Matrix matrix = MatrixFactory.fromLogFile(logFile);
        matrix.showGUI();
    }

}
