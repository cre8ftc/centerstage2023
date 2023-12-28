package org.firstinspires.ftc.teamcode.cre8.vision;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;

import org.firstinspires.ftc.teamcode.cre8.vision.Cre8SampleRandomizedPositions;

@TeleOp
@Disabled
public class Cr8VisionJavaExample extends LinearOpMode{
    Cr8Vision vision;
    Cre8SampleRandomizedPositions goldPosition;

    @Override
    public void runOpMode() throws InterruptedException {
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;// recommended camera direction
        parameters.vuforiaLicenseKey = "AcERBon/////AAABmZluK/8VS0VGpnda8Pa7C14UDKh6W3Ga2hYatekFerIZJ8BCaRHSWfs8FjKHLXvPe5VRvUP23W4upCqe7evLzoUw9HVhI+8t0+99t2CLYNNrYFjLgMO9ooR+tnlSQvr29qZb9fSKQRQxU6eD0V2MMSn7RmaXDG9SX4GHPUEq2SXw5xcw43KM/lqcROGCN4npBzk204wwQikk0tTqZ70S1vAQDTfhlHYICo8EylfplBmyA4oW9pzkxNZpGMCWqikmArN5H6s+D0ed03q3e3Q17RLFF7PXLliJzWMalPJbSG8QincgyQQIkp/VxJTzsNQwkEb3jy/pcPKozxTbgULTaz3bwkOtTm/OmDh4AJrrXkCP";
        vision = new Cr8Vision(parameters, hardwareMap, true, Cr8Vision.TFLiteAlgorithm.INFER_NONE);
        vision.init();// enables the camera overlay. this will take a couple of seconds
        vision.enable();// enables the tracking algorithms. this might also take a little time

        waitForStart();
        goldPosition = vision.getTfLite().getLastKnownSampleOrder();

        while(opModeIsActive()){
            telemetry.addData("goldPosition was", goldPosition);// giving feedback

            switch (goldPosition){ // using for things in the autonomous program
                case LEFT:
                    telemetry.addLine("going to the left");
                    break;
                case CENTER:
                    telemetry.addLine("going straight");
                    break;
                case RIGHT:
                    telemetry.addLine("going to the right");
                    break;
                case UNKNOWN:
                    telemetry.addLine("staying put");
                    break;
            }

            telemetry.update();
        }

        vision.shutdown();


    }
}