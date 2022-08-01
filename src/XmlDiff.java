import java.util.Scanner;

public class XmlDiff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This tool compares properties subsequently from two site.xconf files");
        System.out.println("Enter path to the 1st XML-file for comparison (source file)");
        String path1 = scanner.nextLine();
        System.out.println("Enter path to the 2nd XML-file for comparison (target file)");
        String path2 = scanner.nextLine();
    }
}
