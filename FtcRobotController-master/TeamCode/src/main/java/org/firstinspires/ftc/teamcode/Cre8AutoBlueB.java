package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "Cre8AutoBlueB")
public class Cre8AutoBlueB extends LinearOpMode
{

    private DcMotor frontRight;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor backLeft;

    //private DcMotor arm;

    /**
     * This function is executed when this OpMode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() throws InterruptedException {
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        //arm = hardwareMap.get(DcMotor.class, "arm");
        double DRIVE_POWER = 0.3;
        // Reverse one of the drive motors.
        // You will have to determine which motor to reverse for your robot.
        // In this example, the right motor was reversed so that positive
        // applied power makes it move the robot in the forward direction.
        //arm.setDirection(DcMotorSimple.Direction.FORWARD);
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                // Put loop blocks here.
                // The Y axis of a joystick ranges from -1 in its topmost position
                // to +1 in its bottommost position. We negate this value so that
                // the topmost position corresponds to maximum forward power.

                // Drive Forward inches
                DriveForwardTime(DRIVE_POWER,1000);
                // Turn right 90 degrees
                TurnRightTime(DRIVE_POWER,50);
                DriveForwardTime(DRIVE_POWER,1000);
                TurnRightTime(DRIVE_POWER,50);
                DriveForwardTime(DRIVE_POWER,1000);
                TurnRightTime(DRIVE_POWER,70);
                DriveForwardTime(DRIVE_POWER,1000);
                TurnRightTime(DRIVE_POWER,90);
                DriveForwardTime(DRIVE_POWER,1000);
                TurnLeftTime(DRIVE_POWER,1000);
                DriveForwardTime(DRIVE_POWER,2000);
                // Turn right 90 degrees
                TurnRightTime(DRIVE_POWER,50);
                DriveForwardTime(DRIVE_POWER,2000);
                TurnRightTime(DRIVE_POWER,50);
                DriveForwardTime(DRIVE_POWER,2000);
                TurnRightTime(DRIVE_POWER,50);
                DriveForwardTime(DRIVE_POWER,1000);
                TurnRightTime(DRIVE_POWER,1500);
                StopDriving();

            }
        }
    }
    public void DriveForward(double power)
    {
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);
    }

    public void DriveForwardTime (double power, long time) throws InterruptedException
    {
        DriveForward(power);
        Thread.sleep(time);
    }
    public void DriveBackward(double power)
    {
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);
    }

    public void DriveBackwardTime (double power, long time) throws InterruptedException
    {
        DriveBackward(power);
        Thread.sleep(time);
    }
    public void TurnLeft(double power)
    {
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);
    }

    public void TurnLeftTime (double power, long time) throws InterruptedException
    {
        TurnLeft(power);
        Thread.sleep(time);
    }
    public void TurnRight(double power)
    {
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);
    }

    public void TurnRightTime (double power, long time) throws InterruptedException
    {
        TurnRight(power);
        Thread.sleep(time);
    }
    public void StopDriving()
    {
        DriveForward(0);
    }
}