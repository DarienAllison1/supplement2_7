import java.io.*;
import java.util.Scanner;

/**
 * A utility class for performing file operations such as creating, writing, reading, and appending to files.
 */
public class FileOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("File Operations Program");
        System.out.println("1. Write to a File");
        System.out.println("2. Read from a File");
        System.out.println("3. Append to a File");
        System.out.println("4. Exit");
        
        while (true) {
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter filename: ");
                        String writeFileName = scanner.nextLine();
                        System.out.print("Enter content to write: ");
                        String writeContent = scanner.nextLine();
                        writeFile(writeFileName, writeContent);
                        System.out.println("Content written to " + writeFileName);
                        break;

                    case 2:
                        System.out.print("Enter filename: ");
                        String readFileName = scanner.nextLine();
                        String content = readFile(readFileName);
                        System.out.println("File content:");
                        System.out.println(content);
                        break;

                    case 3:
                        System.out.print("Enter filename: ");
                        String appendFileName = scanner.nextLine();
                        System.out.print("Enter content to append: ");
                        String appendContent = scanner.nextLine();
                        appendToFile(appendFileName, appendContent);
                        System.out.println("Content appended to " + appendFileName);
                        break;

                    case 4:
                        System.out.println("Exiting program.");
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    public static void writeFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }

    public static String readFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        }
        return content.toString().trim();
    }

    public static void appendToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(content);
            writer.newLine();
        }
    }
}
