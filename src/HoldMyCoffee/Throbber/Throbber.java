package HoldMyCoffee.Throbber;

/**
 * Abstract class representing a throbber, which is an animated visual indicator for ongoing background tasks.
 * It provides methods for starting and stopping the animation, and abstract methods for defining the animation frames and their timing.
 */
public abstract class Throbber {
    protected String description;
    protected String end;
    protected volatile boolean running;
    protected Thread throbberThread;

    /**
     * Constructor for the Throbber class.
     * Initializes the throbber instance with default description and end messages.
     * The default description is set to "Loading" and the end message to "Done!".
     */
    public Throbber() {
        this.description = "Loading";
        this.end = "Done!";
    }

    /**
     * Constructs a Throbber instance with specified description and end messages.
     * This constructor allows setting custom messages for when the throbber starts and stops.
     *
     * @param description The description message to display while the throbber animation is active.
     * @param end The end message to display when the throbber animation stops.
     */
    public Throbber(String description, String end) {
        this.description = description;
        this.end = end;
    }

    /**
     * Starts the throbber animation by setting the running flag to true and
     * initiating a new thread that handles the animation.
     */
    public void start() {
        running = true;
        throbberThread = new Thread(this::animate);
        throbberThread.start();
    }

    /**
     * Handles the throbber animation by continuously printing animation frames
     * to the output, based on the timeout interval and animation string sequence.
     * The method continues to run until the 'running' flag is set to false.
     * The method also catches and handles InterruptedException by re-interrupting the thread.
     * Once the animation stops, it clears the current line and prints the end message.
     */
    private void animate() {
        long timeout = getTimeout();
        int i = 0;
        while (running) {
            System.out.print(outputString(i++));
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.print("\r" + " ".repeat(description.length() + 2)); // Clear line
        System.out.println("\r" + end);
    }

    /**
     * Generates the output string for the throbber animation, combining the
     * description with a cyclical animation frame.
     *
     * @param i The current loop index of the animation.
     * @return A formatted string containing the description and the current animation frame.
     */
    protected String outputString(int i) {
        String[] animationStrings = getAnimationStrings();
        return "\r" + description + " " + animationStrings[i % animationStrings.length];
    }

    /**
     * Retrieves the array of strings used for the animation sequence in the throbber.
     *
     * @return An array of strings representing the individual frames of the animation.
     */
    protected abstract String[] getAnimationStrings();

    /**
     * Retrieves the timeout interval for the throbber animation.
     *
     * @return The timeout interval in milliseconds.
     */
    protected abstract long getTimeout();

    /**
     * Stops the throbber animation.
     *
     * This method sets the 'running' flag to false, indicating that the throbber
     * should stop. It then waits for the throbber thread to complete its execution
     * by calling the 'join' method on the thread. If the current thread is
     * interrupted while waiting, it catches the InterruptedException and re-interrupts
     * the thread to handle the interruption status properly.
     */
    public void stop() {
        running = false;
        try {
            throbberThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}