# Throbber
Loading animation library for Java

## Throbber

### Example Code

```Java
import HoldMyCoffee.Throbber.Throbber;

public static void main(String[] args) {
    Throbber throbber = new Throbber();
    throbber.startWheel();

    // Simulate a long-running task
    try {
        Thread.sleep(5000); // 5 seconds
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    throbber.stop();
```

## LoadingBar:

### Example Code

```Java
import HoldMyCoffee.LoadingBar.LoadingBar;

public static void main(String[] args) {
    LoadingBar loadingBar = new LoadingBar(100, "Loading");

    for (int i = 0; i <= 100; i++) {
        try {
            Thread.sleep(225); // Simulate work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        loadingBar.load(i);
    }
}
```
