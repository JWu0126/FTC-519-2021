package org.firstinspires.ftc.teamcode.Recording;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class RecordingThread extends Thread {

    private HardwareMap map;
    private BlackBox.Recorder recorder;
    private ElapsedTime recordTimer;

    public RecordingThread(BlackBox.Recorder recorder, HardwareMap map) {
        this.map = map;
        this.recorder = recorder;
    }

    public void run() {
        if (recordTimer == null) {
            recordTimer = new ElapsedTime();
            recordTimer.reset();
        }

        try {
            this.recorder.recordAllDevices(recordTimer.time());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}