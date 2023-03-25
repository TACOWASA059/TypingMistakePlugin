package com.github.TACOWASA059.typingmistakeplugin;

import com.github.TACOWASA059.typingmistakeplugin.commands.SettinTabCompleter;
import com.github.TACOWASA059.typingmistakeplugin.commands.SettingCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class TypingMistakePlugin extends JavaPlugin {
    public static boolean Status=false;
    public ConvertProcess convertProcess;
    public static TypingMistakePlugin plugin;
    public RomajiToHiraganaConverter romajiToHiraganaConverter;
    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        convertProcess=new ConvertProcess();
        romajiToHiraganaConverter=new RomajiToHiraganaConverter();
        plugin=this;

        getServer().getPluginManager().registerEvents(new ChatListener(), this);
        getCommand("typo").setExecutor(new SettingCommand());
        getCommand("typo").setTabCompleter(new SettinTabCompleter());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
