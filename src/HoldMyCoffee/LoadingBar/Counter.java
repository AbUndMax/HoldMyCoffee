package HoldMyCoffee.LoadingBar;

/**
 * The Counter class extends the LoadingBar class and provides
 * a concrete implementation for displaying a loading bar that
 * shows the progress as a count of total iterations.
 */
public class Counter extends LoadingBar {

    /**
     * Constructs a Counter instance with the specified total iterations.
     *
     * @param totalIterations the total number of iterations for the counter
     */
    public Counter(int totalIterations) {
        super(totalIterations);
    }

    /**
     * Creates a new Counter object with the specified total iterations and description.
     *
     * @param totalIterations the total number of iterations for the counter
     * @param desc a textual description to display with the counter
     */
    public Counter(int totalIterations, String desc) {
        super(totalIterations, desc);
    }

    /**
     * Prints the current state of the loading bar to the console.
     * This method constructs a string representation of the bar,
     * including the progress and total iterations, and then uses
     * the printToStream method to output it.
     */
    @Override
    protected void printBar() {
        printToStream(generateBarString(barStart + " ", total, progress, " ]"));
    }

    /**
     * Generates a formatted string representing the current state of a progress bar,
     * including the start marker, the current progress, the total iterations, and an end marker.
     *
     * @param barStart the initial part of the bar (typically an opening bracket or description)
     * @param totalIterations the total number of iterations the bar represents
     * @param progress the current progress in the iterations
     * @param barEnd the concluding part of the bar (typically a closing bracket or other symbol)
     * @return a string representation of the progress bar with the current progress and total iterations
     */
    protected static String generateBarString(String barStart, int totalIterations, int progress, String barEnd) {
        StringBuilder bar = new StringBuilder(barStart);
        String totalString = Integer.toString(totalIterations);
        bar.append(String.format("%" + totalString.length() + "s", progress));
        bar.append("/").append(totalString);
        bar.append(barEnd);
        return bar.toString();
    }
}
