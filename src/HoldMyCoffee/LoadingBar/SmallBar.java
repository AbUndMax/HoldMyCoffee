package HoldMyCoffee.LoadingBar;

import java.io.PrintStream;

/**
 * The SmallBar class extends the LoadingBar class and provides a visual representation
 * of a loading progress bar in the console. It updates the progress bar in place,
 * displaying the current percentage of completion.
 */
public class SmallBar extends LoadingBar {

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

        int currentPercent = calculatePercentage();

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

        bar.append("] % finished");

        printToStream(bar.toString());
    }
}
