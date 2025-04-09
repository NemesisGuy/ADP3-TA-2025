package za.ac.cput.util;


import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.lang.StringBuilder; // Explicit import for clarity

/**
 * A utility to combine multiple Java source files from a directory tree
 * into a single text file, with comments indicating the original file path.
 *
 * !! NOTE: This version uses hardcoded paths. Edit the variables below before running. !!
 */
public class CodeCombiner {
///"C:\Users\Reign\IdeaProjects\ADP3-TA-2025\src" "C:\Users\Reign\IdeaProjects\ADP3-TA-2025\src\combined_code.java"
    public static void main(String[] args) {

        // --- !!! EDIT THESE TWO LINES BEFORE RUNNING !!! ---
        // Set the path to the root directory containing your Java source code (.java files).
        // Examples:
        // String sourceDirectoryPathString = "C:/Users/YourUser/Projects/MyCoolApp/src/main/java";
        // String sourceDirectoryPathString = "/home/youruser/my_project/src";
        // String sourceDirectoryPathString = "./src"; // If src is in the same directory you run this from
        String sourceDirectoryPathString = "C:\\Users\\Reign\\IdeaProjects\\ADP3-TA-2025\\src";

        // Set the desired path and filename for the combined output file.
        // Examples:
        // String outputFilePathString = "C:/Users/YourUser/Desktop/combined_project_code.txt";
        // String outputFilePathString = "/home/youruser/output/combined.txt";
        // String outputFilePathString = "./combined_code.txt"; // Output in the current directory
        String outputFilePathString = "C:\\Users\\Reign\\IdeaProjects\\ADP3-TA-2025\\src\\combined_code.java";
        // --- !!! ---

        // --- Do not edit below this line unless you know what you're doing ---

        if (sourceDirectoryPathString.startsWith("CHANGE_THIS") || outputFilePathString.startsWith("CHANGE_THIS")) {
            System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.err.println("ERROR: Please edit the 'sourceDirectoryPathString' and 'outputFilePathString'");
            System.err.println("       variables inside the CodeCombiner.java file before running!");
            System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.exit(1);
        }


        Path sourceDirectory = Paths.get(sourceDirectoryPathString);
        Path outputFile = Paths.get(outputFilePathString);

        System.out.println("Source Directory: " + sourceDirectory.toAbsolutePath());
        System.out.println("Output File:      " + outputFile.toAbsolutePath());


        if (!Files.isDirectory(sourceDirectory)) {
            System.err.println("Error: Source path is not a valid directory: " + sourceDirectory);
            System.err.println("Please check the 'sourceDirectoryPathString' variable in the code.");
            System.exit(1);
        }

        try {
            // Ensure the output directory exists
            Path outputDir = outputFile.getParent();
            if (outputDir != null && !Files.exists(outputDir)) {
                System.out.println("Creating output directory: " + outputDir);
                Files.createDirectories(outputDir);
            }

            combineJavaFiles(sourceDirectory, outputFile);
            System.out.println("\nSuccessfully combined Java files into: " + outputFile.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("\nAn error occurred during processing:");
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Finds all .java files in the source directory and its subdirectories,
     * reads their content, and writes it into the output file with delimiters.
     *
     * @param sourceDir The root directory containing the .java source files.
     * @param outputFile The file to write the combined content to.
     * @throws IOException If an I/O error occurs during file walking, reading, or writing.
     */
    public static void combineJavaFiles(Path sourceDir, Path outputFile) throws IOException {
        StringBuilder combinedContent = new StringBuilder();

        // Add a header to the combined file
        combinedContent.append("// =====================================================================\n");
        combinedContent.append("// COMBINED JAVA CODE FROM: ").append(sourceDir.toAbsolutePath()).append("\n");
        combinedContent.append("// Generated on: ").append(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)).append("\n");
        combinedContent.append("// =====================================================================\n\n");

        // Use try-with-resources for Files.walk to ensure the stream is closed
        try (Stream<Path> stream = Files.walk(sourceDir)) {
            stream
                    .filter(Files::isRegularFile) // Only consider regular files
                    .filter(path -> path.toString().toLowerCase().endsWith(".java")) // Only .java files
                    .sorted() // Process files in a predictable order (alphabetical)
                    .forEach(filePath -> {
                        try {
                            // Get path relative to the source directory for clarity in comments
                            Path relativePath = sourceDir.relativize(filePath);
                            // Normalize path separators for consistency in comments
                            String normalizedRelativePath = relativePath.toString().replace("\\", "/");
                            String separatorLine = "// ==================== FILE: " + normalizedRelativePath + " ====================";

                            System.out.println("Processing: " + relativePath);

                            combinedContent.append(separatorLine).append("\n\n");

                            // Read file content (uses UTF-8 by default)
                            String fileContent = Files.readString(filePath);
                            combinedContent.append(fileContent);

                            // Add a small footer/separator after the file content
                            combinedContent.append("\n\n")
                                    .append("// ==================== END OF FILE: ").append(normalizedRelativePath).append(" ====================\n\n\n");

                        } catch (IOException e) {
                            System.err.println("Warning: Could not read file " + filePath + ". Skipping. Error: " + e.getMessage());
                            // Append an error message to the output file for this specific file
                            combinedContent.append("// !!! ERROR READING FILE: ").append(filePath).append(" !!!\n");
                            combinedContent.append("// Error message: ").append(e.getMessage()).append("\n\n\n");
                        }
                    });
        } // Stream is automatically closed here

        // Write the combined content to the output file (overwrite if exists)
        Files.writeString(outputFile, combinedContent.toString(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }
}