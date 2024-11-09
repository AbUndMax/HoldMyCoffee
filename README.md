[![GitHub](https://img.shields.io/badge/GitHub-HoldMyCoffee+-b07219?logo=github)](https://github.com/AbUndMax/HoldMyCoffee)
[![Java](https://img.shields.io/badge/Java-11+-b07219)](https://openjdk.org/projects/jdk/11/)
[![License](https://img.shields.io/badge/License-CC_BY--NC_4.0-blue)](https://github.com/AbUndMax/HoldMyCoffee/blob/main/LICENSE.md)
[![Badge](https://img.shields.io/github/v/release/AbUndMax/HoldMyCoffee?color=brightgreen)](https://github.com/AbUndMax/HoldMyCoffee/releases/latest)

# HoldMyCoffee
Loading animation library for CLI tools written in Java

## Included Animation Exmaples:
### Throbbers:

#### WheelThrobber
<div style="text-align: center;">
  <img src="animations/WheelThrobber.gif" alt="WheelThrobber.gif">
</div>

#### DotThrobber
<div style="text-align: center;">
  <img src="animations/DotThrobber.gif" alt="DotThrobber.gif">
</div>

#### TimeThrobber
<div style="text-align: center;">
  <img src="animations/TimeThrobber.gif" alt="TimeThrobber.gif">
</div>

### LoadingBars:
#### SmallBar
<div style="text-align: center;">
  <img src="animations/SmallBar.gif" alt="SmallBar2.gif">
</div>

#### LongBar
<div style="text-align: center;">
  <img src="animations/LongBar.gif" alt="LongBar.gif">
</div>

#### Counter
<div style="text-align: center;">
  <img src="animations/Counter.gif" alt="Counter.gif">
</div>

#### CounterBar
<div style="text-align: center;">
  <img src="animations/CounterBar.gif" alt="CounterBar.gif">
</div>

## Throbber
The abstract Throbber Class provides different child classes (`WheelThrobber`, `DotThrobber`, `TimeThrobber`) 
with each implementing a different throbber animation.
### How to use:
The Throbber is used for processes which can't be directly tracked in their progress 
i.e., with a while-loop or recursion functions. Thus the animation just has to be started
or stopped:

Instantiate a Throbber child with one of two constructors:
* One with an optional "description". 
Meaning You can define what should be printed infront of the animation. (in the examples "Loading" is used 
as description)
* One without any arguments. With this constructor "Loading" is used as default description.

After the initialization, use the method `.start()` on the Throbber object to start the animation.
And use `.stop()` to end the animation!

Note: A separate thread is used to continuously print out the animation (starting the animation starts the new 
thread and stopping the animation joins the Threads back together)!

### Code Example:
```Java
import HoldMyCoffee.Throbber.*;

public static void main(String[] args) {
    Throbber throbber = new WheelThrobber();
    throbber.start(); // start the animation

    // put the ongoing computation here like a while loop, recursive functions or something else.

    throbber.stop(); // end the animation
}
```

## LoadingBar:
The abstract LoadingBar class follows the logic of the Throbbers.
Available child classes are `SmallBar`, `LongBar`, `Counter` and `CounterBar`.

### How to use:
The LoadingBar is used for process which can be tracked in their progress.
For example in for-loops with a running variable. For that, each LoadingBar
instance needs the total amount of loops and to be updated each time after a loop
iteration finishes:

Instatiate one of the child classes with one out of two constructors:
* One constructor takes the **total amount** of loops and a description that is
printed infront of the loading bar.
* One construcotr takes only the **total amount** of loops!
(And uses "Loading" as default description.)

After the initialization, the LoadingBar needs to be updated after each iteration by using the
method `.load(int progress)`.
Provide the current number of the iteration step 
(most of the time simply provide the running variable e.g. "i") to this method
and the bar gets accordingly updated.
Alternatively use the `.loadByOne()` method to increase the progress by one. 

### Code Example:
```Java
import HoldMyCoffee.LoadingBar.LoadingBar;

public static void main(String[] args) {
    int total = 456;
    LoadingBar loadingBar = new LoadingBar(total, "Loading");

    for (int i = 0; i <= total; i++) {
        // put the process and computations on i here
        loadingBar.load(i); // actualize the bar
    }
}
```

