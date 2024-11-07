package HoldMyCoffee.Throbber;

public abstract class Throbber {
    private String desc;
    private String end;
    private volatile boolean running;
    private Thread throbberThread;

    public Throbber() {
        this.desc = "Loading";
        this.end = "Done!";
    }

    public Throbber(String desc, String end) {
        this.desc = desc;
        this.end = end;
    }

    public void start() {
        running = true;
        throbberThread = new Thread(this::animate);
        throbberThread.start();
    }

    private void animate() {
        String[] animationStrings = getAnimationStrings();
        long timeout = getTimeout();
        int i = 0;
        while (running) {
            System.out.print("\r" + desc + " " + animationStrings[i++ % animationStrings.length]);
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.print("\r" + " ".repeat(desc.length() + 2)); // Clear line
        System.out.println("\r" + end);
    }

    protected abstract String[] getAnimationStrings();

    protected abstract long getTimeout();

    public void stop() {
        running = false;
        try {
            throbberThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}