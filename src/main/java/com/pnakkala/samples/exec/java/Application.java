package com.pnakkala.samples.exec.java;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.URL;

/**
 * Created by phanindra on 27/10/17.
 */
public class Application {
    public Application() {
    }

    public static void main(String[] args) {
        System.out.println("Application is running nicely");
        InputStream in = Application.class.getResourceAsStream("/foo.txt");

        try {
            BufferedReader location = new BufferedReader(new InputStreamReader(in));
            System.out.println(location.readLine());
        } catch (FileNotFoundException var6) {
            var6.printStackTrace();
        } catch (IOException var7) {
            var7.printStackTrace();
        }

        URL location1 = Application.class.getProtectionDomain().getCodeSource().getLocation();
        String path = location1.getFile().replace("classes/", "") + "bar.txt";

        try {
            FileUtils.copyToFile(Application.class.getResourceAsStream("/foo.txt"), new File(path));
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }
}
