package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;

public class StepCounter {

    public ElapsedTime elapsedTime = new ElapsedTime();
    protected int step;

    public StepCounter() {
        step = 0;
    }

    public void next() {
        this.step++;
        elapsedTime.reset();
    }

    public void setStep(int location) {
        this.step = location;
    }

    public int getStep() {
        return this.step;
    }

}
