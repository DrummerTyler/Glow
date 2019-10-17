package me.tyler.glow.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class GlowCommand implements CommandExecutor {

    private ArrayList<Player> glowing_players = new ArrayList<Player>();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("glow.command")){
                if(args.length == 0){
                    if(!glowing_players.contains(player)){
                        player.setGlowing(true);
                        player.sendMessage("You Are Now Glowing");
                        glowing_players.add(player);
                    }else if(glowing_players.contains(player)){
                        player.setGlowing(false);
                        player.sendMessage("You Are No Longer Glowing");
                        glowing_players.remove(player);
                    }
                }else{
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if(target != null){
                        if(!glowing_players.contains(target)){
                            target.setGlowing(true);
                            target.sendMessage( player + " Gave U A Glowing Spell");
                            glowing_players.add(target);
                        }else if(glowing_players.contains(target)){
                            target.setGlowing(false);
                            target.sendMessage("Your Glowing Spell Wore Off");
                            glowing_players.remove(target);
                        }
                    }else{
                        player.sendMessage("That Player Doesn't Exist");
                    }
                }
            }else{
                player.sendMessage("You Do Not Have The Required Permission");
            }
        }else{
            System.out.println("You Need To Be A Player");
        }

        return true;
    }
}
