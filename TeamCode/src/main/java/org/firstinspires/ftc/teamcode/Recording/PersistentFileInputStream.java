package org.firstinspires.ftc.teamcode.Recording;

import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

// Michael Moss - FTC519 12/14/19
public class PersistentFileInputStream {

    private FileInputStream inputStream;
    public PersistentFileInputStream(String name) throws Exception {
        if (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            throw new Exception("Can't mount media");
        }

        String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString();
        File f = new File(root + name);
        if (!f.exists()) {
            throw new Exception("File doesn't exist");
        }

        try {
            // Create a new file in that location for writing

            inputStream = new FileInputStream(f);
        } catch(Exception e) {
            throw new Exception("Unable to create input stream from file");
        }
    }

    public FileInputStream get() {
        return this.inputStream;
    }
}