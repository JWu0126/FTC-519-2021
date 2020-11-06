package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;

// Last year's wasn't abstract but I don't understand the need for a loop
public abstract class BaseTeleOp extends BaseOpMode{

    protected Gamepad driver;
    protected Gamepad gunner;

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void start() {
        super.start();

        // reset wobbleGoalHand to the "zeroed" position
        wobbleGoalHand.setPosition(0.0);
    }

    protected static double shapeInput(double input) {
        if (input > 0.0) {
            return input * input;
        } else {
            return input * -input;
        }
    }

    void driveMotors(double x, double y, double z) {

    }
}
