package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.*;
@TeleOp(name = "ServoTest")
public class ServoTest extends OpMode {
    Servo claw;

    private double  clawClose = 0; // Idk how your servo orianted
    private double clawOpen = 1.0;
    boolean close=false;
    boolean open=false;

    @Override
    public void init() {
        claw = (Servo) hardwareMap.get( "claw");
    }

    @Override
    public void loop() {
        if (gamepad2.a && !close){
            claw.setPosition(clawClose);
            close=true;
            open=false;
        }
        if (gamepad2.b && !open){
            claw.setPosition(clawOpen);
            open=true;
            close=false;
        }
    }
}
