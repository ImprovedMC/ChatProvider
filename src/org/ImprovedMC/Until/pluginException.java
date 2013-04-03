package org.ImprovedMC.Until;

<<<<<<< HEAD
=======
@Deprecated
>>>>>>> UPDATE + ADD LANG & TAB API
public enum pluginException {

	NO_PERMISSIONS_EXCEPTION("§cYou dont have Permission to Acces This Command"),
	GLOBAL_CHAT_CLEARED("Global chat cleared by "),
	LOCAL_CHAT_CLEARED("You have been cleared your local chat.");
	public String msg;
	
	private pluginException(String msg){
		this.msg = msg;
	}
	
}
