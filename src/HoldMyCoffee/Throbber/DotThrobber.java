package HoldMyCoffee.Throbber;

public class DotThrobber extends Throbber {

    public DotThrobber() {
        super();
    }

    public DotThrobber(String desc, String end) {
        super(desc, end);
    }

    @Override
    protected long getTimeout() {
        return 700;
    }

    @Override
    protected String[] getAnimationStrings() {
        return new String[]{".  ", ".. ", "...", "   "};
    }
}
