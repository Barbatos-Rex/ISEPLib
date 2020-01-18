package iseplib.instructions;

import iseplib.classes.FileManager;

import java.io.IOException;

public class Instructions {
    public static void main(String[] args) throws IOException {
        FileManager.mkDir("instructions");
        FileManager.fileCreator("instructions","README","txt");
        FileManager.fileWriter("instructions/README.txt","");

    }

}
