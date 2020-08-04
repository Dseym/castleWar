package castleWar;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class scoreboardManager {
	
	Scoreboard sb;
	Objective obj;
	Player p;
	
	@SuppressWarnings("deprecation")
	scoreboardManager(Player p) {
		
		sb = Bukkit.getScoreboardManager().getNewScoreboard();
		
		obj = sb.registerNewObjective("game", "dummy");
		
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName("CastleWar");
		
		this.p = p;
		
		this.p.setScoreboard(sb);
		
	}
	
	void reload() {
		
		for(String str: sb.getEntries()) {
			
			sb.resetScores(str);
			
		}
		
		obj.getScore("Монет: " + staticVar.moneyPlayer.get(p.getName())).setScore(1);
		obj.getScore("Доход: " + staticVar.giveMoneyPlayer.get(p.getName())).setScore(0);
		
	}
	
}
