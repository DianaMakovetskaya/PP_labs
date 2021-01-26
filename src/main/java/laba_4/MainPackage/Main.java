
package laba_4.MainPackage;
import laba_4.MailPackage.SendMail;
import laba_4.MenuPackage.Menu.Menu;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Main {

    static public Logger LOGGER;
    static public FileHandler fileHandler;
    static public SendMail sendMail;

    public static void main(String[] args) {

        try {
            sendMail=new SendMail();
            LOGGER = Logger.getLogger(Main.class.getName());
            fileHandler =new FileHandler("D:\\Палітєх\\2 курс\\1 семестр\\ПП\\logFile.log");
            LOGGER.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);

            LOGGER.info("Start program");
            Menu menu = new Menu();
            menu.Start();
        } catch (NullPointerException | IOException e) {
            System.out.println(" Exiting...");
            sendMail.send(e.toString());
        }

    }
}

