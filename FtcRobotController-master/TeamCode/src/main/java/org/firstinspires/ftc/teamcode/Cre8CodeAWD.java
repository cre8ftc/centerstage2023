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
    private DcMotor riggingActivate;
    private DcMotor riggingDeploy;
    private Servo bayServo;
    private Servo droneLauncher;



    /**
     * This function is executed when this OpMode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() throws InterruptedException {
        //mapping motors and servos
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        riggingActivate =  hardwareMap.get(DcMotor.class, "activate");
        riggingDeploy =  hardwareMap.get(DcMotor.class, "deploy");
        bayServo = hardwareMap.get(Servo.class, "bay");
        droneLauncher = hardwareMap.get(Servo.class, "launcher");
        //variables
        double bayOpen = 0.5;
        double close = 0.0;
        double launcherOpen = 1.0;

        //Motor directions
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        riggingActivate.setDirection(DcMotorSimple.Direction.FORWARD);
        riggingDeploy.setDirection(DcMotorSimple.Direction.FORWARD);
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
                //forward and back
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
                //turning
                double y = -gamepad1.left_stick_y; // Remember, Y stick is reversed!
                double rx = gamepad1.right_stick_x;
                backLeft.setPower(y + rx);
                backRight.setPower(y - rx);
                frontLeft.setPower(y + rx);
                frontRight.setPower(y - rx);
                /******************************************************
                 * Arm Driver ***** GAMEPAD2
                 * ****************************************************
                 */
                //Bay Closed
                if(gamepad2.a){
                    bayServo.setPosition(close);
                    sleep(100);
                }
                //Bay Open
                if(gamepad2.b){
                    bayServo.setPosition(bayOpen);
                    sleep(100);
                }
                //launch drone
                if(gamepad2.dpad_up){
                    droneLauncher.setPosition(launcherOpen);
                }
                //reset drone servo
                if(gamepad2.dpad_down){
                    droneLauncher.setPosition(close);
                }
                //rigging
                /*riggingActivate.setPower(-gamepad2.left_stick_y);
                telemetry.addData("Left1 Pow", riggingActivate.getPower());
                telemetry.addData("Right Pow", riggingActivate.getPower());
                telemetry.update();
                riggingDeploy.setPower(-gamepad2.right_stick_y);
                telemetry.addData("Left Pow", riggingDeploy.getPower());
                telemetry.addData("Right Pow", riggingDeploy.getPower());
                telemetry.update();*/
               

                
               
            }
        }
    }
}

