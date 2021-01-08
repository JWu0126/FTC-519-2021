package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import com.vuforia.PIXEL_FORMAT;
public class Vuforia {

    public VuforiaLocalizer vuforia = null;
    public VuforiaLocalizer.CloseableFrame frame = null;
    VuforiaLocalizer.Parameters parameters;


    static final String VUFORIA_KEY =
            " --- YOUR NEW VUFORIA KEY GOES HERE  --- ";

    public Vuforia(HardwareMap map) {
        int cameraMonitorViewId = map.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", map.appContext.getPackageName());
        parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        parameters.vuforiaLicenseKey = VUFORIA_KEY;

        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.FRONT;

        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        vuforia.setFrameQueueCapacity(1);
        com.vuforia.Vuforia.setFrameFormat(PIXEL_FORMAT.RGB565, true);
    }
}
