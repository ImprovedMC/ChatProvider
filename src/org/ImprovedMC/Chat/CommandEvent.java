package org.ImprovedMC.Chat;

import org.ImprovedMC.MainClass;
import org.ImprovedMC.Until.pluginException;
import org.ImprovedMC.Lang.LangStr;
import org.ImprovedMC.Until.Perm;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandEvent implements Listener{

	private MainClass mClass;

	public CommandEvent(MainClass mClass){
		this.mClass = mClass;
	}
	
	@EventHandler
	public void onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent e){
		String msg = e.getMessage();
		String[] msga = msg.split(" ");
		Player p = e.getPlayer();
		String argsmsg = "";
		String[] args = argsmsg.split(" ");
		for(int i = 1; i < msga.length; i++){
			argsmsg += msga[i];
		}
		
		
		if(msg.equalsIgnoreCase("//clear")){
			if (mClass.hasPerm(p, Perm.ChatProvider_Clear_Global())) {
				if(args.length == 1){
					if(args[0].equalsIgnoreCase("local")){
						for (int i = 0; i < 120; i++) {
							p.sendMessage(" ");
							if (i == 119) {
								p.sendMessage(LangStr.LOCAL_CHAT_CLEARED());
							}
						}
						e.setCancelled(true);
					} else {
						Player[] allTargets;
						int i = (allTargets = mClass.getServer().getOnlinePlayers()).length;
						for (int j = 0; j < i; j++) {
							Player targetPlayer = allTargets[j];
							for (int k = 0; k < 120; k++) {
								targetPlayer.sendMessage(" ");
								if (k == 119) {
									targetPlayer.sendMessage(LangStr.GLOBAL_CHAT_CLEARED(p));
								}
							}
						}
						e.setCancelled(true);
					}
				} else {			
					Player[] allTargets;
					int i = (allTargets = mClass.getServer().getOnlinePlayers()).length;
					for (int j = 0; j < i; j++) {
						Player targetPlayer = allTargets[j];
						for (int k = 0; k < 120; k++) {
							targetPlayer.sendMessage(" ");
							if (k == 119) {
								targetPlayer.sendMessage(LangStr.GLOBAL_CHAT_CLEARED(p));
							}
						}
					}
					e.setCancelled(true);
				}
			} else {
				if(mClass.hasPerm(p, Perm.ChatProvider_Clear_Local())){
					for (int i = 0; i < 120; i++) {
						p.sendMessage(" ");
						if (i == 119) {
							p.sendMessage(LangStr.LOCAL_CHAT_CLEARED());
						}
					}
					e.setCancelled(true);
				} else {
					p.sendMessage(LangStr.NO_PERMISSIONS_EXCEPTION("c"));
				}
			}
			
		} else {

		}
	}
	
}
