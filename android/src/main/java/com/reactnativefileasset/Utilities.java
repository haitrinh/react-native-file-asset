package com.reactnativefileasset;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Utilities {
    public static String AssetFileToString(Context context, String fileName) throws Exception
    {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(fileName)));
            StringBuilder sb = new StringBuilder();
            String mLine = reader.readLine();
            while (mLine != null) {
                sb.append(mLine); // process line
                mLine = reader.readLine();
            }
            reader.close();
            return sb.toString();
        }
        catch (Exception err){
            throw err;
        }
    }

    public static String AssetFilePath(Context context, String fileName) throws Exception
    {
        File cacheFile = new File(context.getCacheDir(), fileName);
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            try {
                FileOutputStream outputStream = new FileOutputStream(cacheFile);
                try {
                    byte[] buf = new byte[1024];
                    int length;
                    while ((length = inputStream.read(buf)) > 0) {
                        outputStream.write(buf, 0, length);
                    }
                } finally {
                    outputStream.close();
                }
            } finally {
                inputStream.close();
            }
        } catch (Exception error) {
            throw error;
        }
        return cacheFile.getPath();
    }
}
