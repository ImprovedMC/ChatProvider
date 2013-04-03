package org.ImprovedMC.Chat;

import org.ImprovedMC.MainClass;
import org.ImprovedMC.Until.pluginException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

<<<<<<< HEAD
=======
@Deprecated
>>>>>>> UPDATE + ADD LANG & TAB API
public class Command_Clear implements CommandExecutor {

	private MainClass mClass;

	public Command_Clear(MainClass mClass) {
		this.mClass = mClass;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (!(sender instanceof Player)) {
			mClass.sendConsole("Commands are only for Players");
			return false;
		}

		Player p = (Player) sender;

		if (mClass.hasPerm(p, "ChatProvider.Clear.Global")) {
			if(args.length == 1){
				if(args[0].equalsIgnoreCase("local")){
					for (int i = 0; i < 120; i++) {
						p.sendMessage(" ");
						if (i == 119) {
							p.sendMessage(mClass.getPrefix()
									+ pluginException.LOCAL_CHAT_CLEARED.msg);
						}
					}
					return true;
				} else {
					Player[] allTargets;
					int i = (allTargets = mClass.getServer().getOnlinePlayers()).length;
					for (int j = 0; j < i; j++) {
						Player targetPlayer = allTargets[j];
						for (int k = 0; k < 120; k++) {
							targetPlayer.sendMessage(" ");
							if (k == 119) {
								targetPlayer.sendMessage(mClass.getPrefix()
										+ pluginException.GLOBAL_CHAT_CLEARED.msg
										+ p.getName());
							}
						}
					}
					return true;
				}
			} else {			
				Player[] allTargets;
				int i = (allTargets = mClass.getServer().getOnlinePlayers()).length;
				for (int j = 0; j < i; j++) {
					Player targetPlayer = allTargets[j];
					for (int k = 0; k < 120; k++) {
						targetPlayer.sendMessage(" ");
						if (k == 119) {
							targetPlayer.sendMessage(mClass.getPrefix()
									+ pluginException.GLOBAL_CHAT_CLEARED.msg
									+ p.getName());
						}
					}
				}
				return true;
			}
		} else {
			for (int i = 0; i < 120; i++) {
				p.sendMessage(" ");
				if (i == 119) {
					p.sendMessage(mClass.getPrefix()
							+ pluginException.LOCAL_CHAT_CLEARED.msg);
				}
			}
			return true;
		}
	}

}
