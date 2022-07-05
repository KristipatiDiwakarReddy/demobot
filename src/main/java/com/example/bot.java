package com.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

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
        return "5524767933:AAHs30_C1x-poRqPBgcSbmei2CdPcFwj0dQ";
    }
    
}
