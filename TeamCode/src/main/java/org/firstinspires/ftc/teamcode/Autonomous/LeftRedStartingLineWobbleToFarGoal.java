package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.BaseAutonomous;
import org.firstinspires.ftc.teamcode.StepCounter;

public class LeftRedStartingLineWobbleToFarGoal extends BaseAutonomous {

    int step;
    ElapsedTime elapsedTime = stepCounter.elapsedTime;
    double driveForwardTime = 3.0;
    double strafeRightTime = 2.0;

    @Override
    public void init() {
        stepCounter = new StepCounter();
        super.init();
    }

    @Override
    public void start() {

        stepCounter.setStep(1);
        super.start();
    }

    @Override
    public void loop() {
        elapsedTime = stepCounter.elapsedTime;
        step = stepCounter.getStep();
        switch (step) {
            // Sit still for 25 seconds
            case 1:
                if (elapsedTime.seconds() >= 25.0) {
                    stepCounter.next();
                }
                break;

            // drive straight for 3 seconds
            // change to work
            case 2:
                driveStraight(0.5f);
                if (elapsedTime.seconds() > driveForwardTime) {
                    stepCounter.next();
                }
                break;

            // Maybe I should add a short break in between each movement...
            case 3:
                stopMoving();
                if (elapsedTime.seconds() > 0.1) {
                    stepCounter.next();
                }
                break;

            // strafe right for 2 seconds
            // change to work
            case 4:
                strafeRight();
                if (elapsedTime.seconds() > strafeRightTime) {
                    stepCounter.next();
                }
                break;
            // open the wobble goal hand
            // I chose not to lower it or anything, though it might be more stable
            case 5:
                wobbleGoalHand.setPosition(wobbleHandOpen);
                if (elapsedTime.seconds() >= 0.2) {
                    stepCounter.next();
                }
                break;

            // drive backwards to the line and hope that we don't hit our teammates.
            // change to work
            case 6:
                driveStraight(-0.3f);
                if (elapsedTime.seconds() >= driveForwardTime - totalTimeBackwardsToLine) {
                    stopMoving();
//                    stepCounter.next();
                }
                break;

        }
    }
}
