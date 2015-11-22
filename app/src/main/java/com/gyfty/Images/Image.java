package com.gyfty.Images;

import com.parse.ParseFile;

/**
 * Created by akhilch on 9/6/2015.
 */

// Different Image class definitions using Parsefile

public class Image extends ParseFile {
    public Image(String name, byte[] data, String contentType) {
        super(name, data, contentType);
    }

    public Image(byte[] data) {
        super(data);
    }

    public Image(String name, byte[] data) {
        super(name, data);
    }

    public Image(byte[] data, String contentType) {
        super(data, contentType);
    }

    public void save(){
        saveInBackground();
    }
}
