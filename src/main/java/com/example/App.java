package com.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class App 
{
    public static void main( String[] args )
    {
        try {
            TelegramBotsApi tApi = new TelegramBotsApi( DefaultBotSession.class);
            tApi.registerBot(new bot());
            System.out.println("Bot Started!");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
