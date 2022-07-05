package com.example;

import org.glassfish.jersey.message.internal.Token;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvBuilder;

public class bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
        //SendMessage sm  = new SendMessage(update.getMessage().getChatId().toString(), "Hi, Welcome to Splitter Bot!!\nI can Split your Bills");
    
        if(update.getMessage().getText().equals("/start"))
        {
            SendMessage sm  = new SendMessage(update.getMessage().getChatId().toString(), "Hi, Welcome to Splitter Bot!!\nI can Split your Bills\nEnter the number of people");
            try {
                execute(sm);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public String getBotUsername() {
        return "@BillSpitterBot";
    }

    @Override
    public String getBotToken() {
        Dotenv env = new DotenvBuilder().load();
        return env.get("token");
    }
    
}
