package me.O_o_Fadi_o_O.Prison;

import me.O_o_Fadi_o_O.Prison.managers.StorageManager;
import net.minecraft.server.v1_8_R1.EntityArmorStand;
import net.minecraft.server.v1_8_R1.EntityBat;
import net.minecraft.server.v1_8_R1.EntityBlaze;
import net.minecraft.server.v1_8_R1.EntityCaveSpider;
import net.minecraft.server.v1_8_R1.EntityChicken;
import net.minecraft.server.v1_8_R1.EntityCow;
import net.minecraft.server.v1_8_R1.EntityCreeper;
import net.minecraft.server.v1_8_R1.EntityEnderDragon;
import net.minecraft.server.v1_8_R1.EntityEnderman;
import net.minecraft.server.v1_8_R1.EntityEndermite;
import net.minecraft.server.v1_8_R1.EntityGhast;
import net.minecraft.server.v1_8_R1.EntityGiantZombie;
import net.minecraft.server.v1_8_R1.EntityGuardian;
import net.minecraft.server.v1_8_R1.EntityHorse;
import net.minecraft.server.v1_8_R1.EntityIronGolem;
import net.minecraft.server.v1_8_R1.EntityLiving;
import net.minecraft.server.v1_8_R1.EntityMagmaCube;
import net.minecraft.server.v1_8_R1.EntityMushroomCow;
import net.minecraft.server.v1_8_R1.EntityOcelot;
import net.minecraft.server.v1_8_R1.EntityPig;
import net.minecraft.server.v1_8_R1.EntityPigZombie;
import net.minecraft.server.v1_8_R1.EntityRabbit;
import net.minecraft.server.v1_8_R1.EntitySheep;
import net.minecraft.server.v1_8_R1.EntitySilverfish;
import net.minecraft.server.v1_8_R1.EntitySkeleton;
import net.minecraft.server.v1_8_R1.EntitySlime;
import net.minecraft.server.v1_8_R1.EntitySnowman;
import net.minecraft.server.v1_8_R1.EntitySpider;
import net.minecraft.server.v1_8_R1.EntitySquid;
import net.minecraft.server.v1_8_R1.EntityVillager;
import net.minecraft.server.v1_8_R1.EntityWitch;
import net.minecraft.server.v1_8_R1.EntityWither;
import net.minecraft.server.v1_8_R1.EntityWolf;
import net.minecraft.server.v1_8_R1.EntityZombie;
import net.minecraft.server.v1_8_R1.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_8_R1.PacketPlayOutSpawnEntityLiving;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class DisguisePlayer {

	public static void disguisePlayer(Player p, EntityType type, Player... players) {
	    EntityLiving disguise = null;
	    switch(type) {
    	case BAT:
    		disguise = new EntityBat(((CraftPlayer) p).getHandle().world);
	        break;
        case BLAZE:
            disguise = new EntityBlaze(((CraftPlayer) p).getHandle().world);
            break;
		case ARMOR_STAND:
            disguise = new EntityArmorStand(((CraftPlayer) p).getHandle().world);
			break;
		case ARROW:
			break;
		case BOAT:
			break;
		case CAVE_SPIDER:
			disguise = new EntityCaveSpider(((CraftPlayer) p).getHandle().world);
			break;
		case CHICKEN:
			disguise = new EntityChicken(((CraftPlayer) p).getHandle().world);
			break;
		case COMPLEX_PART:
			break;
		case COW:
			disguise = new EntityCow(((CraftPlayer) p).getHandle().world);
			break;
		case CREEPER:
			disguise = new EntityCreeper(((CraftPlayer) p).getHandle().world);
			break;
		case DROPPED_ITEM:
			break;
		case EGG:
			break;
		case ENDERMAN:
			disguise = new EntityEnderman(((CraftPlayer) p).getHandle().world);
			break;
		case ENDERMITE:
			disguise = new EntityEndermite(((CraftPlayer) p).getHandle().world);
			break;
		case ENDER_CRYSTAL:
			break;
		case ENDER_DRAGON:
			disguise = new EntityEnderDragon(((CraftPlayer) p).getHandle().world);
			break;
		case ENDER_PEARL:
			break;
		case ENDER_SIGNAL:
			break;
		case EXPERIENCE_ORB:
			break;
		case FALLING_BLOCK:;
			break;
		case FIREBALL:
			break;
		case FIREWORK:
			break;
		case FISHING_HOOK:
			break;
		case GHAST:
			disguise = new EntityGhast(((CraftPlayer) p).getHandle().world);
			break;
		case GIANT:
			disguise = new EntityGiantZombie(((CraftPlayer) p).getHandle().world);
			break;
		case GUARDIAN:
			disguise = new EntityGuardian(((CraftPlayer) p).getHandle().world);
			break;
		case HORSE:
			disguise = new EntityHorse(((CraftPlayer) p).getHandle().world);
			break;
		case IRON_GOLEM:
			disguise = new EntityIronGolem(((CraftPlayer) p).getHandle().world);
			break;
		case ITEM_FRAME:
			break;
		case LEASH_HITCH:
			break;
		case LIGHTNING:
			break;
		case MAGMA_CUBE:
			disguise = new EntityMagmaCube(((CraftPlayer) p).getHandle().world);
			break;
		case MINECART:
			break;
		case MINECART_CHEST:
			break;
		case MINECART_COMMAND:
			break;
		case MINECART_FURNACE:
			break;
		case MINECART_HOPPER:
			break;
		case MINECART_MOB_SPAWNER:
			break;
		case MINECART_TNT:
			break;
		case MUSHROOM_COW:
			disguise = new EntityMushroomCow(((CraftPlayer) p).getHandle().world);
			break;
		case OCELOT:
			disguise = new EntityOcelot(((CraftPlayer) p).getHandle().world);
			break;
		case PAINTING:
			break;
		case PIG:
			disguise = new EntityPig(((CraftPlayer) p).getHandle().world);
			break;
		case PIG_ZOMBIE:
			disguise = new EntityPigZombie(((CraftPlayer) p).getHandle().world);
			break;
		case PLAYER:
			//TODO
			break;
		case PRIMED_TNT:
			break;
		case RABBIT:
			disguise = new EntityRabbit(((CraftPlayer) p).getHandle().world);
			break;
		case SHEEP:
			disguise = new EntitySheep(((CraftPlayer) p).getHandle().world);
			break;
		case SILVERFISH:
			disguise = new EntitySilverfish(((CraftPlayer) p).getHandle().world);
			break;
		case SKELETON:
			disguise = new EntitySkeleton(((CraftPlayer) p).getHandle().world);
			break;
		case SLIME:
			disguise = new EntitySlime(((CraftPlayer) p).getHandle().world);
			break;
		case SMALL_FIREBALL:
			break;
		case SNOWBALL:
			break;
		case SNOWMAN:
			disguise = new EntitySnowman(((CraftPlayer) p).getHandle().world);
			break;
		case SPIDER:
			disguise = new EntitySpider(((CraftPlayer) p).getHandle().world);
			break;
		case SPLASH_POTION:
			break;
		case SQUID:
			disguise = new EntitySquid(((CraftPlayer) p).getHandle().world);
			break;
		case THROWN_EXP_BOTTLE:
			break;
		case UNKNOWN:
			break;
		case VILLAGER:
			disguise = new EntityVillager(((CraftPlayer) p).getHandle().world);
			break;
		case WEATHER:
			break;
		case WITCH:
			disguise = new EntityWitch(((CraftPlayer) p).getHandle().world);
			break;
		case WITHER:
			disguise = new EntityWither(((CraftPlayer) p).getHandle().world);
			break;
		case WITHER_SKULL:
			break;
		case WOLF:
			disguise = new EntityWolf(((CraftPlayer) p).getHandle().world);
			break;
		case ZOMBIE:
			disguise = new EntityZombie(((CraftPlayer) p).getHandle().world);
			break;
		default:
			break;
	    }
	    
        if (disguise == null) {
            throw new IllegalArgumentException("LivingEntity not found.");
        }
        disguise.locX = p.getLocation().getX();
        disguise.locY = p.getLocation().getY();
        disguise.locZ = p.getLocation().getZ();
        disguise.yaw = p.getLocation().getYaw();
        disguise.pitch = p.getLocation().getPitch();
      
        disguise.d(((CraftPlayer) p).getHandle().getId());
        
        StorageManager.disguise.put(p, type);
        
        for(Player player : players){
        	if(player != p){
        		((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutEntityDestroy((((CraftPlayer) p).getHandle().getId())));
        		((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutSpawnEntityLiving(disguise));
        	}
        }
	}
	
    @SuppressWarnings("deprecation")
	public static void undisguisePlayer(Player p){
    	StorageManager.disguise.remove(p);
    	
        for(Player player : Bukkit.getOnlinePlayers()){
    		player.hidePlayer(p);
    		player.showPlayer(p);
        }
    }
}
