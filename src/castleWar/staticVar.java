package castleWar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Creature;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class staticVar {
	
	static main plugin;
	static List<String> commands = new ArrayList<String>();
	static Map<String, Location> spawnPlayer = new HashMap<String, Location>();
	static Map<String, Location> spawnsMob = new HashMap<String, Location>();
	static Map<String, LivingEntity> pointComm = new HashMap<String, LivingEntity>();
	static Map<String, Player> playerCommand = new HashMap<String, Player>();
	static Map<Creature, LivingEntity> mobs = new HashMap<Creature, LivingEntity>();
	static Map<String, Integer> moneyPlayer = new HashMap<String, Integer>();
	static Map<String, Integer> giveMoneyPlayer = new HashMap<String, Integer>();
	static Map<String, scoreboardManager> scoreboard = new HashMap<String, scoreboardManager>();
	static Map<Creature, String> commandMobs = new HashMap<Creature, String>();

	
	static String setSpawnMob(String command, Location loc) {
		
		if(commands.contains(command)) {
			
			spawnsMob.put(command, loc);
			
		} else {
			
			return "Такой команды не существует";
			
		}
		
		return "Успешно задано";
		
	}
	
	static String setPoint(String command, Location loc) {
		
		if(commands.contains(command)) {
			
			LivingEntity ent = (LivingEntity)loc.getWorld().spawnEntity(loc, EntityType.VILLAGER);
			ent.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999, 10));
			pointComm.put(command, ent);
			
		} else {
			
			return "Такой команды не существует";
			
		}
		
		return "Успешно задано";
		
	}
	
	static String createCommand(String command, Location loc) {
		
		if(!commands.contains(command)) {
			
			commands.add(command);
			spawnPlayer.put(command, loc);
			
		} else {
			
			return "Такая команда уже существует";
			
		}
		
		return "Успешно создано";
		
	}
	
	static Creature spawnMob(EntityType ent, LivingEntity target, String command, int cost, String name) {
		
		if(staticVar.moneyPlayer.get(name) < cost) {
			
			Bukkit.getPlayer(name).sendMessage(main.tagPlugin + "Не хватает монет");
			return null;
			
		} else {
			
			Creature mob = (Creature)target.getLocation().getWorld().spawnEntity(staticVar.spawnsMob.get(command), ent);
			mobs.put(mob, target);
			mob.setTarget(target);
			staticVar.moneyPlayer.replace(name, staticVar.moneyPlayer.get(name) - cost);
			staticVar.giveMoneyPlayer.replace(name, staticVar.giveMoneyPlayer.get(name) + (int)Math.round(cost/10));
			return mob;
			
		}
		
	}
	
}
