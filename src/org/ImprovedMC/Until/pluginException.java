package org.ImprovedMC.Until;

@Deprecated
public enum pluginException {

	NO_PERMISSIONS_EXCEPTION("�cYou dont have Permission to Acces This Command"),
	GLOBAL_CHAT_CLEARED("Global chat cleared by "),
	LOCAL_CHAT_CLEARED("You have been cleared your local chat.");
	public String msg;
	
	private pluginException(String msg){
		this.msg = msg;
	}
	
}
