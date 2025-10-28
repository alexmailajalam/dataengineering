/**
 * Simple Hello World program.
 *
 * Usage:
 *   java helloworld <name>
 *
 * Prints a greeting and the provided name(s).
 *
 * Note: The class name is `helloworld` to match the filename
 * `helloworld.java`. Java naming conventions recommend `HelloWorld`.
 * If you'd like, I can rename the class/file to follow that convention.
 */
public class helloworld {
    /**
     * Program entry point.
     *
     * @param args command-line arguments; all arguments are joined with spaces
     *             and printed as the name. If no arguments are provided, the
     *             program prints usage information.
     */
    public static void main(String[] args) {
        // Show usage if no name was supplied.
        if (args.length < 1) {
            System.out.println("Usage: java helloworld <name>");
            return;
        }

        // Join multiple arguments into a single display name (e.g., "First Last").
        String name = String.join(" ", args);

        // Print a short greeting followed by the provided name on the next line.
        System.out.println("Hello, World!");
        System.out.println(name);
    }
}