package HoldMyCoffee.LoadingBar;

/**
 * The CounterBar class extends the LoadingBar class to provide a combined visual and textual
 * representation of progress in the console. It utilizes the SmallBar and Counter classes for
 * a detailed progress bar display.
 */
public class CounterBar extends LoadingBar {

    /**
     * Constructs a CounterBar instance with the specified total iterations.
     *
     * @param totalIterations the total number of iterations for the loading process
     */
    public CounterBar(int totalIterations) {
        super(totalIterations);
    }

    /**
     * Creates a new CounterBar object with the specified total iterations and description.
     *
     * @param totalIterations the total number of iterations for the loading process
     * @param desc            a textual description to display with the loading bar
     */
    public CounterBar(int totalIterations, String desc) {
        super(totalIterations, desc);
    }

    /**
     * Overrides the abstract `printBar` method from the `LoadingBar` class.
     *
     * Constructs and prints the current state of the loading bar to the console.
     * The loading bar is formatted using a combination of the `SmallBar` and `Counter` classes,
     * displaying both a visual representation of progress and a textual count of progress.
     *
     * The generated bar string includes segments from `SmallBar.generateBarString` and
     * `Counter.generateBarString`, which are then concatenated and printed via `printToStream`.
     */
    @Override
    protected void printBar() {

        String bar = SmallBar.generateBarString(barStart, calculatePercentage(), "") + "% |" +
                Counter.generateBarString(" ", total, progress, " ]");

        printToStream(bar);
    }
}
