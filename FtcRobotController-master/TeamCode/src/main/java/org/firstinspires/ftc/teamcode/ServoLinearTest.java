package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp(name = "ServoLinearTest")
public class ServoLinearTest extends LinearOpMode
{


    private Servo arm;


    /**
     * This function is executed when this OpMode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {

        arm = hardwareMap.get(Servo.class, "arm");
        double clawClose = 1.0;
        double clawHalf = 0.5;
        double clawOpen = 0.0;
        boolean isClawClosed = false;
        double SENSITIVITY = 0;
        double a = 1;
        double b = 0.5;
        double x = 0;
        //arm = hardwareMap.get(DcMotor.class, "arm");
        // Reverse one of the drive motors.
        // You will have to determine which motor to reverse for your robot.
        // In this example, the right motor was reversed so that positive
        // applied power makes it move the robot in the forward direction.

        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                // Put loop blocks here.
                // The Y axis of a joystick ranges from -1 in its topmost position
                // to +1 in its bottommost position. We negate this value so that
                // the topmost position corresponds to maximum forward power.


                // check to see if we need to move the servo.
                //open
                if(gamepad1.x){
                    arm.setPosition(clawOpen);
                    sleep(100);
                }
                //half closed
                if(gamepad1.b){
                    arm.setPosition(clawHalf);
                    sleep(100);
                }
                //closed
                if(gamepad1.a){
                    arm.setPosition(clawClose);
                    sleep(100);
                }

                if(gamepad1.y) {
                    // move to 0 degrees.
                    arm.setPosition(0);
                    //arm.setDirection(Servo.Direction.FORWARD);
                }
                if (gamepad1.x || gamepad1.b) {
                    // move to 90 degrees.
                    arm.setPosition(0.5);
                    //arm.setDirection(Servo.Direction.FORWARD);
                }
                if(gamepad1.y) {
                    // move to 0 degrees.
                    arm.setPosition(0);
                    //arm.setDirection(Servo.Direction.FORWARD);
                }
                if (gamepad1.x || gamepad1.b) {
                    // move to 90 degrees.
                    arm.setPosition(0.5);
                    //arm.setDirection(Servo.Direction.FORWARD);
                }
                if (gamepad1.a) {
                    // move to 180 degrees.
                    arm.setPosition(1);
                    //arm.setDirection(Servo.Direction.FORWARD);
                }
                telemetry.addData("Servo Position", arm.getPosition());
                telemetry.update();

            }
        }
    }
}

