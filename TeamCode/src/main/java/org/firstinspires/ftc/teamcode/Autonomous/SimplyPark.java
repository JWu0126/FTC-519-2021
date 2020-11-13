package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.BaseAutonomous;
import org.firstinspires.ftc.teamcode.StepCounter;

// Built under the assumption that we are starting facing the line

@Autonomous(name = "Simply Park", group = "Not Main")
public class SimplyPark extends BaseAutonomous {

    int step;
    @Override
    public void init() {

        super.init();
        elapsedTime = new ElapsedTime();
        stepCounter = new StepCounter();
    }

    @Override
    public void start() {
        super.start();
        elapsedTime.reset();
        elapsedTime.startTime();
        stepCounter.setStep(1);
    }

    @Override
    public void loop() {
        step = stepCounter.getStep();
        switch(step) {
            case 1:
                driveStraight(0.5f);
                // change this to actually work
                if (elapsedTime.seconds() >= 0.5)
                    stepCounter.next();
                break;

        }
    }
}
