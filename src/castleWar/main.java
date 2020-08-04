package castleWar;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;



public class main extends JavaPlugin {

	static String tagPlugin = ChatColor.RESET + "[" + ChatColor.BLUE + "CastleWar" + ChatColor.RESET + "] ";
	
	public void onEnable() {
		
		this.getCommand("castle").setExecutor((CommandExecutor)new commands(this));
		this.getLogger().info("Started!");
		staticVar.plugin = this;
		
	}
	
}
