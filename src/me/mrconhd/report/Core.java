package me.mrconhd.report;

import me.mrconhd.report.commands.Report;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Connor on 4/27/2015.
 */
public class Core extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginCommand("report").setExecutor(new Report());
    }
}
