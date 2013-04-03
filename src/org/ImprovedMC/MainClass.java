package org.ImprovedMC;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.ImprovedMC.Chat.CommandEvent;
import org.ImprovedMC.Chat.Command_Clear;
import org.ImprovedMC.Lang.Lang;
import org.ImprovedMC.Lang.LangStr;
import org.ImprovedMC.Until.CgM;
import org.ImprovedMC.Until.TabProvider;
import org.ImprovedMC.Until2.Optimize;
import org.ImprovedMC.Until2.Optimize.Priority;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("deprecation")
public class MainClass extends JavaPlugin implements Listener{

	Logger log = Logger.getLogger("Minecraft");
	
	private String pluginPrefix = "§e[ChatProvider] §a";
	
	public Lang lang = null;
	
	private String msgC = "messages.yml";
	private String gloC = "config.yml";
	
	@Override
	public void onDisable() {
		
	}
	
	@Override
	public void onEnable() {
		try {
			this.lang = new Lang(LangStr.de_DE);
			LangStr.setDefaultLang(this.lang);
		} catch (FileNotFoundException e) {e.printStackTrace();} catch (IOException e) {e.printStackTrace();}
		
		
		/**
		 * Create Default Configs
		 */
		CgM.addConfig(this, msgC);
		CgM.addConfig(this, gloC);
		
		try {
			CgM.getConfig(msgC).options().copyDefaults(true);
			CgM.getConfig(gloC).options().copyDefaults(true);
		} catch(NullPointerException e){
			sendConsole("Configs are Ready!");
		}
		CgM.saveConfigs(this);
		
		getCommand("clear").setExecutor(new Command_Clear(this));
		getServer().getPluginManager().registerEvents(new CommandEvent(this), this);
		getServer().getPluginManager().registerEvents(this, this);
		
		sendConsole("Plugin is Ready!");
		
	}
	
	
	
	public void sendConsole(String msg){
		log.info("§e[ChatProvider] §a" + msg);
	}
	
	public String replaceColor(String msg){
		return ChatColor.translateAlternateColorCodes('&', msg);
	}
	
	public String getPrefix(){
		return pluginPrefix;
	}
	
	@Optimize(value="Event", assignedTo="PlayerJoinEvent", priority=Priority.HIGH)
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		ArrayList<String> messages = new ArrayList<String>();
		messages.add("§6▃▄▅▆▇█");
		messages.add("§6SERVERNAME");
		messages.add("§6█▇▆▅▄▃▂▁");
		messages.add("§eWilkommen");
		messages.add("§a" + p.getName());
		messages.add("§7OnlinePlayers:");
		
		TabProvider.setTab(messages);
	}
	
	@Deprecated
	public boolean hasPermissions(MainClass mClass, Player p, String permission){
		if(p.hasPermission(permission)){
			mClass.sendConsole(mClass.getPrefix() + "Player " + p.getName() + " have Permission: " + permission);
			return true;
		} else {
			mClass.sendConsole(mClass.getPrefix() + "Player " + p.getName() + " dont have Permission: " + permission);
			return false;
		}
	}
	
	public boolean hasPerm(Player p, String permission){
		if(p.hasPermission(permission)){
			return true;
		} else {
			return false;
		}
	}
	
}
