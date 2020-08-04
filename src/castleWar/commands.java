package castleWar;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commands implements CommandExecutor {

	static main plugin;
	
	public commands(main main) {

		plugin = main;
		
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(args[0].equalsIgnoreCase("start")) {
			
			start(sender);
			
		} else if(args[0].equalsIgnoreCase("setSpawnMob")) {
			
			sender.sendMessage(main.tagPlugin + staticVar.setSpawnMob(args[1], ((Player)sender).getLocation()));
			
		} else if(args[0].equalsIgnoreCase("setPoint")) {
			
			sender.sendMessage(main.tagPlugin + staticVar.setPoint(args[1], ((Player)sender).getLocation()));
			
		} else if(args[0].equalsIgnoreCase("createCommand")) {
			
			sender.sendMessage(main.tagPlugin + staticVar.createCommand(args[1], ((Player)sender).getLocation()));
			
		} else {
			
			sender.sendMessage(main.tagPlugin + "Что-то пошло не так");
			
		}
		
		return true;
		
	}

	void start(CommandSender sender) {
		
		if(Bukkit.getOnlinePlayers().toArray().length != staticVar.commands.size()) {
			
			sender.sendMessage(main.tagPlugin + "Не хватает игроков");
			return;
			
		}
		Bukkit.getScheduler().runTaskTimer(plugin, new timer(), 20, 40);
		Bukkit.getPluginManager().registerEvents(new event(), staticVar.plugin);
		int i = 0;
		for(Player p: Bukkit.getOnlinePlayers()) {
			
			staticVar.playerCommand.put(staticVar.commands.get(i), p);
			staticVar.moneyPlayer.put(p.getName(), 5);
			staticVar.giveMoneyPlayer.put(p.getName(), 1);
			staticVar.scoreboard.put(p.getName(), new scoreboardManager(p));
			
			i++;
			
		}
		
	}

}
