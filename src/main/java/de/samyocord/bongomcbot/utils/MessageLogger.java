package de.samyocord.bongomcbot.utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MessageLogger {

    public static Date date = new Date();
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static File file = new File("msglogs//messages_"+sdf.format(date)+".log");
    public static File folder = new File("msglogs");
    //public static FileReader fr;
    //public static FileWriter fw;
    public static Logger logger = Logger.getLogger("BongoMC-Bot");


    public static void load(){
        if (!folder.exists()){
            folder.mkdirs();
        }
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileHandler fh;

        try {

            fh = new FileHandler(file.getAbsolutePath());
            logger.addHandler(fh);
            SimpleFormatter f = new SimpleFormatter();
            fh.setFormatter(f);

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void addMessage(String user, String message) throws Exception{
        Date date2 = new Date();
        SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");
        logger.info("[Message]" + sdf2.format(date2) +" : "+user+" : " + message);
    }

    public static void addJoin(String user) throws Exception {
        Date date2 = new Date();
        SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");
        logger.info("[Join] " + sdf2.format(date2) +": "+user);
    }

    public static void addLeave(String user) throws Exception {
        Date date2 = new Date();
        SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");
        logger.info("[Leave] " + sdf2.format(date2) +": "+user);
    }

    public static void addNickChange(String user, String oldNickname, String newNickname) throws Exception {
        Date date2 = new Date();
        SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");
        logger.info("[Nick-Change] " + sdf2.format(date2) +": "+user+" : "+oldNickname + " --> " + newNickname);
    }

}
