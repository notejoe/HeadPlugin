package net.notejoe.HeadPlugin.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import net.notejoe.HeadPlugin.HeadPlugin;

public class HeadCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

	if(!sender.hasPermission("notejoe.head")) {
		sender.sendMessage(HeadPlugin.no_perms);
	}else{
		if(args.length == 0) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(HeadPlugin.no_player);
				return true;
			}
			Player player = (Player) sender;
			ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);
			SkullMeta meta = (SkullMeta) item.getItemMeta();
			meta.setOwner(player.getName());
			item.setItemMeta(meta);
					
			player.getInventory().addItem(new ItemStack[] {item});
			player.sendMessage("§6Glowa gracza §c" + player.getName() + " §6zostala dodana do twojego ekwipunku!");
				
			}else if(args.length == 1) {
				if(!(sender instanceof Player)) {
					sender.sendMessage(HeadPlugin.no_player);
					return true;
				}
					Player player = (Player) sender;
					String otherPlayer = args[0];
					ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);
					SkullMeta meta = (SkullMeta) item.getItemMeta();
					meta.setOwner(otherPlayer);
					item.setItemMeta(meta);
							
					player.getInventory().addItem(new ItemStack[] {item});
					player.sendMessage("§6Glowa gracza §c" + otherPlayer + " §6zostala dodana do twojego ekwipunku!");
				}else{
					sender.sendMessage("§cPoprawne uzycie: /head <nick>");
				}
		}
	return false;	
	}
}
