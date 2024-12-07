import java.io.*;
import java.util.Scanner;

/**
 * A utility class for performing file operations such as creating, writing, reading, and appending to files.
 */
public class FileOperations {

    /**
     * Entry point for the File Operations program.
     * Provides a menu for users to interact with file operations.
     *
     * @param args command-line arguments (not used).
     */
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

    /**
     * Writes content to a specified file. Overwrites the file if it already exists.
     *
     * @param filename the name of the file to write to.
     * @param content the content to write to the file.
     * @throws IOException if an I/O error occurs during the operation.
     */
    public static void writeFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }

    /**
     * Reads the content of a specified file.
     *
     * @param filename the name of the file to read from.
     * @return the content of the file as a string.
     * @throws IOException if an I/O error occurs during the operation.
     */
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

    /**
     * Appends content to a specified file. Creates the file if it does not exist.
     *
     * @param filename the name of the file to append to.
     * @param content the content to append to the file.
     * @throws IOException if an I/O error occurs during the operation.
     */
    public static void appendToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(content);
            writer.newLine();
        }
    }
}

