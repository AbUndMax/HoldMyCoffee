package HoldMyCoffee.Throbber;

/**
 * TimeThrobber is a subclass of Throbber that displays a loading animation
 * with seconds progressing and formatted as mm:ss.
 *
 * It maintains an array of formatted second strings from 00 to 59.
 */
public class TimeThrobber extends Throbber {

    /**
     * An array of strings representing each second in a minute, formatted
     * as two-digit strings from "00" to "59".
     * Used in the TimeThrobber class to display the progress of seconds
     * in the format mm:ss during a loading animation.
     */
    private final String[] seconds = new String[60];{
            for (int i = 0; i < 60; i++ ) {
                seconds[i] = String.format("%02d", i);
            }
    }

    /**
     * Constructs a new TimeThrobber object with default description and end messages.
     * The loading animation is represented as seconds progressing and formatted as mm:ss.
     */
    public TimeThrobber() {
        super();
    }

    /**
     * Constructs a new TimeThrobber object with the specified description and end messages.
     *
     * @param description the description message to display during the loading animation
     * @param end the end message to display when the loading animation finishes
     */
    public TimeThrobber(String description, String end) {
        super(description, end);
    }

    /**
     * Generates a formatted string to display the loading animation progress in mm:ss format.
     *
     * @param i the current loop number in the animation function
     * @return the formatted string representing the current progress of time in mm:ss format
     */
    protected String outputString(int i) {
        String second = seconds[i % seconds.length];
        String minutes = String.format("%02d", i / 60);
        return "\r" + description + " " + minutes + ":" + second;
    }

    /**
     * Retrieves an array of strings representing each second in a minute, formatted
     * as two-digit strings from "00" to "59".
     *
     * @return an array of strings containing formatted second values for the animation.
     */
    @Override
    protected String[] getAnimationStrings() {
        return seconds;
    }

    /**
     * Retrieves the timeout interval used for determining the delay between frames
     * in the loading animation.
     *
     * @return the timeout interval in milliseconds
     */
    @Override
    protected long getTimeout() {
        return 1000;
    }
}
