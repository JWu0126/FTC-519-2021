package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.BaseAutonomous;
import org.firstinspires.ftc.teamcode.StepCounter;

// Built under the assumption that we are starting facing the line

@Autonomous(name = "Simply Park", group = "Not Main")
public class SimplyPark extends BaseAutonomous {

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
    }

    @Override
    public void loop() {
        int step = stepCounter.getStep();
        switch(step) {
            case 1:
                // change this to actually work
                if (elapsedTime.seconds() >= 0.5)
                    driveStraight(0.5f);
                    stepCounter.next();

        }
    }
}
