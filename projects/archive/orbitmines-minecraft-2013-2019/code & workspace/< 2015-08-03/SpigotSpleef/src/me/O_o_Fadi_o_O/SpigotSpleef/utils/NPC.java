package me.O_o_Fadi_o_O.SpigotSpleef.utils;

import me.O_o_Fadi_o_O.SpigotSpleef.Start;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomBat;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomBlaze;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomCaveSpider;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomChicken;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomCow;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomCreeper;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomEnderman;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomEndermite;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomGhast;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomHorse;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomIronGolem;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomMagmaCube;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomMushroomCow;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomOcelot;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomPig;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomPigZombie;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomRabbit;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomSheep;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomSilverfish;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomSkeleton;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomSlime;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomSnowman;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomSpider;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomSquid;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomVillager;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomWitch;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomWolf;
import me.O_o_Fadi_o_O.SpigotSpleef.NMS.CustomZombie;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftArmorStand;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftBat;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftBlaze;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftCaveSpider;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftChicken;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftCow;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftCreeper;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftEnderman;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftEndermite;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftGhast;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftHorse;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftIronGolem;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftItem;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftMagmaCube;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftMushroomCow;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftOcelot;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPig;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPigZombie;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftRabbit;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftSheep;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftSilverfish;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftSkeleton;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftSlime;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftSnowman;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftSpider;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftSquid;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftVillager;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftWitch;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftWolf;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftZombie;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class NPC {

	private NPCType npctype;
	private EntityType entitytype;
	private String displayname;
	private Entity entity;
	private Item item;
	private ArmorStand asbat;
	private Kit kit;
	
	public NPC(NPCType npctype, EntityType entitytype, String displayname, Entity entity, Item item, Kit kit){
		this.npctype = npctype;
		this.entitytype = entitytype;
		this.displayname = displayname;
		this.entity = entity;
		this.item = item;
		this.kit = kit;
		
		new BukkitRunnable(){
			public void run(){
				if(getEntity() != null && !getEntity().isDead()){
					checkEntity();
				}
			}
		}.runTaskTimer(Start.getInstance(), 0, 3);
	}

	public NPCType getNPCType(){
		return this.npctype;
	}
	public void setNPCType(NPCType npctype){
		this.npctype = npctype;
	}
	
	public EntityType getEntityType(){
		return entitytype;
	}
	public void setEntityType(EntityType entitytype){
		this.entitytype = entitytype;
	}

	public String getDisplayname() {
		return this.displayname;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public boolean isNPCType(NPCType npctype){
		if(getNPCType() == npctype){
			return true;
		}
		return false;
	}

	public Entity getEntity(){
		return this.entity;
	}
	public void setEntity(Entity entity){
		this.entity = entity;
	}

	public Item getItem(){
		return this.item;
	}
	public void setItem(Item item){
		this.item = item;
	}

	public Kit getKit(){
		return this.kit;
	}
	public void setKit(Kit kit){
		this.kit = kit;
	}
	
	public void checkEntity(){
	    if(getEntity().getPassenger() == null){
	    	Item item = getDisplaynameItem(getEntity().getWorld(), getEntity().getLocation(), getEntity().getCustomName());
		    
		    getEntity().setPassenger(item);
		    setItem(item);
	    }
	}
	
	public void newEntity(EntityType entitytype, Location location, String displayname){
		displayname = displayname.replace("&", "§");
		if(getKit() != null){
			displayname = displayname.replace("%kit-name%", getKit().getName());
		}
		
		if(getEntity() != null){
			getEntity().remove();
		}
		if(getItem() != null){
			getItem().remove();
		}
		if(asbat != null){
			asbat.remove();
		}
		
		World w = location.getWorld();
		
		switch(entitytype){
			case ARMOR_STAND:
				break;
			case ARROW:
				break;
			case BAT:
				spawnBat(w, location, displayname);
				break;
			case BLAZE:
			    spawnBlaze(w, location, displayname);
				break;
			case BOAT:
				break;
			case CAVE_SPIDER:
				spawnCaveSpider(w, location, displayname);
				break;
			case CHICKEN:
				spawnChicken(w, location, displayname);
				break;
			case COMPLEX_PART:
				break;
			case COW:
				spawnCow(w, location, displayname);
				break;
			case CREEPER:
				spawnCreeper(w, location, displayname);
				break;
			case DROPPED_ITEM:
				break;
			case EGG:
				break;
			case ENDERMAN:
				spawnEnderman(w, location, displayname);
				break;
			case ENDERMITE:
				spawnEndermite(w, location, displayname);
				break;
			case ENDER_CRYSTAL:
				break;
			case ENDER_DRAGON:
				break;
			case ENDER_PEARL:
				break;
			case ENDER_SIGNAL:
				break;
			case EXPERIENCE_ORB:
				break;
			case FALLING_BLOCK:
				break;
			case FIREBALL:
				break;
			case FIREWORK:
				break;
			case FISHING_HOOK:
				break;
			case GHAST:
				spawnGhast(w, location, displayname);
				break;
			case GIANT:
				break;
			case GUARDIAN:
				break;
			case HORSE:
				spawnHorse(w, location, displayname);
				break;
			case IRON_GOLEM:
				spawnIronGolem(w, location, displayname);
				break;
			case ITEM_FRAME:
				break;
			case LEASH_HITCH:
				break;
			case LIGHTNING:
				break;
			case MAGMA_CUBE:
				spawnMagmaCube(w, location, displayname);
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
				spawnMushroomCow(w, location, displayname);
				break;
			case OCELOT:
				spawnOcelot(w, location, displayname);
				break;
			case PAINTING:
				break;
			case PIG:
				spawnPig(w, location, displayname);
				break;
			case PIG_ZOMBIE:
				spawnPigZombie(w, location, displayname);
				break;
			case PLAYER:
				break;
			case PRIMED_TNT:
				break;
			case RABBIT:
				spawnRabbit(w, location, displayname);
				break;
			case SHEEP:
				spawnSheep(w, location, displayname);
				break;
			case SILVERFISH:
				spawnSilverfish(w, location, displayname);
				break;
			case SKELETON:
				spawnSkeleton(w, location, displayname);
				break;
			case SLIME:
				spawnSlime(w, location, displayname);
				break;
			case SMALL_FIREBALL:
				break;
			case SNOWBALL:
				break;
			case SNOWMAN:
				spawnSnowman(w, location, displayname);
				break;
			case SPIDER:
				spawnSpider(w, location, displayname);
				break;
			case SPLASH_POTION:
				break;
			case SQUID:
				spawnSquid(w, location, displayname);
				break;
			case THROWN_EXP_BOTTLE:
				break;
			case UNKNOWN:
				break;
			case VILLAGER:
				spawnVillager(w, location, displayname);
				break;
			case WEATHER:
				break;
			case WITCH:
				spawnWitch(w, location, displayname);
				break;
			case WITHER:
				break;
			case WITHER_SKULL:
				break;
			case WOLF:
				spawnWolf(w, location, displayname);
				break;
			case ZOMBIE:
				spawnZombie(w, location, displayname);
				break;
			default:
				break;
		}
	}
	
	@SuppressWarnings("deprecation")
	public short getSpawnEggID(){
		return getEntityType().getTypeId();
	}
	
	public Item getDisplaynameItem(World w, Location location, String displayname){
		ItemStack i = new ItemStack(Material.WOOD_BUTTON);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(displayname);
		i.setItemMeta(meta);
		Item item = w.dropItem(location, i);
		item.setCustomName(displayname);
		item.setCustomNameVisible(true);
		item.setPickupDelay(Integer.MAX_VALUE);
		((CraftItem) item).getHandle().setInvisible(true);
		
	    return item;
	}
	
	private void spawnBat(World w, Location location, String displayname){
		if(this.asbat != null){
			this.asbat.remove();
		}
		
		ArmorStand asbat = (ArmorStand) w.spawnEntity(location, EntityType.ARMOR_STAND);
		((CraftArmorStand) asbat).getHandle().setInvisible(true);
		this.asbat = asbat;
		
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomBat e = new CustomBat(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    asbat.setPassenger(e.getBukkitEntity());
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftBat) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);

		getEntity().teleport(location);
	}
	
	private void spawnBlaze(World w, Location location, String displayname){
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomBlaze e = new CustomBlaze(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftBlaze) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);

		getEntity().teleport(location);
	}
	
	private void spawnCaveSpider(World w, Location location, String displayname){
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomCaveSpider e = new CustomCaveSpider(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftCaveSpider) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);
		
		getEntity().teleport(location);
	}
	
	private void spawnChicken(World w, Location location, String displayname){
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomChicken e = new CustomChicken(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftChicken) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);
		
		getEntity().teleport(location);
	}
	
	private void spawnCow(World w, Location location, String displayname){
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomCow e = new CustomCow(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftCow) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);
		
		getEntity().teleport(location);
	}
	
	private void spawnCreeper(World w, Location location, String displayname){
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomCreeper e = new CustomCreeper(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftCreeper) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);
		
		getEntity().teleport(location);
	}
	
	private void spawnEnderman(World w, Location location, String displayname){
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomEnderman e = new CustomEnderman(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftEnderman) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);
		
		getEntity().teleport(location);
	}
	
	private void spawnEndermite(World w, Location location, String displayname){
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomEndermite e = new CustomEndermite(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftEndermite) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);
		
		getEntity().teleport(location);
	}
	
	private void spawnGhast(World w, Location location, String displayname){
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomGhast e = new CustomGhast(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftGhast) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);
		
		getEntity().teleport(location);
	}
	
	private void spawnHorse(World w, Location location, String displayname){
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomHorse e = new CustomHorse(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftHorse) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);
		
		getEntity().teleport(location);
	}
	
	private void spawnIronGolem(World w, Location location, String displayname){
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomIronGolem e = new CustomIronGolem(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftIronGolem) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);
		
		getEntity().teleport(location);
	}
	
	private void spawnMagmaCube(World w, Location location, String displayname){
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomMagmaCube e = new CustomMagmaCube(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftMagmaCube) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);
		
		getEntity().teleport(location);
	}
	
	private void spawnMushroomCow(World w, Location location, String displayname){
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomMushroomCow e = new CustomMushroomCow(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftMushroomCow) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);
		
		getEntity().teleport(location);
	}
	
	private void spawnOcelot(World w, Location location, String displayname){
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomOcelot e = new CustomOcelot(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftOcelot) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);
		
		getEntity().teleport(location);
	}
	
	private void spawnPig(World w, Location location, String displayname){
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomPig e = new CustomPig(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftPig) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);
		
		getEntity().teleport(location);
	}
	
	private void spawnPigZombie(World w, Location location, String displayname){
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomPigZombie e = new CustomPigZombie(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftPigZombie) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);
		
		getEntity().teleport(location);
	}
	
	private void spawnRabbit(World w, Location location, String displayname){
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomRabbit e = new CustomRabbit(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftRabbit) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);
		
		getEntity().teleport(location);
	}
	
	private void spawnSheep(World w, Location location, String displayname){
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomSheep e = new CustomSheep(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftSheep) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);
		
		getEntity().teleport(location);
	}
	
	private void spawnSilverfish(World w, Location location, String displayname){
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomSilverfish e = new CustomSilverfish(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftSilverfish) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);
		
		getEntity().teleport(location);
	}
	
	private void spawnSkeleton(World w, Location location, String displayname){
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomSkeleton e = new CustomSkeleton(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftSkeleton) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);
		
		getEntity().teleport(location);
	}
	
	private void spawnSlime(World w, Location location, String displayname){
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomSlime e = new CustomSlime(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftSlime) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);
		
		getEntity().teleport(location);
	}
	
	private void spawnSnowman(World w, Location location, String displayname){
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomSnowman e = new CustomSnowman(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftSnowman) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);
		
		getEntity().teleport(location);
	}
	
	private void spawnSpider(World w, Location location, String displayname){
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomSpider e = new CustomSpider(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftSpider) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);
		
		getEntity().teleport(location);
	}
	
	private void spawnSquid(World w, Location location, String displayname){
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomSquid e = new CustomSquid(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftSquid) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);
		
		getEntity().teleport(location);
	}
	
	private void spawnVillager(World w, Location location, String displayname){
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomVillager e = new CustomVillager(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftVillager) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);
		
		getEntity().teleport(location);
	}
	
	private void spawnWitch(World w, Location location, String displayname){
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomWitch e = new CustomWitch(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftWitch) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);
		
		getEntity().teleport(location);
	}
	
	private void spawnWolf(World w, Location location, String displayname){
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomWolf e = new CustomWolf(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftWolf) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);
		
		getEntity().teleport(location);
	}
	
	private void spawnZombie(World w, Location location, String displayname){
	    net.minecraft.server.v1_8_R2.World nmsWorld = ((CraftWorld) w).getHandle();
	    final CustomZombie e = new CustomZombie(nmsWorld);
	    e.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	    nmsWorld.addEntity(e);
	    e.setCustomName(displayname);
	    e.setCustomNameVisible(true);
	    Item item = getDisplaynameItem(w, location, displayname);
	    e.getBukkitEntity().setPassenger(item);
	    ((CraftZombie) e.getBukkitEntity()).setRemoveWhenFarAway(false);
	    
		setEntity(e.getBukkitEntity());
		setItem(item);
		
		getEntity().teleport(location);
	}
}
