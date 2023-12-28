package org.firstinspires.ftc.teamcode.cre8.vision

import org.firstinspires.ftc.robotcore.external.ClassFactory
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector
import org.firstinspires.ftc.teamcode.vision.MasterVision


/**
 * Created by Parjanya Manchikanti on 12/31/2023.
 */
class TFLite(private val master: Cr8Vision) {
    companion object {
        // Replace this with our tflite file
        private const val TFOD_MODEL_ASSET = "audience_red.tflite"
    private const val LEFT_SIDE = "Left"
    private const val RIGHT_SIDE = "Right"
    private const val CENT_ER = "Center"
    }

    private var tfod: TFObjectDetector? = null
    private val tfodMoniterViewId = master.hMap.appContext.resources.getIdentifier("tfodMonitorViewId", "id", master.hMap.appContext.packageName)
    private val parameters = TFObjectDetector.Parameters(tfodMoniterViewId)

    fun init() {
        if (tfod == null) {
            tfod = ClassFactory.getInstance().createTFObjectDetector(parameters, master.vuforiaLocalizer)
            tfod?.loadModelFromAsset(TFOD_MODEL_ASSET, LEFT_SIDE, RIGHT_SIDE, CENT_ER)
        }
    }

    var lastKnownSampleOrder = Cre8SampleRandomizedPositions.UNKNOWN;

    internal fun updateSampleOrder() {
        if (tfod != null) {
            val updatedRecognitions = tfod?.updatedRecognitions
            if (updatedRecognitions != null) {
                if (updatedRecognitions.size == 3 || updatedRecognitions.size == 2) {
                    var goldMineralX: Int? = null
                    var silverMineral1X: Int? = null
                    var silverMineral2X: Int? = null

                    for (recognition in updatedRecognitions) {
                    }
                }
            }
        }
    }

        fun enable() {
            tfod?.activate()
        }

        fun disable() {
            tfod?.deactivate()
        }

        fun shutdown() {
            tfod?.shutdown()
        }

    }