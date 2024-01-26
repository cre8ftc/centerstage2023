package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp(name = "awdon")
public class Cre8CodeAWD extends LinearOpMode
{

    private DcMotor frontRight;
    private DcMotor animal;
    private DcMotor backRight;
    private DcMotor backLeft;
    private DcMotor parjanya;
    private DcMotor intakke;
    private DcMotor zewp;
    private DcMotor zow;
    private Servo ninjalauncher;
    private Servo boxy;
    private Servo intomotion;

    /**
     * This function is executed when this OpMode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() throws InterruptedException {
        //mapping motors and servos
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        animal = hardwareMap.get(DcMotor.class, "animal");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        parjanya =  hardwareMap.get(DcMotor.class, "parjanya");
        intakke = hardwareMap.get(DcMotor.class, "intakke");
        zewp = hardwareMap.get(DcMotor.class, "zewp");
        zow = hardwareMap.get(DcMotor.class, "zow");
        ninjalauncher = hardwareMap.get(Servo.class, "ninja");
        intomotion = hardwareMap.get(Servo.class, "intoMotion");
        boxy = hardwareMap.get(Servo.class, "boxyboxbox");
        //variables

        //Motor directions
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        animal.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        zewp.setDirection(DcMotorSimple.Direction.FORWARD);
        zow.setDirection(DcMotorSimple.Direction.FORWARD);
        parjanya.setDirection(DcMotorSimple.Direction.FORWARD);
        intakke.setDirection(DcMotorSimple.Direction.FORWARD);

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
                animal.setPower(-gamepad1.left_stick_y);
                telemetry.addData("Left Pow", animal.getPower());
                telemetry.addData("Right Pow", animal.getPower());
                telemetry.update();
                //Turns
                double y = -gamepad1.left_stick_y; // Remember, Y stick is reversed!
                double rx = gamepad1.right_stick_x;
                backLeft.setPower(y - rx);
                backRight.setPower(y + rx);
                animal.setPower(y - rx);
                frontRight.setPower(y + rx);
                //intakke
                intakke.setPower(-gamepad1.right_trigger);
                telemetry.addData("Left1 Pow", intakke.getPower());
                telemetry.addData("Right Pow", intakke.getPower());
                telemetry.update();

                /******************************************************
                 * Arm Driver ***** GAMEPAD2
                 * ****************************************************
                 */
                //drone
                if(gamepad2.a){
                    ninjalauncher.setPosition(90);
                }
                if(gamepad2.b){
                    ninjalauncher.setPosition(0);
                }
                //into motion
                if(gamepad2.right_bumper){
                    intomotion.setPosition(0);
                }
                if(gamepad2.left_bumper){
                    intomotion.setPosition(50);
                }
                //box
                if(gamepad2.x){
                    boxy.setPosition(0);
                }
                if(gamepad2.y){
                    boxy.setPosition(70);
                }
                //backdrop
                zewp.setPower(-gamepad2.right_stick_y);
                telemetry.addData("Left Pow", zewp.getPower());
                telemetry.addData("Right Pow", zewp.getPower());
                telemetry.update();
                zow.setPower(-gamepad2.left_stick_y);
                telemetry.addData("Left Pow", zow.getPower());
                telemetry.addData("Right Pow", zow.getPower());
                telemetry.update();
                //rigging
                parjanya.setPower(-gamepad2.left_trigger);
                telemetry.addData("Left Pow", parjanya.getPower());
                telemetry.addData("Right Pow", parjanya.getPower());
                telemetry.update();
                parjanya.setPower(gamepad2.right_trigger);
                telemetry.addData("Left Pow", parjanya.getPower());
                telemetry.addData("Right Pow", parjanya.getPower());
                telemetry.update();
            }
        }
    }
}

