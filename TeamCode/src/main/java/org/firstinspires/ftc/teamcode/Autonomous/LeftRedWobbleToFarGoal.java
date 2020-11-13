package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.BaseAutonomous;
import org.firstinspires.ftc.teamcode.StepCounter;

@Autonomous(name = "LeftRedWobbleToFarGoal", group = "Not Main")
public class LeftRedWobbleToFarGoal extends BaseAutonomous {

    int step;
    @Override
    public void init() {

        stepCounter = new StepCounter();
        elapsedTime = new ElapsedTime();
        super.init();
    }

    @Override
    public void start() {
        elapsedTime.reset();
        elapsedTime.startTime();
        stepCounter.setStep(1);
        super.start();
    }

    @Override
    public void loop() {
        step = stepCounter.getStep();
        switch (step) {
            case 1:
                if (elapsedTime.seconds() >= 25.0) {
                    stepCounter.next();
                }
                break;
            case 2:
                driveStraight(0.5f);
                if (elapsedTime.seconds() > 3.0) {
                    stepCounter.next();
                }
                break;
            case 3:
                strafeRight();
                if (elapsedTime.seconds() > 2.0) {
                    stepCounter.next();
                }
                break;
            case 4:
                wobbleGoalHand.setPosition(wobbleHandOpen);
                if (elapsedTime.seconds() >= 0.2) {
                    stepCounter.next();
                }
                break;
        }
    }
}
