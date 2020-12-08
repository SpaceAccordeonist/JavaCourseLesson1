package ru.spaceaccordeonist.task18_13;

import java.io.File;

public class CompressingTask implements Runnable{
    private File[] files;
    private int rate;
    public CompressingTask(File[] files, int rate){
        this.files = files;
        if(files == null){
            this.files = new File[0];
        }
        this.rate = rate == 0 ? 2 : rate;
    }
    @Override
    public void run() {
        for(File file: files){
            Main.compressImage(file, rate);
        }
    }
}
