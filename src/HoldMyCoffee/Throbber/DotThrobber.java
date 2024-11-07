package HoldMyCoffee.Throbber;

/**
 * DotThrobber is a specific type of Throbber that shows a dot-based animation.
 * It inherits the base behavior from the Throbber class and specifies the
 * animation strings and timeout for dot-throbbing effect.
 */
public class DotThrobber extends Throbber {

    /**
     * Constructs a DotThrobber instance with default description and end messages.
     * This class provides a specific type of Throbber that shows a dot-based animation.
     * It inherits the base behavior from the Throbber class and specifies the
     * animation strings and timeout for dot-throbbing effect.
     */
    public DotThrobber() {
        super();
    }

    /**
     * Constructs a DotThrobber instance with specified description and end messages.
     * This class provides a specific type of Throbber that shows a dot-based animation.
     * It inherits the base behavior from the Throbber class and specifies the
     * animation strings and timeout for dot-throbbing effect.
     *
     * @param description the description message to display while the throbber animation is running
     * @param end the end message to display when the throbber animation stops
     */
    public DotThrobber(String description, String end) {
        super(description, end);
    }

    /**
     * Returns the timeout interval for the throbber animation.
     *
     * @return the 700 millisecond long timeout interval
     */
    @Override
    protected long getTimeout() {
        return 700;
    }

    /**
     * Provides an array of strings representing the dot-based animation frames.
     *
     * @return an array of strings where each string represents a frame in the dot-throbber animation
     */
    @Override
    protected String[] getAnimationStrings() {
        return new String[]{".  ", ".. ", "...", "   "};
    }
}
