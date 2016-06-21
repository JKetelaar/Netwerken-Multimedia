package edu.avans.netmul.task.two;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class VideoStream {

    FileInputStream fis; //video file
    int frame_nb; //current frame nb

    //-----------------------------------
    //constructor
    //-----------------------------------
    public VideoStream(String filename) throws Exception {

        //init variables

        System.out.println(filename);
        fis = new FileInputStream(getFile(filename));
        frame_nb = 0;
    }

    //-----------------------------------
    // getnextframe
    //returns the next frame as an array of byte and the size of the frame
    //-----------------------------------
    public int getnextframe(byte[] frame) throws Exception {
        int length = 0;
        String length_string;
        byte[] frame_length = new byte[5];

        //read current frame length
        fis.read(frame_length, 0, 5);

        //transform frame_length to integer
        length_string = new String(frame_length);
        length = Integer.parseInt(length_string);

        return (fis.read(frame, 0, length));
    }

    /**
     * Gathering the file from the resources folder
     *
     * @param fileName
     * @return
     */
    private String getFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile().replace("%20", " "));

        return file.getAbsolutePath();

    }
}