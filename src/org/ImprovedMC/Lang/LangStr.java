package org.ImprovedMC.Lang;

import java.io.File;

import org.ImprovedMC.MainClass;
import org.bukkit.entity.Player;

public class LangStr {

	private static MainClass mClass;
	
	public static File de_DE = new File("plugins/ChatProvider/" + "de_lang.prop");
	
	/**
	 * @param lan
	 */
	public static void setDefaultLang(Lang lan){
		lan.addString("NO_PERMISSIONS_EXCEPTION", "You dont have Permission to Acces This Command");
		lan.addString("GLOBAL_CHAT_CLEARED", "Global chat cleared by %p%");
		lan.addString("LOCAL_CHAT_CLEARED", "You have been cleared your local chat.");
	}
	
	
	
	/**
	 * @return
	 */
	public static String NO_PERMISSIONS_EXCEPTION(String colorCode){
		return mClass.getPrefix() + "§" + colorCode + mClass.replaceColor(mClass.lang.getString("NO_PERMISSIONS_EXCEPTION"));
	}
	/**
	 * @param p
	 * @return
	 */
	public static String GLOBAL_CHAT_CLEARED(Player p){
		String msg = mClass.lang.getString("GLOBAL_CHAT_CLEARED");
		msg.replaceAll("%p%", p.getName());
		return mClass.getPrefix() + mClass.replaceColor(msg);
	}
	/**
	 * @return
	 */
	public static String LOCAL_CHAT_CLEARED(){
		return mClass.getPrefix() + mClass.replaceColor(mClass.lang.getString("LOCAL_CHAT_CLEARED"));
	}
	
}
