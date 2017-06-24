package com.fleetcycle.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Project {
    
    public Project() {
    }
    
    private static Project project;
    
    public static Project getInstance() {
        if (project == null) {
            project = new Project();
        }
        return project;
    }
    
    private String browser = readProfFile().getProperty("browser");
    private String url = readProfFile().getProperty("url");
    private String userName = readProfFile().getProperty("userName");
    private String password = readProfFile().getProperty("password");
    private String iUserName = readProfFile().getProperty("iUserName");
    private String iPassword = readProfFile().getProperty("iPassword");

    /**
     * @return the browser
     */
    public String getBrowser() {
        return browser;
    }
    
    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the iUserName
     */
    public String getiUserName() {
        return iUserName;
    }

    /**
     * @return the iPassword
     */
    public String getiPassword() {
        return iPassword;
    }

    public Properties readProfFile() {
        File file = new File(".//src/resource//TestData//config.properties");
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties properties = new Properties();
        try {
            properties.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
