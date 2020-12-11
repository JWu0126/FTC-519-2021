package org.firstinspires.ftc.teamcode.Autonomous;

import android.graphics.Bitmap;

import com.vuforia.PIXEL_FORMAT;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import static org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection.BACK;
import org.firstinspires.ftc.robotcore.internal.vuforia.VuforiaLocalizerImpl;

import org.firstinspires.ftc.teamcode.BaseAutonomous;


// I'll leave it abstract for now
public abstract class LeftRedSquareFinder extends BaseAutonomous {

    Telemetry telemetry;

    static final VuforiaLocalizer.CameraDirection CAMERA_CHOICE = BACK;
    static final boolean PHONE_IS_PORTRAIT = false  ;

    static final String VUFORIA_KEY =
            " --- YOUR NEW VUFORIA KEY GOES HERE  --- ";

    VuforiaLocalizer vuforia = null;
    VuforiaLocalizer.CloseableFrame frame = null;

    public void initialize() {
        telemetry.addLine("Initializing Vuforia things");

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraDirection   = CAMERA_CHOICE;

        // creates vuforia object
        vuforia = ClassFactory.getInstance().createVuforia(parameters);


        com.vuforia.Vuforia.setFrameFormat(PIXEL_FORMAT.RGB565, true);

        vuforia.setFrameQueueCapacity(1);

        try {
            frame = vuforia.getFrameQueue().take();
        } catch (InterruptedException e) {
            telemetry.addLine("Couldn't take picture");
        }
    }

    enum location{
        FAR, MED, CLOSE
    }

    public location findSquare() {





        return location.FAR;
    }

}
