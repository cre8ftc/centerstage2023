package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Cre8CodeRWD")
public class Cre8CodeRWD extends LinearOpMode
{

    private DcMotor backRight;
    private DcMotor backLeft;
    //private DcMotor arm;

    /**
     * This function is executed when this OpMode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        //arm = hardwareMap.get(DcMotor.class, "arm");
        // Reverse one of the drive motors.
        // You will have to determine which motor to reverse for your robot.
        // In this example, the right motor was reversed so that positive
        // applied power makes it move the robot in the forward direction.
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                // Put loop blocks here.
                // The Y axis of a joystick ranges from -1 in its topmost position
                // to +1 in its bottommost position. We negate this value so that
                // the topmost position corresponds to maximum forward power.
                backRight.setPower(-gamepad1.left_stick_y);
                telemetry.addData("Left Pow", backRight.getPower());
                telemetry.addData("Right Pow", backRight.getPower());
                telemetry.update();
                backLeft.setPower(-gamepad1.left_stick_y);
                telemetry.addData("Left Pow", backLeft.getPower());
                telemetry.addData("Right Pow", backLeft.getPower());
                telemetry.update();
                /*arm.setPower(-gamepad2.left_stick_y);
                telemetry.addData("Left Pow", arm.getPower());
                telemetry.addData("Right Pow", arm.getPower());
                telemetry.update();*/
                double y = -gamepad1.left_stick_y; // Remember, Y stick is reversed!
                double rx = gamepad1.right_stick_x;
                backLeft.setPower(y + rx);
                backRight.setPower(y - rx);
            }
        }
    }
}

