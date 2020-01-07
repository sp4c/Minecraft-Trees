package trees.tafoya;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	FileConfiguration config = this.getConfig();
	
	@Override
	public void onEnable() {
		this.getCommand("planttrees").setExecutor(new PlantTrees());
		
		addConfig();
		config.options().copyDefaults(true);
		saveConfig();

	}
	
	@Override
	public void onDisable() {
		
	}
	
	private void addConfig() {
		
		Map<String, Integer> carbonSinkBlocks = new HashMap<String, Integer>();
		/*
		carbonSinkBlocks.put("ACACIA_WOOD", value);
		carbonSinkBlocks.put("BIRCH_WOOD", value);
		carbonSinkBlocks.put("DARK_OAK_WOOD", value);
		carbonSinkBlocks.put("JUNGLE_WOOD", value);
		carbonSinkBlocks.put("OAK_WOOD", value);
		carbonSinkBlocks.put("SPRUCE_WOOD", value);
		carbonSinkBlocks.put("STRIPPED_ACACIA_WOOD", value);
		carbonSinkBlocks.put("STRIPPED_BIRCH_WOOD", value);
		carbonSinkBlocks.put("STRIPPED_DARK_OAK_WOOD", value);
		carbonSinkBlocks.put("STRIPPED_JUNGLE_WOOD", value);
		carbonSinkBlocks.put("STRIPPED_OAK_WOOD", value);
		carbonSinkBlocks.put("STRIPPED_SPRUCE_WOOD", value);
		dont know what to do with logs yet */
		carbonSinkBlocks.put("ACACIA_LEAVES", 4);
		carbonSinkBlocks.put("BIRCH_LEAVES", 4);
		carbonSinkBlocks.put("DARK_OAK_LEAVES", 4);
		carbonSinkBlocks.put("JUNGLE_LEAVES", 4);
		carbonSinkBlocks.put("OAK_LEAVES", 4);
		carbonSinkBlocks.put("SPRUCE_LEAVES", 4);
		carbonSinkBlocks.put("GRASS", 1);
		carbonSinkBlocks.put("TALL_GRASS", 1);
		carbonSinkBlocks.put("SEAGRASS", 1);
		carbonSinkBlocks.put("TALL_SEAGRASS", 1);
		carbonSinkBlocks.put("FERN", 1);
		carbonSinkBlocks.put("LARGE_FERN", 2);
		// int rerpesntent how much carbon is consumed
		config.createSection("carbonSinkBlocks", carbonSinkBlocks);
		saveDefaultConfig();
		config.options().copyDefaults(true);
		
	}
}
