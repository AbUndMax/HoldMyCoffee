package HoldMyCoffee.LoadingBar;

/**
 * LongBar is a type of loading bar that provides a textual representation of progress in the console.
 * It extends the LoadingBar class and prints a longer bar, up to 100 characters in length,
 * indicating the current progress with a visual bar and percentage of completion.
 */
public class LongBar extends LoadingBar {

    /**
     * Initializes a new LongBar instance with the specified total iterations.
     *
     * @param totalIterations the total number of iterations for the loading process
     */
    public LongBar(int totalIterations) {
        super(totalIterations);
    }

    /**
     * Creates a new LongBar object with the specified total iterations and description.
     *
     * @param totalIterations the total number of iterations for the loading process
     * @param desc            a textual description to display with the loading bar
     */
    public LongBar(int totalIterations, String desc) {
        super(totalIterations, desc);
    }

    /**
     * Constructs and prints the current state of a long loading bar to the console.
     * The loading bar includes a visual progress indicator and the current percentage
     * of completion. This method is called whenever the progress is updated.
     */
    @Override
    protected void printBar() {

        int currentPercent = calculatePercentage();

        StringBuilder bar = new StringBuilder(barStart);
        bar.append(" ");
        bar.append(String.format("%-100s", "#".repeat(progress)));
        bar.append(" | ").append(String.format("%3d", currentPercent)).append("%");
        bar.append(" ]");

        printToStream(bar.toString());
    }
}
