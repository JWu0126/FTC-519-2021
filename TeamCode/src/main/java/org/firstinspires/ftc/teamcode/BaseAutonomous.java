package org.firstinspires.ftc.teamcode;

public abstract class BaseAutonomous extends BaseOpMode{

    @Override
    public void init() {
        // call the parent class's init function
        super.init();
    }

    @Override
    public void start() {
        super.start();

        // reset wobbleGoalHand to the "zeroed" position
        wobbleGoalHand.setPosition(0.0);
    }
}