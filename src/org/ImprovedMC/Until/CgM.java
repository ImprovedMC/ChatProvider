package org.ImprovedMC.Until;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class CgM {

	private static HashMap<String, YamlConfiguration> configs = new HashMap<String, YamlConfiguration>();
	
	public static void loadConfigs(JavaPlugin plugin){
		configs.clear();
		File folder = plugin.getDataFolder();
		for(File file : folder.listFiles())
			if(file.getName().toLowerCase().endsWith(".yml"))
				configs.put(file.getName(), YamlConfiguration.loadConfiguration(file));
	}
	
	public static void saveConfigs(JavaPlugin plugin){
		for(String file : configs.keySet()){
			try{
				configs.get(file).save(new File(plugin.getDataFolder(), file));
			} catch (IOException e) {
				Bukkit.getLogger().warning("Could not save config: " + file);
			}
		}
	}
	
	public static boolean set(String name, String path, Object value){
		if(getConfig(name) == null)
			return false;
		getConfig(name).set(path, value);
		return true;
	}	 
	
	public static YamlConfiguration getConfig(String name){
		  return configs.get(name);
	}
	
	public static boolean addConfig(JavaPlugin plugin, String name){
		File file = new File(plugin.getDataFolder(), name);
		if(file.exists())
			return false;
		
		configs.put(name, new YamlConfiguration());
		try {
			configs.get(name).save(file);
		} catch (IOException e) {
			Bukkit.getLogger().warning("Could not create new config file: " + name);
			return false;
		}
		
		return true;
	}
	
}
