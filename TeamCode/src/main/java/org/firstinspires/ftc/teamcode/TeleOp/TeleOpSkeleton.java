package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.BaseTeleOp;

// CHANGE NAMES LATER!!!
@TeleOp(name = "Don't use this one", group = "Not Main")
public class TeleOpSkeleton extends BaseTeleOp {

    private ElapsedTime elapsedTime;
    private boolean buttonPressed = false;
    private boolean buttonJustReleased = false;
    private boolean handOpen = true;

    @Override
    public void init() {
        elapsedTime = new ElapsedTime();
        elapsedTime.reset();
        super.init();

    }

    @Override
    public void start() {
        super.start();
        elapsedTime.startTime();

    }

    @Override
    public void loop() {
        telemetry.addData("Time Passed: ", elapsedTime.seconds());

        // add in controls, change as needed

        x = shapeInput(applyDeadZone(driver.left_stick_x));
        y = shapeInput(applyDeadZone(driver.left_stick_y));
        z = shapeInput(applyDeadZone(driver.right_stick_x));

        if (invertMotors) {
            x = -x;
            y = -y;
        }

        // hopefully this works the way I think it will
        if (someControl) {
            elapsedTime.startTime();
            if (elapsedTime.seconds() >= 0.1) {
                slowMode = !slowMode;
            }
        }

        if (slowMode) {
            x /= 10;
            y /= 10;
            x /= 10;
        }

        driveMotors(x, y, z);

        // if it was released previously, then check if its pressed NOW
        if (buttonJustReleased) {
            if (someControl) {
                buttonPressed = true;
            }
        }

        // if it was pressed now then see if its not anymore, if its not then change positions.
        // I think this works.
        // Basically works on release of the button
        if (buttonPressed) {
            if (!someControl) {
                buttonJustReleased = true;

                // just to switch between the two states
                if (handOpen) {
                    wobbleGoalHand.setPosition(wobbleHandClosed);
                } else {
                    wobbleGoalHand.setPosition(wobbleHandOpen);
                }
            }
        }

        // edit the power to be better for all of these
        if (someControl) {
            setWobbleGoalArmUp();
        } else if (someControl) {
            setWobbleGoalArmDown();
        } else {
            wobbleGoalArm.setPower(0.0);
        }

        if (someControl) {
            runShooter(1.0);
        }

        if (someControl) {
            runShooter(-1.0);
        }

        if (someControl) {
            intake.setPower(0.4);
        }

        if (someControl) {
            intake.setPower(-0.4);
        }


    }
}
