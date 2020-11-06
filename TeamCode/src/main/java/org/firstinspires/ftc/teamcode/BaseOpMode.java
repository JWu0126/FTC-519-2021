package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

public abstract class BaseOpMode extends OpMode{

    // declare motors and servos
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;

    DcMotor wobbleGoalArm;
    Servo wobbleGoalHand;

    DcMotor intake;
    DcMotor shooter;

    // Uncomment if used
//    DcMotor feeder;

    @Override
    public void init() {
        // find drive train motors config in app?
        frontLeft = hardwareMap.dcMotor.get("front_left");
        frontRight = hardwareMap.dcMotor.get("front_right");
        backLeft = hardwareMap.dcMotor.get("back_left");
        backRight = hardwareMap.dcMotor.get("back_right");

        // set all drive train motors to Brake
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // flip the left side
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        // find the wobble goal motors and servos in app
        wobbleGoalArm = hardwareMap.dcMotor.get("wobble_goal_arm");
        wobbleGoalHand = hardwareMap.servo.get("wobble_goal_hand");

        wobbleGoalArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // find the ring manipulator motors in app
        intake = hardwareMap.dcMotor.get("intake");
        shooter = hardwareMap.dcMotor.get("shooter");

        // set shooter and intake to "float" at zero to maintain rotation
        shooter.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    @Override
    public void start() {
        // what does this actually do?
        super.start();
    }
}
