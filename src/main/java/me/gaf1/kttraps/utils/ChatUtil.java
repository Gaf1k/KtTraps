package me.gaf1.kttraps.utils;

import me.gaf1.kttraps.Plugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
public class ChatUtil {

    public static void sendMessage(Player player, String msg) {
        player.sendMessage(color(msg));
    }
    public static void sendMessage(CommandSender sender, String msg) {
        sender.sendMessage(color(msg));
    }

    public static void sendConfigMessage(CommandSender sender, String path) {
        sender.sendMessage(color(Plugin.getInstance().getConfig().getString(path)));
    }

    public static void sendConfigMessage(Player recipient, String configPath, Map<String, String> args) {
        String message = Plugin.getInstance().getConfig().getString(configPath);

        for (String key : args.keySet()) {
            message = message.replace(key, args.get(key));
        }

        sendMessage(recipient, message);
    }
    public static void sendConfigBroadcastList(String configPath, Map<String, String> args) {
        List<String> text = Plugin.getInstance().getConfig().getStringList(configPath);

        for (Component component: applyArgs(text,args)) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(component);
            }
        }
    }
    public static void sendConfigBroadcastList(String configPath, Collection<Player> players, Map<String, String> args) {
        List<String> text = Plugin.getInstance().getConfig().getStringList(configPath);

        for (Component component: applyArgs(text,args)) {
            for (Player player : players) {
                player.sendMessage(component);
            }
        }
    }
    public static void sendConfigBroadcastList(String configPath) {
        List<String> text = Plugin.getInstance().getConfig().getStringList(configPath);

        for (String line: text) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                sendMessage(player,line);
            }
        }
    }
    public static void sendConfigMessage(CommandSender recipient, String configPath, Map<String, String> args) {
        String message = Plugin.getInstance().getConfig().getString(configPath);

        for (String key : args.keySet()) {
            message = message.replace(key, args.get(key));
        }

        sendMessage(recipient, message);
    }
    public static List<Component> applyArgs(List<String> text, Map<String, String> args) {
        List<Component> list = new ArrayList<>();
        for (String line : text) {
            for (String arg : args.keySet()) {
                if (line.contains(arg)) {
                    line = line.replace(arg, args.get(arg));
                }
            }

            list.add(color(line));
        }

        return list;
    }

    public static Component color(String value) {
        return LegacyComponentSerializer.legacyAmpersand().deserialize(value).decoration(TextDecoration.ITALIC, false);
    }
}
