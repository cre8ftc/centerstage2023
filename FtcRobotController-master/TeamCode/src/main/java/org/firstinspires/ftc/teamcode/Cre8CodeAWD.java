package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp(name = "Cre8CodeAWD")
public class Cre8CodeAWD extends LinearOpMode
{

    private DcMotor frontRight;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor backLeft;
    private Servo arm;


    /**
     * This function is executed when this OpMode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        //mapping motors and servos
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        arm = hardwareMap.get(Servo.class, "arm");
        //variables
        double clawClose = 1.0;
        double clawHalf = 0.5;
        double clawOpen = 0.0;

        //Motor directions
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
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


                /***********************************************
                 * MAIN DRIVER CONTROLS   *** GAMEPAD1
                 * *********************************************
                 */
                backRight.setPower(-gamepad1.left_stick_y);
                telemetry.addData("Left Pow", backRight.getPower());
                telemetry.addData("Right Pow", backRight.getPower());
                telemetry.update();
                backLeft.setPower(-gamepad1.left_stick_y);
                telemetry.addData("Left Pow", backLeft.getPower());
                telemetry.addData("Right Pow", backLeft.getPower());
                telemetry.update();
                frontRight.setPower(-gamepad1.left_stick_y);
                telemetry.addData("Left Pow", frontRight.getPower());
                telemetry.addData("Right Pow", frontRight.getPower());
                telemetry.update();
                frontLeft.setPower(-gamepad1.left_stick_y);
                telemetry.addData("Left Pow", frontLeft.getPower());
                telemetry.addData("Right Pow", frontLeft.getPower());
                telemetry.update();

                /******************************************************
                 * Secondary Driver ***** GAMEPAD2
                 * ****************************************************
                 */

                if(gamepad2.y) {
                    // move to 0 degrees.
                    arm.setPosition(0);
                } else if (gamepad2.x || gamepad2.b) {
                    // move to 90 degrees.
                    arm.setPosition(0.5);
                } else if (gamepad2.a) {
                    // move to 180 degrees.
                    arm.setPosition(1);
                }
                telemetry.addData("Servo Position", arm.getPosition());
                telemetry.update();
                // check to see if we need to move the servo.
                //open
                /*if(gamepad2.x){
                    arm.setPosition(clawOpen);
                    sleep(100);
                }
                //half closed
                if(gamepad2.b){
                    arm.setPosition(clawHalf);
                    sleep(100);
                }
                //closed
                if(gamepad2.a){
                    arm.setPosition(clawClose);
                     sleep(100);
                }*/
               /*if(gamepad1.y) {
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
                telemetry.addData("Target Power", tgtPower);
                telemetry.update();*/
                double y = -gamepad1.left_stick_y; // Remember, Y stick is reversed!
                double rx = gamepad1.right_stick_x;
                backLeft.setPower(y + rx);
                backRight.setPower(y - rx);
                frontLeft.setPower(y + rx);
                frontRight.setPower(y - rx);
                /*double y = -gamepad1.left_stick_y; // Remember, Y stick is reversed!
                double x = gamepad1.left_stick_x;
                double rx = gamepad1.right_stick_x;
                frontLeft.setPower(y + x + rx);
                backLeft.setPower(y - x + rx);
                frontRight.setPower(y - x - rx);
                backRight.setPower(y + x - rx);*/
            }
        }
    }
}

