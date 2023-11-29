///
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.*;
@TeleOp(name = "ServoTest")
public class ServoTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        //Init
        Servo claw;
        claw = hardwareMap.get(Servo.class,"arm");
        claw.setPosition(0.5);
        System.out.println("Servo Sundaram Initialized");
        waitForStart();
        while(opModeIsActive()) {
            claw.setPosition(1.0);
        }
    }

}
