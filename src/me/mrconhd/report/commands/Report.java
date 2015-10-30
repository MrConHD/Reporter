package me.mrconhd.report.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Report implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("report")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("staff.report")) {
                    if (args.length >= 2) {
                        StringBuilder stbr = new StringBuilder();
                        Player target = Bukkit.getPlayer(args[0]);
                        String reporter = p.getName();
                        if (target != null && target.getName() != p.getName()) {
                            for (int i = 1; i < args.length; i++) {
                              stbr.append(args[i] + " ");
                                
                            }
                                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cTotalPvP&8>> &7Thank you for reporting &b" +target.getName()));
                                    Bukkit.getServer().broadcast(ChatColor.translateAlternateColorCodes('&', "&4&lREPORT: &c" + target.getName() + "&7 has been reported by &c" + reporter + " &7for &c" + stbr.toString()), "staff.report.announce");
                        } else {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&lERROR: &cThat player cannot be found!"));
                        }
                    } else {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&4ERROR: &cUsage - /report <player> <reason>"));
                    }
                } else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&4ERROR: &cYou do not have permissions to run this command!"));
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&4ERROR: &cYou must be a player to use this command!"));
            }
        }

        return false;
    }
}
