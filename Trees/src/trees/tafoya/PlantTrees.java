package trees.tafoya;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlantTrees implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (args.length != 1 || !(sender instanceof Player)) return false;
		
		int len = Integer.parseInt(args[0]) * 16 / 2;
		Player player = (Player)sender;
		World world = player.getWorld();
		int startX = player.getLocation().getBlockX();
		int startZ = player.getLocation().getBlockZ();
		
		for (int distX = -len; distX < len; distX+= 4) {
			
			for (int distZ = -len; distZ < len; distZ += 4) {
				
				for (int y = world.getMaxHeight(); y > 0; y--) {
				
					int x = startX + distX;
					int z = startZ + distZ;
				
					Block block = world.getBlockAt(x, y, z);
					if (block.getType() == Material.GRASS_BLOCK) {
						world.getBlockAt(x, ++y, z).setType(getRandomSapling());
						block.setType(Material.GRASS_BLOCK); // placing the sapling turns the block into dirt
						break;
					}
					else if (block.getType() == Material.DIRT) {
						world.getBlockAt(x, ++y, z).setType(getRandomSapling());
						break;
					}
				}
			}
		}
		
		return true;
		
	}
	
	private Material getRandomSapling() {
		Material[] saplings = {Material.ACACIA_SAPLING, Material.BIRCH_SAPLING, Material.DARK_OAK_SAPLING, Material.JUNGLE_SAPLING, Material.OAK_SAPLING, };
		return saplings[(int) (Math.random() * saplings.length)];
	}

}
