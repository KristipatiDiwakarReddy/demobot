package com.example.Plugins;

import org.telegram.telegrambots.meta.api.objects.Update;

import com.example.Master;
import com.example.bot;

// Start Plugin
public class start extends bot implements Master {

    @Override
    public void handleRequest(Update update, String cmd) {
        if(cmd.equals("/start")) {
            sendMessage(update, "Hi Welcome to Bill Splitter Bot!\n\nStart Splitting your bills by - /split");
        }
        
    }
    
}
