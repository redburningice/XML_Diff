import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class XmlDiff {
    public static void main(String[] args) throws IOException {
        final int ARGS_NMBR = 2;
        final String OUTPUT_FOLDER = System.getProperty("java.io.tmpdir") + "XmlDiffUtil";

        if (args.length != ARGS_NMBR) {
            usage();
            throw new IOException("Please specify exactly " + ARGS_NMBR + " arguments");
        }
        String filePath1 = args[0];
        XmlFile file1 = new XmlFile(filePath1);
        Console.clear();
        DomParser.parseXml(file1);

    }

    public static void usage() {
        System.out.println("java -jar XmlDiff <Path to Source File> <Path to Target File>");
    }
}
