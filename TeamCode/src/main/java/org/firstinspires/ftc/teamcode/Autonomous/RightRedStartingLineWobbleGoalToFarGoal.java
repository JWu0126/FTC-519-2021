package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.BaseAutonomous;
import org.firstinspires.ftc.teamcode.StepCounter;

public class RightRedStartingLineWobbleGoalToFarGoal extends BaseAutonomous {

    ElapsedTime elapsedTime = stepCounter.elapsedTime;
    int step;
    double timeForward = 3.0;

    @Override
    public void init() {
        stepCounter = new StepCounter();
        super.init();
    }

    @Override
    public void start() {
        super.start();
        stepCounter.setStep(1);
    }

    @Override
    public void loop() {
        elapsedTime = stepCounter.elapsedTime;
        step = stepCounter.getStep();

        switch (step) {
            case 1:
                if (elapsedTime.seconds() >= 15) {
                    stepCounter.next();
                }
                break;

            case 2:
                strafeRight();
                if (elapsedTime.seconds() >= 0.1) {
                    stepCounter.next();
                }
                break;
            case 3:
                if (elapsedTime.seconds() >= 0.2) {
                    stepCounter.next();
                }
                break;

            case 4:
                driveStraight(0.5f);
                if (elapsedTime.seconds() >= 3.0) {
                    stepCounter.next();
                }
                break;

            case 5:
                if (elapsedTime.seconds() >= 0.2) {
                    stepCounter.next();
                }
                break;
            case 6:
                wobbleGoalHand.setPosition(wobbleHandOpen);
                if (elapsedTime.seconds() >= 0.2) {
                    stepCounter.next();
                }
                break;

            case 7:
                if (elapsedTime.seconds() >= totalTimeBackwardsToLine - timeForward) {
                    stepCounter.next();
                }
                
        }
    }
}
