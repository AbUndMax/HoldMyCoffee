package HoldMyCoffee.Throbber;

public class WheelThrobber extends Throbber {

    public WheelThrobber() {
        super();
    }

    public WheelThrobber(String desc, String end) {
        super(desc, end);
    }

    @Override
    protected long getTimeout() {
        return 225;
    }

    @Override
    protected String[] getAnimationStrings() {
        return new String[]{"|", "/", "-", "\\"};
    }
}
