package com.github.TACOWASA059.typingmistakeplugin.commands;

import com.github.TACOWASA059.typingmistakeplugin.TypingMistakePlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SettingCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            Player player=(Player) sender;
            if(!player.isOp()){
                player.sendMessage(ChatColor.RED+"このコマンドを実行する権限がありません。");
            }
            if(args.length==1){
                if(args[0].equalsIgnoreCase("START")){
                    TypingMistakePlugin.Status=true;
                    player.sendMessage(ChatColor.GREEN+"プラグインが有効になりました");
                    return true;
                }
                else if(args[0].equalsIgnoreCase("STOP")){
                    TypingMistakePlugin.Status=false;
                    player.sendMessage(ChatColor.GREEN+"プラグインが無効になりました");
                    return true;
                }
                else if(args[0].equalsIgnoreCase("usage")){
                    player.sendMessage(ChatColor.AQUA+"/typo START"+ChatColor.GREEN+" : プラグインを有効化");
                    player.sendMessage(ChatColor.AQUA+"/typo STOP"+ChatColor.GREEN+" : プラグインを無効化");
                    player.sendMessage(ChatColor.AQUA+"/typo probability <value>"+ChatColor.GREEN+" : 誤字確率を設定");
                    player.sendMessage(ChatColor.AQUA+"/typo usage"+ChatColor.GREEN+" : コマンド一覧表示");
                    return true;
                }
            }
            else if(args.length==2){
                if(args[0].equalsIgnoreCase("probability")){
                    Double value=null;
                    try{
                        value=Double.parseDouble(args[1]);
                        if(value>1.0||value<0){
                            player.sendMessage(ChatColor.RED+"値は1.0以下にしてください");
                            return true;
                        }
                        TypingMistakePlugin.plugin.getConfig().set("probability",value);

                    }
                    catch (NumberFormatException e){
                        player.sendMessage(ChatColor.RED+"値は数値で入力してください");
                        return true;
                    }

                    player.sendMessage(ChatColor.GREEN+"probabilityは"+ChatColor.BLUE+TypingMistakePlugin.plugin.getConfig().getDouble("probability")+ChatColor.GREEN+"に変更されました。");
                    return true;
                }
            }
            player.sendMessage(ChatColor.RED+"引数の指定が間違っています");
        }
        return true;
    }
}
