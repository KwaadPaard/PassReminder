package com.brainacad.passwordReminder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Properties;
import java.util.Scanner;
import static com.brainacad.passwordReminder.Lang.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Record> records = new ArrayList<>();
        String configFile = "PassReminder.config";

        Properties settings = new Properties();
        try(FileInputStream fisConfig = new FileInputStream(configFile)){
            settings.load(fisConfig);
            String language = settings.getProperty("language");
            System.out.println(language);
            Properties prop = new Properties();
            try(FileInputStream fisLanguage = new FileInputStream(language+".lang")){
                prop.load(fisLanguage);
                prop.getProperty("language");
                String menu= prop.getProperty("MENU");
                System.out.println(menu);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }catch(IOException e){
            e.printStackTrace();
        }


        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println(MENU);
            System.out.println(DEFAULT_TEXT);
            int intMenu = scanner.nextInt();
            switch (intMenu) {
                case 1:
                    if(records.size()==0){
                        System.out.println(USERS_EMPTY);
                    }
                    else {
                        Util.printRecords(records);
                    }
                    break;
                case 2:
                    System.out.println(ENTER_SITE);
                    String site = scanner.next();
                    System.out.println(ENTER_LOGIN);
                    String login = scanner.next();
                    String password = null;
                    System.out.println(PASSWORD_SELECT);
                    if(scanner.next().toUpperCase().equals("Y")){
                        System.out.println(PASSWORD_LENGTH);
                        int quantity = scanner.nextInt();
                        StringBuffer sb = new StringBuffer(quantity);
                        for (int i = 0; i < quantity; i ++) {
                            sb.append(RandomService.getRandomSymbol());
                        }
                        password = sb.toString();
                    }
                    else {
                        System.out.println(PASSWORD+'=');
                        password = scanner.next();
                    }

                    records.add(new Record(site,login,password));
                    System.out.println(ADD_SUCCESSFUL);
                    records.sort(new Comparator<Record>() {
                        @Override
                        public int compare(Record o1, Record o2) {
                            return o1.getSite().compareTo(o2.getSite());

                        }
                    });
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println(DEFAULT_TEXT);
            }
        }
    }
}
