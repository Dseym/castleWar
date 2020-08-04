package castleWar;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Creature;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class timer implements Runnable {
	
	@Override
	public void run() {
		
		for(Creature mob: staticVar.mobs.keySet()) {
			
			mob.setTarget(staticVar.mobs.get(mob));
			
		}
		
		for(Player p: Bukkit.getOnlinePlayers()) {
			
			staticVar.moneyPlayer.replace(p.getName(), staticVar.giveMoneyPlayer.get(p.getName()) + staticVar.moneyPlayer.get(p.getName()));
			staticVar.scoreboard.get(p.getName()).reload();
			
		}
		
		for(LivingEntity mob: staticVar.mobs.keySet()) {
			
			if(mob.getTargetBlock(null, 2).getType() == Material.OAK_DOOR) {
				
				mob.getTargetBlock(null, 2).setType(Material.AIR);
				
			}
			
			
			if(mob.getType() == EntityType.WITCH) {
				
				for(Creature target: staticVar.commandMobs.keySet()) {
					
					if(staticVar.commandMobs.get(target) == staticVar.commandMobs.get(mob)) {
						
						try {
							
							target.setHealth(target.getHealth()+2);
							
						} catch (Exception e) {}
						
					}
					
				}
				
			}
			
			if(mob.getType() == EntityType.WITHER_SKELETON) {
				
				for(Creature target: staticVar.commandMobs.keySet()) {
					
					if(staticVar.commandMobs.get(target) == staticVar.commandMobs.get(mob)) {
						
						target.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2*20, 1));
						
					}
					
					if(staticVar.commandMobs.get(target) != staticVar.commandMobs.get(mob)) {
						
						if(mob.getLocation().distance(target.getLocation()) < 6) {
							
							if(target.getHealth() > 1) {
								
								target.setHealth(target.getHealth()-1);
							
							} else {
								
								target.damage(2);
								
							}
							
						}
						
					}
					
				}
				
			}
			
			if(mob.getType() == EntityType.ENDERMAN) {
				
				for(Creature target: staticVar.commandMobs.keySet()) {
					
					if(staticVar.commandMobs.get(target) != staticVar.commandMobs.get(mob)) {
						
						mob.teleport(target);
						((Creature)mob).setTarget(target);
						try {
							
							mob.setHealth(mob.getHealth()+1);
							
						} catch (Exception e) {}
						break;
						
					}
					
				}
				
			}
			
			if(mob.getType() == EntityType.WOLF) {
				
				for(Creature target: staticVar.commandMobs.keySet()) {
					
					if(staticVar.commandMobs.get(target) != staticVar.commandMobs.get(mob)) {
						
						if(mob.getLocation().distance(target.getLocation()) < 6) {
							
							if(target.getHealth() > 2) {
								
								target.setHealth(target.getHealth()-2);
								try {
									
									mob.setHealth(mob.getHealth()+1);
									
								} catch (Exception e) {}
							
							} else {
								
								target.damage(3);
								
							}
							
						}
						
					}
					
				}
				
			}

			if(mob.getType() == EntityType.SPIDER) {
				
				for(Creature target: staticVar.commandMobs.keySet()) {
					
					if(staticVar.commandMobs.get(target) != staticVar.commandMobs.get(mob)) {
						
						if(mob.getLocation().distance(target.getLocation()) < 6) {
							
							target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1*20, 0));
							
						}
						
					}
					
				}
				
			}
			
			if(mob.getType() == EntityType.CAVE_SPIDER) {
				
				for(Creature target: staticVar.commandMobs.keySet()) {
					
					if(staticVar.commandMobs.get(target) != staticVar.commandMobs.get(mob)) {
						
						if(mob.getLocation().distance(target.getLocation()) < 6) {
							
							if(target.getHealth() > 1) {
								
								target.setHealth(target.getHealth()-2);
							
							} else {
								
								target.damage(3);
								
							}
							
						}
						
					}
					
				}
				
			}
			
			if(mob.getType() == EntityType.BLAZE) {
				
				for(Creature target: staticVar.commandMobs.keySet()) {
					
					if(staticVar.commandMobs.get(target) != staticVar.commandMobs.get(mob)) {
						
						if(mob.getLocation().distance(target.getLocation()) < 11) {
							
							target.setFireTicks(20);
							
						}
						
					}
					
				}
				
			}
			
		}
		
	}
	
}
