import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test class for testing file operations such as writing, reading, and appending to files.
 */
public class FileOperationsTest {

    /**
     * Path to the test file used for testing file operations.
     */
    private static final String TEST_FILE = "test.txt";

    /**
     * Deletes the test file before each test to ensure a clean slate.
     *
     * @throws IOException if an I/O error occurs while deleting the file.
     */
    @BeforeEach
    public void setUp() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_FILE));
    }

    /**
     * Deletes the test file after each test to clean up the environment.
     *
     * @throws IOException if an I/O error occurs while deleting the file.
     */
    @AfterEach
    public void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_FILE));
    }

    /**
     * Tests the writeFile method to ensure it correctly writes content to a file.
     *
     * @throws IOException if an I/O error occurs during the test.
     */
    @Test
    public void testWriteFile() throws IOException {
        String content = "Hello, World!";
        FileOperations.writeFile(TEST_FILE, content);

        String result = new String(Files.readAllBytes(Paths.get(TEST_FILE)));
        assertEquals(content, result);
    }

    /**
     * Tests the readFile method to ensure it correctly reads content from a file.
     *
     * @throws IOException if an I/O error occurs during the test.
     */
    @Test
    public void testReadFile() throws IOException {
        String content = "Read this content!";
        Files.write(Paths.get(TEST_FILE), content.getBytes());

        String result = FileOperations.readFile(TEST_FILE);
        assertEquals(content, result);
    }

    /**
     * Tests the appendToFile method to ensure it correctly appends content to an existing file.
     *
     * @throws IOException if an I/O error occurs during the test.
     */
    @Test
    public void testAppendToFile() throws IOException {
        String initialContent = "Initial content.";
        String appendedContent = "Appended content.";

        FileOperations.writeFile(TEST_FILE, initialContent);
        FileOperations.appendToFile(TEST_FILE, appendedContent);

        String result = FileOperations.readFile(TEST_FILE);
        assertTrue(result.contains(initialContent));
        assertTrue(result.contains(appendedContent));
    }
}
