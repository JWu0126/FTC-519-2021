package org.firstinspires.ftc.teamcode.Autonomous;

import android.graphics.Bitmap;

import android.graphics.Color;
import com.vuforia.Image;
import com.vuforia.PIXEL_FORMAT;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import static org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection.BACK;

import org.firstinspires.ftc.teamcode.BaseOpMode;


// I'll leave it abstract for now
public abstract class LeftRedSquareFinder extends BaseOpMode {

    Telemetry telemetry;

    static final VuforiaLocalizer.CameraDirection CAMERA_CHOICE = BACK;
    static final boolean PHONE_IS_PORTRAIT = false;

    static final String VUFORIA_KEY =
            " --- YOUR NEW VUFORIA KEY GOES HERE  --- ";

    VuforiaLocalizer vuforia = null;
    VuforiaLocalizer.CloseableFrame frame = null;

    Image rawImage;
    Bitmap image;

    protected void initialize() {
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

        rawImage = frame.getImage(0);

        image = Bitmap.createBitmap(rawImage.getWidth(), rawImage.getHeight(), Bitmap.Config.RGB_565);
    }

    protected boolean isPixelYellow(int pixel) {

        double red = Color.red(pixel);
        double green = Color.green(pixel);
        double blue = Color.blue(pixel);

        // maybe tweak numbers? Not sure where Mike got them
        double yellow = ((red + green)) / 500;

        // stolen numbers from Mike's code. CHANGE FOR LATER (probably)
        if (yellow > 0.8 && blue < 80) {
            return true;
        } else {
            return false;
        }

    }

    enum location{
        FAR, MED, CLOSE
    }

    protected location findSquare() {

        int amountOfYellow = 0;

        for (int x = 0; x < image.getHeight(); x++) {
            for (int y = 0; y < image.getWidth(); y++) {
                if (isPixelYellow(image.getPixel(x, y))) {
                    amountOfYellow++;
                }
            }
        }

        // arbitrary numbers
        if (amountOfYellow <= 100) {
            telemetry.addLine("Location was Far");
            return location.FAR;
        } else if (amountOfYellow <= 50) {
            telemetry.addLine("Location was Med");
            return location.MED;
        } else {
            telemetry.addLine("Went to else statement. Assuming it's Close");
            return location.CLOSE;
        }
    }

}