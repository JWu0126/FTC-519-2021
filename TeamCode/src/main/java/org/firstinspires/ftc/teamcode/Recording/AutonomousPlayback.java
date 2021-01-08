package org.firstinspires.ftc.teamcode.Recording;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.BaseOpMode;
import org.firstinspires.ftc.teamcode.Vuforia;
import org.firstinspires.ftc.teamcode.Recording.BlackBox;
import org.firstinspires.ftc.teamcode.Recording.PersistentFileInputStream;

public class AutonomousPlayback extends BaseOpMode {

    private PersistentFileInputStream inputStream;
    private String recordingName;
    private BlackBox.Player player;
    private ElapsedTime elapsedTime;

    private boolean hasSampled = false;
    private boolean playingBack = false;
    private Vuforia vuforia;

    public AutonomousPlayback(String recordingName) {
        this.recordingName = recordingName;
    }

    public void init() {
        vuforia = new Vuforia(this.hardwareMap);
        super.init();

        // FIXME: These should be some values, but what they are now are not good, but
        //        not initializing to any value isn't any better, since they seem to get
        //        energized when the rest of the robot tries to do things

    }

    public void init_loop() {

    }

    public void start() {

    }

    public void loop() {
        /*if (!hasSampled) {
            hasSampled = true;
            vuforia.sampleStonePosition(telemetry);
        }
        if (vuforia.stoneThread.position != null && !playingBack) {
            playingBack = true;
            try {
                inputStream = new PersistentFileInputStream(this.recordingName.replace("%s", vuforia.stoneThread.position));
                player = new BlackBox.Player(inputStream.get(), hardwareMap);
                elapsedTime = new ElapsedTime();
                elapsedTime.reset();
            } catch (Exception e) {
                this.requestOpModeStop();
                e.printStackTrace();
            }
        }*/



        if (player == null) {
            try {
                inputStream = new PersistentFileInputStream(this.recordingName);
                player = new BlackBox.Player(inputStream.get(), hardwareMap);
                elapsedTime = new ElapsedTime();
                elapsedTime.reset();
            } catch (Exception e) {
                this.telemetry.addData("Can't create player", "!");
            }
        } else {
            try {
                player.playback(elapsedTime.time());
            } catch (Exception e) {
                this.telemetry.addData("Can't play back auto", "!");
            }
        }
    }


    /*@Autonomous(name = "AutonomousRed", group = "Competition")
    public static class AutonomousRed extends AutonomousPlayback {
        public AutonomousRed() {
            super("RedNoStone");
           // super("RedStone%s");
        }
    }
    @Autonomous(name = "AutonomousBlue", group = "Competition")
    public static class AutonomousBlue extends AutonomousPlayback {
        public AutonomousBlue() {
            super("BlueNoStone");
           // super("BlueStone%s");
        }
    }*/

    @Autonomous(name = "BluePark", group = "Competition")
    public static class BluePark extends AutonomousPlayback {
        public BluePark() {
            super("BluePark");
        }
    }

    @Autonomous(name = "RedPark", group = "Competition")
    public static class RedPark extends AutonomousPlayback {
        public RedPark() {
            super("RedPark");
        }
    }

    @Autonomous(name = "BlueFoundationPark", group = "Competition")
    public static class BlueFoundationPark extends AutonomousPlayback {
        public BlueFoundationPark() {
            super("BlueFoundationPark");
        }
    }

    @Autonomous(name = "RedFoundationPark", group = "Competition")
    public static class RedFoundationPark extends AutonomousPlayback {
        public RedFoundationPark() {
            super("RedFoundationPark");
        }
    }

    @Autonomous(name = "RedBlockFoundationPark", group = "Competition")
    public static class RedBlockFoundationPark extends AutonomousPlayback {
        public RedBlockFoundationPark() {
            super("RedBlockFoundationPark");
        }
    }

    @Autonomous(name = "BlueBlockFoundationPark", group = "Competition")
    public static class BlueBlockFoundationPark extends AutonomousPlayback {
        public BlueBlockFoundationPark() {
            super("BlueBlockFoundationPark");
        }
    }
}