package com.example.GradingService.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;

public class NotificationService {

private static final String CHAT_ID = "-1001577190792";
    private static final String TOKEN = "5317435312:AAHrHA8-G5Ys0EYRQy7pJjN1pJ99CYn5o9g";

    public static void sendNotification(String message) {
        TelegramBot telegramBot = new TelegramBot(TOKEN);
        telegramBot.execute(new SendMessage(CHAT_ID, message));
    }

}
