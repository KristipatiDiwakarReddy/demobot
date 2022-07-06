package com.example.Plugins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.telegram.telegrambots.meta.api.objects.Update;
import com.example.Master;
import com.example.bot;

// split Plugin
public class split extends bot implements Master {
    List<String> names = new ArrayList<>();
    List<Double> bills = new ArrayList<>();

    @Override
    public void handleRequest(Update update, String cmd) {
        if(cmd.equals("/split")) {
            sendMessage(update, "Enter the name of 1st, 2nd & 3rd Person\nExample : Aaryan, Anshu, Garima\n\nNote :- Each names should be separated by ','");
        }
        // Check for names
        if(!cmd.startsWith("/") && cmd.contains(",")) {
            // if Number (Bill Amount)
            if(Character.isDigit(cmd.split(",")[0].charAt(0))) {
                List<String> b = Arrays.asList(cmd.split(","));
                for (String s : b) {
                    bills.add(Double.parseDouble(s)); // String to double
                    System.out.println(s); // Print Bill
                }
                splitBill(update);
            }
            // if Character (Name) 
            if(Character.isAlphabetic(cmd.split(",")[0].charAt(0))) {
                names = Arrays.asList(cmd.split(","));
                for (String name : names) {
                    System.out.println(name); // Print Name
                }
                sendMessage(update, "Enter how much each spent \nExample : 100, 200, 300\n\nNote :- Each names should be separated by ','");
            }
        }
    }

    public void splitBill(Update update) {
        String text = ".... Bill Splitted ..... \n\n";
        sendMessage(update, text);
    }
    
}
