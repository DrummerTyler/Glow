package me.tyler.glow;

import me.tyler.glow.Commands.GlowCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Glow extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("glow").setExecutor(new GlowCommand());
        System.out.println("Glow Is Enabled");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Glow Is Disabled");
    }
}
