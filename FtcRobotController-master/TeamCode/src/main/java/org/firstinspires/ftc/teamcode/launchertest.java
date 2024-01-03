package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "O_O")
public class launchertest extends LinearOpMode
{

    private Servo launcherServo;



    /**
     * This function is executed when this OpMode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() throws InterruptedException {
        //mapping motors and servos

        launcherServo = hardwareMap.get(Servo.class, "launcher");

        //variables
        double bayOpen = 0.5;
        double close = 0.0;
        double launcherOpen = 1.0;

        waitForStart();

        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                // Put loop blocks here.
                // The Y axis of a joystick ranges from -1 in its topmost position
                // to +1 in its bottommost position. We negate this value so that
                // the topmost position corresponds to maximum forward power.




                //Bay Closed
                if(gamepad2.a){
                    launcherServo.setPosition(0.5);
                    sleep(100);
                }
                if(gamepad2.b){
                    launcherServo.setPosition(0);
                    sleep(100);
                }
            }
        }
    }
}

