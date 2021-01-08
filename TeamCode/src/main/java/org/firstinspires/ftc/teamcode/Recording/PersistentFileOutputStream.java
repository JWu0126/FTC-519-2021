package org.firstinspires.ftc.teamcode.Recording;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;

// Michael Moss - FTC519 12/14/19
public class PersistentFileOutputStream {

    private FileOutputStream outputStream;

    public PersistentFileOutputStream(String name) throws Exception {
        if (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            throw new Exception("Can't mount media");
        }

        String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString();
        File f = new File(root + name);

        // Check if the file already exists, if so, delete it
        if (f.exists()) {
            f.delete();
        }

        try {
            // Create a new file in that location for writing
            f.createNewFile();

            outputStream = new FileOutputStream(f, true);
        } catch(Exception e) {
            throw new Exception("Unable to create file and/or create the output stream");
        }
    }

    public FileOutputStream get() {
        return this.outputStream;
    }
}