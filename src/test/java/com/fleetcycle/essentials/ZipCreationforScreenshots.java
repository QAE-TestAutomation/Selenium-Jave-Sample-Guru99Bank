package com.fleetcycle.essentials;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCreationforScreenshots extends Util {

  List<String> filesListInDir = new ArrayList<String>();
  
  /**
   * Main Method.
   * @param args args
   */
  public static void main(String[] args) {
    /*
     * System.out.println(ScreenShotsFolder); File dir = new File(ScreenShotsFolder); String
     * zipDirName = ScreenShotsFolder+".zip"; //zipSingleFile(file, zipFileName);
     * ZipCreationforScreenshots zipFiles = new ZipCreationforScreenshots();
     * zipFiles.zipDirectory(dir, zipDirName);
     */
  }
  
  /**
   * Zip result folder.
   */
  public void zipResultOutput() {
    File dir = new File(STRDIRECTORY);
    String zipDirName = STRDIRECTORY + ".zip";
    // zipSingleFile(file, zipFileName);
    ZipCreationforScreenshots zipFiles = new ZipCreationforScreenshots();
    zipFiles.zipDirectory(dir, zipDirName);
  }
  
  /**
   * Zip screenshot folder.
   */
  public void zipScreenshots() {
    // System.out.println(ScreenShotsFolder);
    File dir = new File(SCREENSHOTFOLDER);
    String zipDirName = SCREENSHOTFOLDER + ".zip";
    // zipSingleFile(file, zipFileName);
    ZipCreationforScreenshots zipFiles = new ZipCreationforScreenshots();
    zipFiles.zipDirectory(dir, zipDirName);
  }

  /**
   * This method zips the directory.
   * @param dir dir
   * @param zipDirName zipDirName
   */
  private void zipDirectory(File dir, String zipDirName) {
    try {
      populateFilesList(dir);
      // now zip files one by one
      // create ZipOutputStream to write to the zip file
      FileOutputStream fos = new FileOutputStream(zipDirName);
      ZipOutputStream zos = new ZipOutputStream(fos);
      for (String filePath : filesListInDir) {
        // System.out.println("Zipping "+filePath);
        // for ZipEntry we need to keep only relative file path, so we used substring on absolute
        // path
        ZipEntry ze = new ZipEntry(
            filePath.substring(dir.getAbsolutePath().length() + 1, filePath.length()));
        zos.putNextEntry(ze);
        // read the file and write to ZipOutputStream
        FileInputStream fis = new FileInputStream(filePath);
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) > 0) {
          zos.write(buffer, 0, len);
        }
        zos.closeEntry();
        fis.close();
      }
      zos.close();
      fos.close();
      System.out.println("Zipping of Screenshots is Done");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * This method populates all the files in a directory to a List.
   * @param dir dir 
   * @throws IOException IOException
   */
  private void populateFilesList(File dir) throws IOException {
    File[] files = dir.listFiles();
    for (File file : files) {
      if (file.isFile()) {
        filesListInDir.add(file.getAbsolutePath());
      } else {
        populateFilesList(file);
      }
    }
  }

}
