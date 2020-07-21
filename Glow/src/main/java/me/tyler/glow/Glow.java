package me.tyler.glow;

import me.tyler.glow.commands.GlowCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Glow extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("glow").setExecutor(new GlowCommand());
        System.out.println("Glow is enabled");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Glow is disabled");
    }
}
