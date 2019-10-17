package me.tyler.glow.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class GlowCommand implements CommandExecutor {

    private ArrayList<Player> glowing_players = new ArrayList<>();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("glow.command")) {

                if (args.length == 0) {

                    if (!glowing_players.contains(player)) {

                        player.setGlowing(true);
                        player.sendMessage(ChatColor.DARK_PURPLE + "You are now glowing");
                        glowing_players.add(player);
                        return true;

                    } else if (glowing_players.contains(player)) {

                        player.setGlowing(false);
                        player.sendMessage(ChatColor.DARK_PURPLE + "You are no longer glowing");
                        glowing_players.remove(player);
                        return true;

                    }
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target != null) {
                        if (!glowing_players.contains(target)) {

                            target.setGlowing(true);
                            target.sendMessage( ChatColor.LIGHT_PURPLE + player.getName() + " Gave you a glowing spell!");
                            glowing_players.add(target);
                            return false;

                        } else if(glowing_players.contains(target)) {

                            target.setGlowing(false);
                            target.sendMessage(ChatColor.LIGHT_PURPLE + "Your glowing spell wore off");
                            glowing_players.remove(target);
                            return false;

                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "That player doesn't exist!");
                        return true;
                    }
                } else {
                    return false;
                }
            } else {
                player.sendMessage("I'm sorry but I can't do that, " + player.getName());
                return true;
            }
        } else {
            sender.sendMessage("Must be run by a player!");
            return false;
        }
        return false;
    }
}
