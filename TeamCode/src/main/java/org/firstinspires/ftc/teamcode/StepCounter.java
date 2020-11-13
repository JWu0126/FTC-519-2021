package org.firstinspires.ftc.teamcode;

public class StepCounter {

    protected int step;

    public StepCounter() {
        step = 0;
    }

    public void next() {
        this.step++;
    }

    public void setStep(int location) {
        this.step = location;
    }

    public int getStep() {
        return this.step;
    }

}
