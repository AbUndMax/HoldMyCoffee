package HoldMyCoffee.LoadingBar;

/**
 * The SmallBar class extends the LoadingBar class and provides a visual representation
 * of a loading progress bar in the console. It updates the progress bar in place,
 * displaying the current percentage of completion.
 */
public class SmallBar extends LoadingBar {

    /**
     * Constructs a SmallBar instance with the specified total iterations.
     *
     * @param totalIterations the total number of iterations for the loading process
     */
    public SmallBar(int totalIterations) {
        super(totalIterations);
    }

    /**
     * Creates a new SmallBar object with the specified total iterations and description.
     *
     * @param totalIterations the total number of iterations for the loading process
     * @param description a textual description to display with the loading bar
     */
    public SmallBar(int totalIterations, String description) {
        super(totalIterations, description);
    }

    /**
     * This method overrides the abstract `printBar` method from the `LoadingBar` class.
     *
     * It generates and prints a progress bar on the console based on the current loading percentage.
     * The progress bar is updated in place and has a fixed format displaying the current percentage.
     *
     * The progress bar starts with the description and initial bar structure from `barStart`.
     * The `currentPercent` is calculated using the `calculatePercentage()` method, which determines
     * the current loading progress as a percentage of the total loading process.
     *
     * If the loading is complete (`isFinalLoad()` returns true), it appends a line break after the
     * bar; otherwise, it updates the bar in place.
     */
    @Override
    protected void printBar() {
        String bar = generateBarString(barStart, calculatePercentage(), " ] % finished");
        printToStream(bar);
    }

    /**
     * Generates a formatted string representation of a progress bar with specified start and end segments,
     * based on the current percentage of completion.
     *
     * @param barStart the initial part of the bar string, generally a description or initial delimiter
     * @param currentPercent the current percentage of completion, determining the progress displayed in the bar
     * @param barEnd the concluding part of the bar string, often additional information or closing delimiter
     * @return a formatted string representing the progress bar with current completion percentage
     */
    protected static String generateBarString(String barStart, int currentPercent, String barEnd) {

        StringBuilder bar = new StringBuilder(barStart);
        int repetitions = Math.min(currentPercent / 10, 9);

        for (int i = 0; i < repetitions; i++) {
            bar.append(" ##");
        }

        bar.append(String.format(" %02d", currentPercent));

        for (int i = 0; i < 10 - repetitions - 1; i++) {
            bar.append(" --");
        }

        if (currentPercent < 100) {
            bar.append(" ");
        }

        bar.append(barEnd);

        return bar.toString();
    }
}
