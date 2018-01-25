package main;

public class Interval {
    private double pastTime = 0;
    private double currentTime = 0;
    private double deltaTime = 0;
    private double timeInterval;

    public Interval(double timeInterval) {
        this.timeInterval = timeInterval;
        currentTime = System.currentTimeMillis();
        pastTime = System.currentTimeMillis();
    }

    public void update() {
        currentTime = System.currentTimeMillis();
        deltaTime += currentTime - pastTime;
        pastTime = currentTime;
    }

    public double decrement() {
        deltaTime -= timeInterval;
        return deltaTime;
    }

    public void reset() {
        deltaTime = 0;
    }

    public boolean hasTick() {
        if(deltaTime >= timeInterval) {
            return true;
        }
        else {
            return false;
        }
    }
}
