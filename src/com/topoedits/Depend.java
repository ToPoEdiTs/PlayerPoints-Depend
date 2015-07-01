package com.topoedits;

import java.util.logging.Logger;
import org.black_ixx.playerpoints.PlayerPoints;
import org.black_ixx.playerpoints.PlayerPointsAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Depend extends JavaPlugin implements Listener {
  public void onEnable() {
    saveDefaultConfig();
    getLogger().info("===========================");
    getLogger().info("Plugin: PlayerPoints Depend");
    getLogger().info("Version: 1.0 BETA");
    getLogger().info("Support: topoedits@tolexdevs.es");
    getLogger().info("===========================");
    getServer().getPluginManager().registerEvents(this, this);
  }
  
  public boolean onCommand(CommandSender sender, Command comando, String label, String[] args) {
    Player player = (Player)sender;
    PlayerPointsAPI pp = ((PlayerPoints)Bukkit.getServer().getPluginManager().getPlugin("PlayerPoints")).getAPI();
    if (comando.getName().equalsIgnoreCase("myxp")) {
      player.sendMessage(getConfig().getString("Coins.have") + " " + pp.look(player.getDisplayName()) + " " + getConfig().getString("Coins.prefix"));
    }
    return false;
  }
  
  @EventHandler
  public void matar(EntityDeathEvent e) {
    if ((e.getEntity() instanceof Player)) {
      Player m = (Player)e.getEntity();
      if ((m.getKiller() instanceof Player)) {
        Player p = m.getKiller();
        darXP(p, 1);
      }
    }
  }
  
  public void darXP(Player jugador, int i) {
    PlayerPointsAPI pp = ((PlayerPoints)Bukkit.getServer().getPluginManager().getPlugin("PlayerPoints")).getAPI();
    if (jugador.hasPermission("multiplicator.vip.x2")) {
      pp.give(jugador.getName(), 6);
      jugador.sendMessage(ChatColor.WHITE + "+6 " + ChatColor.GREEN + getConfig().getString("Coins.kill"));
    
  }
}

