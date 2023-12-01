package utils;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.util.Properties;

 

public class ReadProperty {

public Properties getProperties()

    {

Properties obj=new Properties();

        FileInputStream objfile;

try {


String path=System.getProperty("user.dir")+"/config/browser.properties";

objfile = new FileInputStream(path);

obj.load(objfile);

} catch (FileNotFoundException e) {

// TODO Auto-generated catch block

e.printStackTrace();

} catch (IOException e) {

// TODO Auto-generated catch block

e.printStackTrace();

}

return obj;

    }

}
