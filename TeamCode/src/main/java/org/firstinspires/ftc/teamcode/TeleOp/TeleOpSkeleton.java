package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.BaseTeleOp;

// CHANGE NAMES LATER!!!
@TeleOp(name = "Don't use this one", group = "Not Main")
public class TeleOpSkeleton extends BaseTeleOp {

    ElapsedTime elapsedTime;

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

        driveMotors(x, y, z);
    }
}
