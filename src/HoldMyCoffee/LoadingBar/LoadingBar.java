package HoldMyCoffee.LoadingBar;

import java.io.PrintStream;

/**
 * The LoadingBar class serves as an abstract base for creating different types of
 * loading bars that visually represent progress in the console. Subclasses must
 * implement the `printBar()` method to specify how the loading bar is displayed.
 */
public abstract class LoadingBar {
    protected final int total;
    protected final String barStart;
    protected boolean finished;
    protected int progress = 0;

    /**
     * Constructs a LoadingBar instance with the specified total iterations.
     *
     * @param totalIterations the total number of iterations for the loading process
     */
    public LoadingBar(int totalIterations) {
        this(totalIterations, "Loading");
    }

    /**
     * Constructs a LoadingBar instance with the specified total iterations and description.
     *
     * @param totalIterations the total number of iterations for the loading process
     * @param desc a textual description to display with the loading bar
     */
    public LoadingBar(int totalIterations, String desc) {
        this.total = totalIterations;
        this.barStart = desc + ": [";
        this.finished = false;
        load(0);
    }

    /**
     * Increments the current progress by one unit and triggers the re-drawing of the loading bar.
     * If the loading bar is marked as finished, the bar will not be redrawn.
     */
    public void loadByOne() {
        progress++;
        if (!finished) printBar();
    }

    /**
     * Updates the progress value and redraws the loading bar if it is not marked as finished.
     *
     * @param progress the current progress value to be set. This value determines
     *                 how much of the loading process has been completed.
     */
    public void load(int progress) {
        this.progress = progress;
        if (!finished) printBar();
    }

    /**
     * Prints the loading bar to the console. This method is to be implemented by
     * subclasses to define the specific way in which the loading bar is displayed.
     * The method will be automatically called whenever the loading progress is
     * updated, provided the loading process is not yet finished.
     */
    protected abstract void printBar();

    /**
     * Calculates the current loading progress as a percentage of the total loading process.
     *
     * @return the current loading progress as an integer percentage (0 to 100).
     */
    protected int calculatePercentage() {
        return (int) ((double) progress / total * 100);
    }

    /**
     * Checks whether the loading process has reached its final stage.
     *
     * @return true if the current progress equals the total iterations; false otherwise.
     */
    protected boolean isFinalLoad() {
        return progress >= total;
    }

    /**
     * Prints the loading bar to the console using a specified string representation.
     * The method updates the console output to reflect the current loading state.
     * It marks the loading as finished if the loading process is complete.
     *
     * @param bar the string representation of the loading bar to be printed to the console
     */
    protected void printToStream(String bar) {
        PrintStream output = System.out;
        if (isFinalLoad()) {
            finished = true;
            output.print("\r" + bar + "\n\n");
        } else {
            output.print("\r" + bar);
        }
        output.flush();
    }

    /**
     * Resets the loading bar progress and marks it as not finished.
     * This method sets the current progress back to zero, which makes
     * the same LoadingBar instance reusable. (description & total stays the same!)
     */
    public void resetBar() {
        progress = 0;
        finished = false;
    }
}