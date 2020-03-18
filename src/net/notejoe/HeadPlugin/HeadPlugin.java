package net.notejoe.HeadPlugin;

import org.bukkit.plugin.java.JavaPlugin;

import net.notejoe.HeadPlugin.commands.HeadCommand;
import net.notejoe.HeadPlugin.listeners.PlayerDeathListener;

public class HeadPlugin extends JavaPlugin {
	
	//
	public static String no_perms = "§cNie masz uprawnien!";
	public static String no_args = "§cNie ma takiego argumentu!";
	public static String no_player = "§cNie jestes graczem!";
	//
	
	public void onEnable() {
		System.out.println("*************************");
		System.out.println("*	Simple HeadPlugin by notejoe");
		System.out.println("*	https://github.com/notejoe");
		System.out.println("*************************");
		getCommands();
		getListeners();
	}
	
	public void getCommands() {
		this.getCommand("head").setExecutor(new HeadCommand());
	}
	public void getListeners() {
		getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
	}

}
