package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "floyd")
public class Cre8CodeWorkingAWD extends LinearOpMode
{

    private DcMotor frontRight;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor backLeft;
    /*private DcMotor riggingActivate;
    private DcMotor riggingDeploy;
    private Servo bayServo;
    private Servo droneLauncher;
    private Servo aLittlePush;*/



    /**
     * This function is executed when this OpMode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() throws InterruptedException {
        //mapping motors and servos
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontLeft = hardwareMap.get(DcMotor.class, "animal");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        //riggingActivate =  hardwareMap.get(DcMotor.class, "activate");
        //riggingDeploy =  hardwareMap.get(DcMotor.class, "parjanya");
        //bayServo = hardwareMap.get(Servo.class, "bay");
        //droneLauncher = hardwareMap.get(Servo.class, "launcher");
        //aLittlePush = hardwareMap.get(Servo.class, "aLittlePush");
        //variables
        double bayOpen = 0.5;
        double close = 0.0;
        double launcherOpen = 1.0;

        //Motor directions
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        //riggingActivate.setDirection(DcMotorSimple.Direction.FORWARD);
        //riggingDeploy.setDirection(DcMotorSimple.Direction.FORWARD);
        waitForStart();

        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                // Put loop blocks here.
                // The Y axis of a joystick ranges from -1 in its topmost position
                // to +1 in its bottommost position. We negate this value so that
                // the topmost position corresponds to maximum forward power.



                /***********************************************
                 * Movement DRIVER CONTROLS   *** GAMEPAD1
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
                 * Arm Driver ***** GAMEPAD2
                 * ****************************************************
                 */
               /* //Bay Closed
                if(gamepad2.a){
                    bayServo.setPosition(0.35);
                }
                //Bay Open
                if(gamepad2.b){
                    bayServo.setPosition(bayOpen);
                }
                //launch drone
                if(gamepad2.dpad_up){
                    droneLauncher.setPosition(launcherOpen);
                }
                //reset drone servo
                if(gamepad2.dpad_down){
                    droneLauncher.setPosition(close);
                }
                //a little push protocol
                if(gamepad2.right_bumper){
                    aLittlePush.setPosition(0.5);
                }
                if(gamepad2.left_bumper){
                    aLittlePush.setPosition(0.2);
                }
                //rigging
                riggingActivate.setPower(-gamepad2.left_stick_y);
                telemetry.addData("Left1 Pow", riggingActivate.getPower());
                telemetry.addData("Right Pow", riggingActivate.getPower());
                telemetry.update();
                riggingDeploy.setPower(-gamepad2.right_stick_y);
                telemetry.addData("Left Pow", riggingDeploy.getPower());
                telemetry.addData("Right Pow", riggingDeploy.getPower());
                telemetry.update();
*/
                //Turns
                double y = -gamepad1.left_stick_y; // Remember, Y stick is reversed!
                double rx = gamepad1.right_stick_x;
                backLeft.setPower(y - rx);
                backRight.setPower(y + rx);
                frontLeft.setPower(y - rx);
                frontRight.setPower(y + rx);
            }
        }
    }
}

