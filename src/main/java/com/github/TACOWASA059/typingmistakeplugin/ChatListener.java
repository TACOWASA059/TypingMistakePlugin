package com.github.TACOWASA059.typingmistakeplugin;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        if(!TypingMistakePlugin.Status)return;
        // チャットメッセージを取得
        String message = event.getMessage();
        // チャットメッセージを処理する
        String romajiText = TypingMistakePlugin.plugin.convertProcess.convertToRomaji(message);

        // タイプミスを模倣する
        String typoText = TypingMistakePlugin.plugin.convertProcess.simulateTypo(romajiText);
        // 日本語に変換する
        String correctedText = TypingMistakePlugin.plugin.convertProcess.convertToJapanese(typoText);
        // 処理されたチャットメッセージを送信

        String key = "<"+event.getPlayer().getName()+"> "+correctedText;
        String value=message;
        BaseComponent[] components = new ComponentBuilder(key).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(value).create())).create();
        Bukkit.broadcast(components);
        //event.setMessage(correctedText);

        //イベントのキャンセル
        event.setCancelled(true);
    }
}
