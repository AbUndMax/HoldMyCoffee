package HoldMyCoffee.Throbber;

/**
 * WheelThrobber is an implementation of the Throbber class that creates a simple spinning wheel animation.
 * This visual effect is useful for indicating that a task is in progress.
 *
 * It provides two constructors, one default and one that allows for custom descriptions and end states.
 * The animation consists of four characters: "|", "/", "-", and "\\".
 * The default timeout between changing animation frames is set to 225 milliseconds.
 */
public class WheelThrobber extends Throbber {

    /**
     * Default constructor for WheelThrobber.
     *
     * Initializes a WheelThrobber instance with default settings.
     * WheelThrobber creates a simple spinning wheel animation consisting of characters "|", "/", "-", and "\\".
     * This visual effect is used to indicate that a task is in progress.
     * By default, it sets the description to "Loading" and the end message to "Done!".
     */
    public WheelThrobber() {
        super();
    }

    /**
     * Creates a WheelThrobber instance with a custom description and end state message.
     *
     * @param description the description message to show while the throbber is running
     * @param end         the message to display when the throbber stops
     */
    public WheelThrobber(String description, String end) {
        super(description, end);
    }

    /**
     * Returns the timeout duration between changing animation frames for the WheelThrobber.
     *
     * @return The 250 millisecond long timeout intervall.
     */
    @Override
    protected long getTimeout() {
        return 225;
    }

    /**
     * Provides the animation frames for the WheelThrobber class.
     *
     * @return an array of strings representing the spinning wheel animation frames.
     */
    @Override
    protected String[] getAnimationStrings() {
        return new String[]{"|", "/", "-", "\\"};
    }
}
