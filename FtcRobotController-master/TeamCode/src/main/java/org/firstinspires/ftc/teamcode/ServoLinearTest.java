package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "ServoLinearTest")
public class ServoLinearTest extends LinearOpMode {
    private Servo arm;
    private Servo claw;


    @Override
    public void runOpMode() throws InterruptedException {
        arm = hardwareMap.get(Servo.class, "arm");
        claw = hardwareMap.get(Servo.class, "claw");
        waitForStart();
        boolean close=false;
        boolean open=false;
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                if(gamepad1.a && !close){
                    arm.setPosition(0);
                    claw.setPosition(0);
                    close=true;
                    open=false;
                }
                if(gamepad1.b && !open){
                    arm.setPosition(1);
                    claw.setPosition(1);
                    open=true;
                    close=false;
                }
            }
        }
    }

}
