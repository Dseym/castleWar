package castleWar;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Creature;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class event implements Listener {

	Inventory shop;
	List<Integer> cost = new ArrayList<Integer>();
	List<Integer> price = new ArrayList<Integer>();
	
	event() {
		
		cost.add(10);
		cost.add(15);
		cost.add(5);
		cost.add(20);
		cost.add(15);
		cost.add(25);
		cost.add(25);
		cost.add(20);
		cost.add(35);
		cost.add(25);
		cost.add(20);
		cost.add(30);
		
		for(int i: cost) {
			
			price.add((int)Math.round(i/10));
			
		}
		
		shop = Bukkit.createInventory(null, 36, "Мобы");
		ItemStack egg = new ItemStack(Material.ZOMBIE_SPAWN_EGG);
		ItemMeta meta = egg.getItemMeta();
		List<String> lore = new ArrayList<String>();
		lore.add(cost.get(0) + " монет");
		lore.add("Доход +" + price.get(0));
		meta.setLore(lore);
		meta.setDisplayName("Зомби");
		egg.setItemMeta(meta);
		shop.setItem(10, egg);
		egg = new ItemStack(Material.SKELETON_SPAWN_EGG);
		lore = new ArrayList<String>();
		lore.add(cost.get(1) + " монет");
		lore.add("Доход +" + price.get(1));
		meta.setLore(lore);
		meta.setDisplayName("Скелет");
		egg.setItemMeta(meta);
		shop.setItem(11, egg);
		egg = new ItemStack(Material.SILVERFISH_SPAWN_EGG);
		lore = new ArrayList<String>();
		lore.add(cost.get(2) + " монет");
		lore.add("Доход +" + price.get(2));
		meta.setLore(lore);
		meta.setDisplayName("Мышь");
		egg.setItemMeta(meta);
		shop.setItem(12, egg);
		egg = new ItemStack(Material.CREEPER_SPAWN_EGG);
		lore = new ArrayList<String>();
		lore.add(cost.get(3) + " монет");
		lore.add("Доход +" + price.get(3));
		meta.setLore(lore);
		meta.setDisplayName("Крипер");
		egg.setItemMeta(meta);
		shop.setItem(13, egg);
		egg = new ItemStack(Material.HUSK_SPAWN_EGG);
		lore = new ArrayList<String>();
		lore.add(cost.get(4) + " монет");
		lore.add("Доход +" + price.get(4));
		meta.setLore(lore);
		meta.setDisplayName("Засохший зомби");
		egg.setItemMeta(meta);
		shop.setItem(14, egg);
		egg = new ItemStack(Material.WITHER_SKELETON_SPAWN_EGG);
		lore = new ArrayList<String>();
		lore.add(cost.get(5) + " монет");
		lore.add("Доход +" + price.get(5));
		meta.setLore(lore);
		meta.setDisplayName("Засохший скелет");
		egg.setItemMeta(meta);
		shop.setItem(15, egg);
		egg = new ItemStack(Material.WITCH_SPAWN_EGG);
		lore = new ArrayList<String>();
		lore.add(cost.get(6) + " монет");
		lore.add("Доход +" + price.get(6));
		meta.setLore(lore);
		meta.setDisplayName("Ведьма");
		egg.setItemMeta(meta);
		shop.setItem(16, egg);
		egg = new ItemStack(Material.ENDERMAN_SPAWN_EGG);
		lore = new ArrayList<String>();
		lore.add(cost.get(7) + " монет");
		lore.add("Доход +" + price.get(7));
		meta.setLore(lore);
		meta.setDisplayName("Ендермен");
		egg.setItemMeta(meta);
		shop.setItem(20, egg);
		egg = new ItemStack(Material.WOLF_SPAWN_EGG);
		lore = new ArrayList<String>();
		lore.add(cost.get(8) + " монет");
		lore.add("Доход +" + price.get(8));
		meta.setLore(lore);
		meta.setDisplayName("Вампир");
		egg.setItemMeta(meta);
		shop.setItem(21, egg);
		egg = new ItemStack(Material.SPIDER_SPAWN_EGG);
		lore = new ArrayList<String>();
		lore.add(cost.get(9) + " монет");
		lore.add("Доход +" + price.get(9));
		meta.setLore(lore);
		meta.setDisplayName("Паук");
		egg.setItemMeta(meta);
		shop.setItem(22, egg);
		egg = new ItemStack(Material.CAVE_SPIDER_SPAWN_EGG);
		lore = new ArrayList<String>();
		lore.add(cost.get(10) + " монет");
		lore.add("Доход +" + price.get(10));
		meta.setLore(lore);
		meta.setDisplayName("Пещерный паук");
		egg.setItemMeta(meta);
		shop.setItem(23, egg);
		egg = new ItemStack(Material.BLAZE_SPAWN_EGG);
		lore = new ArrayList<String>();
		lore.add(cost.get(11) + " монет");
		lore.add("Доход +" + price.get(11));
		meta.setLore(lore);
		meta.setDisplayName("Блейз");
		egg.setItemMeta(meta);
		shop.setItem(24, egg);
		
	}
	
	@EventHandler
	void isPlayerPressOnItem(PlayerInteractEvent e) {
		
		if(e.getMaterial() == Material.SNOWBALL) {
			
			e.getPlayer().openInventory(shop);
			
			e.setCancelled(true);
			
		}
		
	}
	
	String randomCommand(Player p) {
		
		String command = staticVar.commands.get((int)Math.floor(Math.random() * staticVar.commands.toArray().length));
		
		if(staticVar.playerCommand.get(command) == p) {
			
			return randomCommand(p);
			
		} else {
		
			return command;
		
		}
		
	}
	
	@EventHandler
	void isPlayerBuyMob(InventoryClickEvent e) {
		
		String randomCommand = randomCommand((Player)e.getWhoClicked());
		LivingEntity target = staticVar.pointComm.get(randomCommand);
		Creature mob = null;
		
		String command = "";
		
		for(String key: staticVar.playerCommand.keySet()) {
			
			if(staticVar.playerCommand.get(key) == e.getWhoClicked()) {
				
				command = key;
				break;
				
			}
			
		}
		
		try {
			
			switch(e.getCurrentItem().getType()) {
			
				case ZOMBIE_SPAWN_EGG:
					
					mob = staticVar.spawnMob(EntityType.ZOMBIE, target, command, cost.get(0), e.getWhoClicked().getName());
					e.setCancelled(true);
					
				break;
				
				case SKELETON_SPAWN_EGG:
					mob = staticVar.spawnMob(EntityType.SKELETON, target, command, cost.get(1), e.getWhoClicked().getName());
					e.setCancelled(true);
					
				break;
				
				case SILVERFISH_SPAWN_EGG:
					mob = staticVar.spawnMob(EntityType.SILVERFISH, target, command, cost.get(2), e.getWhoClicked().getName());
					e.setCancelled(true);
					
				break;
				
				case CREEPER_SPAWN_EGG:
					mob = staticVar.spawnMob(EntityType.CREEPER, target, command, cost.get(3), e.getWhoClicked().getName());
					e.setCancelled(true);
					
				break;
				
				case HUSK_SPAWN_EGG:
					mob = staticVar.spawnMob(EntityType.HUSK, target, command, cost.get(4), e.getWhoClicked().getName());
					e.setCancelled(true);
					
				break;
				
				case WITHER_SKELETON_SPAWN_EGG:
					mob = staticVar.spawnMob(EntityType.WITHER_SKELETON, target, command, cost.get(5), e.getWhoClicked().getName());
					e.setCancelled(true);
					
				break;
				
				case WITCH_SPAWN_EGG:
					mob = staticVar.spawnMob(EntityType.WITCH, target, command, cost.get(6), e.getWhoClicked().getName());
					e.setCancelled(true);
					
				break;
				
				case ENDERMAN_SPAWN_EGG:
					mob = staticVar.spawnMob(EntityType.ENDERMAN, target, command, cost.get(7), e.getWhoClicked().getName());
					e.setCancelled(true);
					
				break;
				
				case WOLF_SPAWN_EGG:
					mob = staticVar.spawnMob(EntityType.WOLF, target, command, cost.get(8), e.getWhoClicked().getName());
					e.setCancelled(true);
					
				break;
				
				case SPIDER_SPAWN_EGG:
					mob = staticVar.spawnMob(EntityType.SPIDER, target, command, cost.get(9), e.getWhoClicked().getName());
					e.setCancelled(true);
					
				break;
				
				case CAVE_SPIDER_SPAWN_EGG:
					mob = staticVar.spawnMob(EntityType.CAVE_SPIDER, target, command, cost.get(10), e.getWhoClicked().getName());
					e.setCancelled(true);
					
				break;
				
				case BLAZE_SPAWN_EGG:
					mob = staticVar.spawnMob(EntityType.BLAZE, target, command, cost.get(11), e.getWhoClicked().getName());
					e.setCancelled(true);
					
				break;

				
				default:
					
					break;
					
			}
			
			if(mob == null) {
				
				return;
				
			}
			
			staticVar.commandMobs.put(mob, command);
			
		} catch (Exception e1) {}
		
	}
	
	@EventHandler
	void isVillagerGetDamage(EntityDamageEvent e) {
		
		for(String key: staticVar.pointComm.keySet()) {
			
			if(staticVar.pointComm.get(key) == e.getEntity()) {
				
				staticVar.playerCommand.get(key).sendMessage(main.tagPlugin + "Вы проиграли");
				staticVar.commands.remove(key);
				
				if(staticVar.commands.toArray().length < 2) {
					
					staticVar.playerCommand.get(staticVar.commands.get(0)).sendMessage(main.tagPlugin + "Вы победили!");
					Bukkit.getPluginManager().disablePlugin(staticVar.plugin);
					
				}
				
				e.setCancelled(true);
				
			}
			
		}
		
	}
	
	@EventHandler
	void isMobDead(EntityDeathEvent e) {
		
		if(staticVar.mobs.containsKey(e.getEntity())) {
			
			staticVar.mobs.remove(e.getEntity());
			
		}
		
	}
	
}
