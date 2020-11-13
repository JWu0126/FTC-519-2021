package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;

public abstract class BaseAutonomous extends BaseOpMode{

    protected StepCounter stepCounter;
    protected ElapsedTime elapsedTime;

    @Override
    public void init() {
        // call the parent class's init function
        wobbleGoalHand.setPosition(wobbleHandClosed);
        super.init();
    }

    @Override
    public void start() {
        super.start();

        // reset wobbleGoalHand to the "zeroed" position
        wobbleGoalHand.setPosition(0.0);
    }

    // I think?
    public void strafeLeft() {
        frontLeft.setPower(0.5);
        frontRight.setPower(-0.5);
        backLeft.setPower(-0.5);
        backRight.setPower(0.5);
    }

    // I think?
    public void strafeRight() {
        frontLeft.setPower(-0.5);
        frontRight.setPower(0.5);
        backLeft.setPower(0.5);
        backRight.setPower(-0.5);
    }

    public void driveStraight(float power) {
        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);
    }

    public void pivotRight() {
        frontLeft.setPower(0.5);
        frontRight.setPower(-0.5);
        backLeft.setPower(0.5);
        backRight.setPower(-0.5);
    }

    public void pivotLeft() {
        frontLeft.setPower(-0.5);
        frontRight.setPower(0.5);
        backLeft.setPower(-0.5);
        backRight.setPower(0.5);
    }
}