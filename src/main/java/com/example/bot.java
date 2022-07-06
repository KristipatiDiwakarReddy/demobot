package com.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.example.Plugins.split;
import com.example.Plugins.start;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvBuilder;

public class bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        // if Message ;;
        if(update.hasMessage()) {
            String cmd = update.getMessage().getText();
            new start().handleRequest(update, cmd);
            new split().handleRequest(update, cmd);
        }

    }

    // Send Message Method 
    public void sendMessage(Update update, String text) {
        String chatId = update.getMessage().getChatId().toString();
        SendMessage msg = new SendMessage(chatId, text);

        try {
            execute(msg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
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
