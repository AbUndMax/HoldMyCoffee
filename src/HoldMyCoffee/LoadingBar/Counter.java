package HoldMyCoffee.LoadingBar;

/**
 * The Counter class extends the LoadingBar class and provides
 * a concrete implementation for displaying a loading bar that
 * shows the progress as a count of total iterations.
 */
public class Counter extends LoadingBar {

    /**
     * Constructs a Counter instance with the specified total iterations and description.
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

        StringBuilder bar = new StringBuilder(barStart);
        String totalString = Integer.toString(total);
        bar.append(String.format("%" + totalString.length() + "s", progress));
        bar.append("/").append(totalString).append("]");

        printToStream(bar.toString());
    }
}
