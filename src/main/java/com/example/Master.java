package com.example;

import org.telegram.telegrambots.meta.api.objects.Update;

// Master interface for plugins
public interface Master {
    public void handleRequest(Update update, String cmd);
}
