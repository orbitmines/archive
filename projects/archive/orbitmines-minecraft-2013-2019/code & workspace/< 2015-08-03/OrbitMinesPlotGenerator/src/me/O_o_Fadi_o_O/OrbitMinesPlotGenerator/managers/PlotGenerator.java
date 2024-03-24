package me.O_o_Fadi_o_O.OrbitMinesPlotGenerator.managers;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

public class PlotGenerator extends ChunkGenerator {

    private double plotsize;
    private double pathsize;
    private int roadheight;

    public PlotGenerator() {
        plotsize = 88;
        pathsize = 15;
        roadheight = 70;
    }

    @SuppressWarnings("deprecation")
	@Override
    public short[][] generateExtBlockSections(World world, Random random, int cx, int cz, BiomeGrid biomes) {
        int maxY = world.getMaxHeight();

        short[][] result = new short[maxY / 16][];

        double size = plotsize + pathsize;
        int valx;
        int valz;

        double n1;
        double n2;
        double n3;
        int mod2 = 0;
        int mod1 = 1;

        if(pathsize % 2 == 1){
            n1 = Math.ceil(((double) pathsize) / 2) - 2;
            n2 = Math.ceil(((double) pathsize) / 2) - 1;
            n3 = Math.ceil(((double) pathsize) / 2);
        }else{
            n1 = Math.floor(((double) pathsize) / 2) - 2;
            n2 = Math.floor(((double) pathsize) / 2) - 1;
            n3 = Math.floor(((double) pathsize) / 2);
        }

        if(pathsize % 2 == 1){
            mod2 = -1;
        }

        for(int x = 0; x < 16; x++){
            valx = (cx * 16 + x);

            for(int z = 0; z < 16; z++){
                int height = roadheight + 2;
                valz = (cz * 16 + z);

                biomes.setBiome(x, z, Biome.PLAINS);

                for(int y = 0; y < height; y++){
                    if(y == 0){
                    	setBlock(result, x, y, z, (short) org.bukkit.Material.BEDROCK.getId());
                    }
                    else if(y == roadheight){
                        if(valx % size != 0 && (valz % size == 1 || valz % size == -1 || valz % size == 102 || valz % size == -102)){
                        	if((valz % size == 1 && valx % size == 1) || (valz % size == 1 && valx % size == -1) || (valz % size == -1 && valx % size == 1) || ((valz % size == -1 && valx % size == -1)) || (valz % size == 102 && valx % size == 1) || (valz % size == 102 && valx % size == -1) || (valz % size == -102 && valx % size == 1) || ((valz % size == -102 && valx % size == -1))){
                				setBlock(result, x, y, z, (short) org.bukkit.Material.HARD_CLAY.getId());
                            }
                        	else{
                        		List<org.bukkit.Material> materials = Arrays.asList(org.bukkit.Material.STAINED_CLAY, org.bukkit.Material.STAINED_CLAY);//15, 12
                        		
                        		int index = 0;
                        		boolean found = false;
                        		for(int i = 12; i <= plotsize +2; i += 6){
                        			if(- valx % size <= i && - valx % size >= -i){
                        				setBlock(result, x, y, z, (short) materials.get(index).getId());
                        				found = true;
	                        			
	                        			index++;
	                        			if(index == 2){
	                        				index = 0;
	                        			}
                        			}
                        		}
                        		
                        		if(!found){
                        			if(- valx % size <= 101 && - valx % size >= -101){
                        				setBlock(result, x, y, z, (short) org.bukkit.Material.STAINED_CLAY.getId());//12
                            		}
                        			else{
                        				setBlock(result, x, y, z, (short) org.bukkit.Material.HARD_CLAY.getId());
                            		}
                        		}
                        	}
                        }
                        else if(valz % size != 0 && (valx % size == 1 || valx % size == -1 || valx % size == 102 || valx % size == -102)){
                        	if((valx % size == 1 && valz % size == 1) || (valx % size == 1 && valz % size == -1) || (valx % size == -1 && valz % size == 1) || ((valx % size == -1 && valz % size == -1)) || (valx % size == 102 && valz % size == 1) || (valx % size == 102 && valz % size == -1) || (valx % size == -102 && valz % size == 1) || ((valx % size == -102 && valz % size == -1))){
                				setBlock(result, x, y, z, (short) org.bukkit.Material.HARD_CLAY.getId());
                        	}
                        	else{
                        		List<org.bukkit.Material> materials = Arrays.asList(org.bukkit.Material.STAINED_CLAY, org.bukkit.Material.STAINED_CLAY);//15, 12
                        		
                        		int index = 0;
                        		boolean found = false;
                        		for(int i = 12; i <= plotsize +2; i += 6){
                        			if(- valz % size <= i && - valz % size >= -i){
                        				setBlock(result, x, y, z, (short) materials.get(index).getId());
                        				found = true;
	                        			
	                        			index++;
	                        			if(index == 2){
	                        				index = 0;
	                        			}
                        			}
                        		}
                        		
                        		if(!found){
                        			if(- valz % size <= 101 && - valz % size >= -101){
                        				setBlock(result, x, y, z, (short) org.bukkit.Material.STAINED_CLAY.getId());//12
                        			}
                        			else{
                                		setBlock(result, x, y, z, (short) org.bukkit.Material.HARD_CLAY.getId());
                        			}
                        		}
                        	}
                        }
                        else if(valx % size != 0 && (valz % size == 2 || valz % size == -2 || valz % size == 101 || valz % size == -101)){
                        	if((valz % size == 2 && valx % size == 2) || (valz % size == 2 && valx % size == -2) || (valz % size == -2 && valx % size == 2) || ((valz % size == -2 && valx % size == -2)) || (valz % size == 101 && valx % size == 2) || (valz % size == 101 && valx % size == -2) || (valz % size == -101 && valx % size == 2) || ((valz % size == -101 && valx % size == -2))){
                				setBlock(result, x, y, z, (short) org.bukkit.Material.STAINED_CLAY.getId());//12
                            }
                        	else{
                        		List<org.bukkit.Material> materials = Arrays.asList(org.bukkit.Material.HARD_CLAY, org.bukkit.Material.STAINED_CLAY);//0, 15
                        		
                        		int index = 0;
                        		boolean found = false;
                        		for(int i = 12; i <= plotsize +2; i += 6){
                        			if(- valx % size <= i && - valx % size >= -i){
                        				setBlock(result, x, y, z, (short) materials.get(index).getId());
                        				found = true;
	                        			
	                        			index++;
	                        			if(index == 2){
	                        				index = 0;
	                        			}
                        			}
                        		}
                        		
                        		if(!found){
                        			if(- valx % size <= 100 && - valx % size >= -100){
                        				setBlock(result, x, y, z, (short) org.bukkit.Material.STAINED_CLAY.getId());//15
                            		}
                        			else{
                        				setBlock(result, x, y, z, (short) org.bukkit.Material.STAINED_CLAY.getId());//12
                            		}
                        		}
                        	}
                        }
                        else if(valz % size != 0 && (valx % size == 2 || valx % size == -2 || valx % size == 101 || valx % size == -101)){
                        	if((valx % size == 2 && valz % size == 2) || (valx % size == 2 && valz % size == -2) || (valx % size == -2 && valz % size == 2) || ((valx % size == -2 && valz % size == -2)) || (valx % size == 101 && valz % size == 2) || (valx % size == 101 && valz % size == -2) || (valx % size == -101 && valz % size == 2) || ((valx % size == -101 && valz % size == -2))){
                				setBlock(result, x, y, z, (short) org.bukkit.Material.STAINED_CLAY.getId());//12
                        	}
                        	else{
                        		List<org.bukkit.Material> materials = Arrays.asList(org.bukkit.Material.HARD_CLAY, org.bukkit.Material.STAINED_CLAY);//0, 15
                        		
                        		int index = 0;
                        		boolean found = false;
                        		for(int i = 12; i <= plotsize +2; i += 6){
                        			if(- valz % size <= i && - valz % size >= -i){
                        				setBlock(result, x, y, z, (short) materials.get(index).getId());
                        				found = true;
	                        			
	                        			index++;
	                        			if(index == 2){
	                        				index = 0;
	                        			}
                        			}
                        		}
                        		
                        		if(!found){
                        			if(- valz % size <= 100 && - valz % size >= -100){
                        				setBlock(result, x, y, z, (short) org.bukkit.Material.STAINED_CLAY.getId());//15
                        			}
                        			else{
                                		setBlock(result, x, y, z, (short) org.bukkit.Material.STAINED_CLAY.getId());//12
                        			}
                        		}
                        	}
                        }
                        else if(valx % size != 0 && (valz % size == 3 || valz % size == -3 || valz % size == 100 || valz % size == -100)){
                        	if((valz % size == 3 && valx % size == 3) || (valz % size == 3 && valx % size == -3) || (valz % size == -3 && valx % size == 3) || ((valz % size == -3 && valx % size == -3)) || (valz % size == 100 && valx % size == 3) || (valz % size == 100 && valx % size == -3) || (valz % size == -100 && valx % size == 3) || ((valz % size == -100 && valx % size == -3))){
                				setBlock(result, x, y, z, (short) org.bukkit.Material.STAINED_CLAY.getId());//15
                            }
                        	else{
                        		List<org.bukkit.Material> materials = Arrays.asList(org.bukkit.Material.STAINED_CLAY, org.bukkit.Material.STAINED_CLAY);//15, 12
                        		
                        		int index = 0;
                        		boolean found = false;
                        		for(int i = 12; i <= plotsize +2; i += 6){
                        			if(- valx % size <= i && - valx % size >= -i){
                        				setBlock(result, x, y, z, (short) materials.get(index).getId());
                        				found = true;
	                        			
	                        			index++;
	                        			if(index == 2){
	                        				index = 0;
	                        			}
                        			}
                        		}
                        		
                        		if(!found){
                        			if(- valx % size <= 99 && - valx % size >= -99){
                        				setBlock(result, x, y, z, (short) org.bukkit.Material.STAINED_CLAY.getId());//12
                            		}
                        			else{
                        				setBlock(result, x, y, z, (short) org.bukkit.Material.STAINED_CLAY.getId());//15
                            		}
                        		}
                        	}
                        }
                        else if(valz % size != 0 && (valx % size == 3 || valx % size == -3 || valx % size == 100 || valx % size == -100)){
                        	if((valx % size == 3 && valz % size == 3) || (valx % size == 3 && valz % size == -3) || (valx % size == -3 && valz % size == 3) || ((valx % size == -3 && valz % size == -3)) || (valx % size == 100 && valz % size == 3) || (valx % size == 100 && valz % size == -3) || (valx % size == -100 && valz % size == 3) || ((valx % size == -100 && valz % size == -3))){
                				setBlock(result, x, y, z, (short) org.bukkit.Material.STAINED_CLAY.getId());//15
                        	}
                        	else{
                        		List<org.bukkit.Material> materials = Arrays.asList(org.bukkit.Material.STAINED_CLAY, org.bukkit.Material.STAINED_CLAY);//15, 12
                        		
                        		int index = 0;
                        		boolean found = false;
                        		for(int i = 12; i <= plotsize +2; i += 6){
                        			if(- valz % size <= i && - valz % size >= -i){
                        				setBlock(result, x, y, z, (short) materials.get(index).getId());
                        				found = true;
	                        			
	                        			index++;
	                        			if(index == 2){
	                        				index = 0;
	                        			}
                        			}
                        		}
                        		
                        		if(!found){
                        			if(- valz % size <= 99 && - valz % size >= -99){
                        				setBlock(result, x, y, z, (short) org.bukkit.Material.STAINED_CLAY.getId());//12
                        			}
                        			else{
                                		setBlock(result, x, y, z, (short) org.bukkit.Material.STAINED_CLAY.getId());//15
                        			}
                        		}
                        	}
                        }
                        else if(valx % size != 0 && (valz % size == 4 || valz % size == -4 || valz % size == 99 || valz % size == -99)){
                        	if((valz % size == 4 && valx % size == 4) || (valz % size == 4 && valx % size == -4) || (valz % size == -4 && valx % size == 4) || ((valz % size == -4 && valx % size == -4)) || (valz % size == 99 && valx % size == 4) || (valz % size == 99 && valx % size == -4) || (valz % size == -99 && valx % size == 4) || ((valz % size == -99 && valx % size == -4))){
                				setBlock(result, x, y, z, (short) org.bukkit.Material.STAINED_CLAY.getId());//12
                            }
                        	else{
                        		List<org.bukkit.Material> materials = Arrays.asList(org.bukkit.Material.STAINED_CLAY, org.bukkit.Material.HARD_CLAY);//12, 0
                        		
                        		int index = 0;
                        		boolean found = false;
                        		for(int i = 12; i <= plotsize +2; i += 6){
                        			if(- valx % size <= i && - valx % size >= -i){
                        				setBlock(result, x, y, z, (short) materials.get(index).getId());
                        				found = true;
	                        			
	                        			index++;
	                        			if(index == 2){
	                        				index = 0;
	                        			}
                        			}
                        		}
                        		
                        		if(!found){
                        			if(- valx % size <= 98 && - valx % size >= -98){
                        				setBlock(result, x, y, z, (short) org.bukkit.Material.HARD_CLAY.getId());
                            		}
                        			else{
                        				setBlock(result, x, y, z, (short) org.bukkit.Material.STAINED_CLAY.getId());//12
                            		}
                        		}
                        	}
                        }
                        else if(valz % size != 0 && (valx % size == 4 || valx % size == -4 || valx % size == 99 || valx % size == -99)){
                        	if((valx % size == 4 && valz % size == 4) || (valx % size == 4 && valz % size == -4) || (valx % size == -4 && valz % size == 4) || ((valx % size == -4 && valz % size == -4)) || (valx % size == 99 && valz % size == 4) || (valx % size == 99 && valz % size == -4) || (valx % size == -99 && valz % size == 4) || ((valx % size == -99 && valz % size == -4))){
                				setBlock(result, x, y, z, (short) org.bukkit.Material.STAINED_CLAY.getId());//12
                        	}
                        	else{
                        		List<org.bukkit.Material> materials = Arrays.asList(org.bukkit.Material.STAINED_CLAY, org.bukkit.Material.HARD_CLAY);//12, 0
                        		
                        		int index = 0;
                        		boolean found = false;
                        		for(int i = 12; i <= plotsize +2; i += 6){
                        			if(- valz % size <= i && - valz % size >= -i){
                        				setBlock(result, x, y, z, (short) materials.get(index).getId());
                        				found = true;
	                        			
	                        			index++;
	                        			if(index == 2){
	                        				index = 0;
	                        			}
                        			}
                        		}
                        		
                        		if(!found){
                        			if(- valz % size <= 98 && - valz % size >= -98){
                        				setBlock(result, x, y, z, (short) org.bukkit.Material.HARD_CLAY.getId());
                        			}
                        			else{
                                		setBlock(result, x, y, z, (short) org.bukkit.Material.STAINED_CLAY.getId());//12
                        			}
                        		}
                        	}
                        }
                        else if(valx % size != 0 && (valz % size == 5 || valz % size == -5 || valz % size == 98 || valz % size == -98)){
                        	if((valz % size == 5 && valx % size == 5) || (valz % size == 5 && valx % size == -5) || (valz % size == -5 && valx % size == 5) || ((valz % size == -5 && valx % size == -5)) || (valz % size == 98 && valx % size == 5) || (valz % size == 98 && valx % size == -5) || (valz % size == -98 && valx % size == 5) || ((valz % size == -98 && valx % size == -5))){
                				setBlock(result, x, y, z, (short) org.bukkit.Material.HARD_CLAY.getId());
                            }
                        	else{
                        		List<org.bukkit.Material> materials = Arrays.asList(org.bukkit.Material.STAINED_CLAY, org.bukkit.Material.STAINED_CLAY);//15, 12
                        		
                        		int index = 0;
                        		boolean found = false;
                        		for(int i = 12; i <= plotsize +2; i += 6){
                        			if(- valx % size <= i && - valx % size >= -i){
                        				setBlock(result, x, y, z, (short) materials.get(index).getId());
                        				found = true;
	                        			
	                        			index++;
	                        			if(index == 2){
	                        				index = 0;
	                        			}
                        			}
                        		}
                        		
                        		if(!found){
                        			if(- valx % size <= 97 && - valx % size >= -97){
                        				setBlock(result, x, y, z, (short) org.bukkit.Material.STAINED_CLAY.getId());//12
                            		}
                        			else{
                        				setBlock(result, x, y, z, (short) org.bukkit.Material.HARD_CLAY.getId());
                            		}
                        		}
                        	}
                        }
                        else if(valz % size != 0 && (valx % size == 5 || valx % size == -5 || valx % size == 98 || valx % size == -98)){
                        	if((valx % size == 5 && valz % size == 5) || (valx % size == 5 && valz % size == -5) || (valx % size == -5 && valz % size == 5) || ((valx % size == -5 && valz % size == -5)) || (valx % size == 98 && valz % size == 5) || (valx % size == 98 && valz % size == -5) || (valx % size == -98 && valz % size == 5) || ((valx % size == -98 && valz % size == -5))){
                				setBlock(result, x, y, z, (short) org.bukkit.Material.HARD_CLAY.getId());
                        	}
                        	else{
                        		List<org.bukkit.Material> materials = Arrays.asList(org.bukkit.Material.STAINED_CLAY, org.bukkit.Material.STAINED_CLAY);//15, 12
                        		
                        		int index = 0;
                        		boolean found = false;
                        		for(int i = 12; i <= plotsize +2; i += 6){
                        			if(- valz % size <= i && - valz % size >= -i){
                        				setBlock(result, x, y, z, (short) materials.get(index).getId());
                        				found = true;
	                        			
	                        			index++;
	                        			if(index == 2){
	                        				index = 0;
	                        			}
                        			}
                        		}
                        		
                        		if(!found){
                        			if(- valz % size <= 97 && - valz % size >= -97){
                        				setBlock(result, x, y, z, (short) org.bukkit.Material.STAINED_CLAY.getId());//12
                        			}
                        			else{
                                		setBlock(result, x, y, z, (short) org.bukkit.Material.HARD_CLAY.getId());
                        			}
                        		}
                        	}
                        }
                        else if(valx % size != 0 && (valz % size == 6 || valz % size == -6 || valz % size == 97 || valz % size == -97)){
                        	List<org.bukkit.Material> materials = Arrays.asList(org.bukkit.Material.HARD_CLAY, org.bukkit.Material.STAINED_CLAY);//0, 15
                    		
                    		int index = 0;
                    		boolean found = false;
                    		for(int i = 12; i <= plotsize +2; i += 6){
                    			if(- valx % size <= i && - valx % size >= -i){
                    				setBlock(result, x, y, z, (short) materials.get(index).getId());
                    				found = true;
                        			
                        			index++;
                        			if(index == 2){
                        				index = 0;
                        			}
                    			}
                    		}
                    		
                    		if(!found){
                    			setBlock(result, x, y, z, (short) org.bukkit.Material.STAINED_CLAY.getId());//15
                    		}
                        }
                        else if(valz % size != 0 && (valx % size == 6 || valx % size == -6 || valx % size == 97 || valx % size == -97)){
                    		List<org.bukkit.Material> materials = Arrays.asList(org.bukkit.Material.HARD_CLAY, org.bukkit.Material.STAINED_CLAY);//0, 15
                    		
                    		int index = 0;
                    		boolean found = false;
                    		for(int i = 12; i <= plotsize +2; i += 6){
                    			if(- valz % size <= i && - valz % size >= -i){
                    				setBlock(result, x, y, z, (short) materials.get(index).getId());
                    				found = true;
                        			
                        			index++;
                        			if(index == 2){
                        				index = 0;
                        			}
                    			}
                    		}
                    		
                    		if(!found){
                    			setBlock(result, x, y, z, (short) org.bukkit.Material.STAINED_CLAY.getId());//15
                    		}
                        }
                        else if(valz % size != 0 && (valx % size == 7 || valx % size == -7 || valx % size == 96 || valx % size == -96)){
                        	if((valx % size == 7 && valz % size == 7) || (valx % size == 7 && valz % size == -7) || (valx % size == -7 && valz % size == 7) || ((valx % size == -7 && valz % size == -7)) || (valx % size == 96 && valz % size == 7) || (valx % size == 96 && valz % size == -7) || (valx % size == -96 && valz % size == 7) || ((valx % size == -96 && valz % size == -7))){
                				setBlock(result, x, (y +1), z, (short) org.bukkit.Material.STEP.getId());//5
                				setBlock(result, x, y, z, (short) org.bukkit.Material.GRASS.getId());
                            }
                        	else{
                        		List<org.bukkit.Material> materials = Arrays.asList(org.bukkit.Material.STEP, org.bukkit.Material.STEP);//0, 3
                        		
                        		int index = 0;
                        		boolean found = false;
                        		for(int i = 12; i <= plotsize +2; i += 6){
                        			if(- valz % size <= i && - valz % size >= -i){
                        				if(index == 1 && (- valz % size == 12 || - valz % size == -12 || - valz % size == 19 || - valz % size == -19 || - valz % size == 24 || - valz % size == -24 || - valz % size == 31 || - valz % size == -31 || - valz % size == 36 || - valz % size == -36 || - valz % size == 43 || - valz % size == -43 || - valz % size == 48 || - valz % size == -48 || - valz % size == 55 || - valz % size == -55 || - valz % size == 60 || - valz % size == -60 || - valz % size == 67 || - valz % size == -67 || - valz % size == 72 || - valz % size == -72 || - valz % size == 79 || - valz % size == -79 || - valz % size == 84 || - valz % size == -84)){
                            				setBlock(result, x, (y +1), z, (short) org.bukkit.Material.STEP.getId());//5
                        				}
                        				else{
                        					setBlock(result, x, (y +1), z, (short) materials.get(index).getId());
                        				}
                        				
                        				setBlock(result, x, y, z, (short) org.bukkit.Material.GRASS.getId());
                        				found = true;
	                        			
	                        			index++;
	                        			if(index == 2){
	                        				index = 0;
	                        			}
                        			}
                        		}
                        		
                        		if(!found){
                        			if(- valz % size != 91 && - valz % size != -91 && - valz % size != 96 && - valz % size != -96){
                        				setBlock(result, x, (y +1), z, (short) org.bukkit.Material.STEP.getId());//3
                        				setBlock(result, x, y, z, (short) org.bukkit.Material.GRASS.getId());
                        			}
                        			else{
                                		setBlock(result, x, (y +1), z, (short) org.bukkit.Material.STEP.getId());//5
                        				setBlock(result, x, y, z, (short) org.bukkit.Material.GRASS.getId());
                        			}
                        		}
                        	}
                        }
                        else if(valx % size != 0 && (valz % size == 7 || valz % size == -7 || valz % size == 96 || valz % size == -96)){
                        	if((valz % size == 7 && valx % size == 7) || (valz % size == 7 && valx % size == -7) || (valz % size == -7 && valx % size == 7) || ((valz % size == -7 && valx % size == -7)) || (valz % size == 96 && valx % size == 7) || (valz % size == 96 && valx % size == -7) || (valz % size == -96 && valx % size == 7) || ((valz % size == -96 && valx % size == -7))){
                				setBlock(result, x, (y +1), z, (short) org.bukkit.Material.STEP.getId());//5
                				setBlock(result, x, y, z, (short) org.bukkit.Material.GRASS.getId());
                            }
                        	else{
                        		List<org.bukkit.Material> materials = Arrays.asList(org.bukkit.Material.STEP, org.bukkit.Material.STEP);//0, 3
                        		
                        		int index = 0;
                        		boolean found = false;
                        		for(int i = 12; i <= plotsize +2; i += 6){
                        			if(- valx % size <= i && - valx % size >= -i){
                        				if(index == 1 && (- valx % size == 12 || - valx % size == -12 || - valx % size == 19 || - valx % size == -19 || - valx % size == 24 || - valx % size == -24 || - valx % size == 31 || - valx % size == -31 || - valx % size == 36 || - valx % size == -36 || - valx % size == 43 || - valx % size == -43 || - valx % size == 48 || - valx % size == -48 || - valx % size == 55 || - valx % size == -55 || - valx % size == 60 || - valx % size == -60 || - valx % size == 67 || - valx % size == -67 || - valx % size == 72 || - valx % size == -72 || - valx % size == 79 || - valx % size == -79 || - valx % size == 84 || - valx % size == -84)){
                            				setBlock(result, x, (y +1), z, (short) org.bukkit.Material.STEP.getId());//5
                        				}
                        				else{
                        					setBlock(result, x, (y +1), z, (short) materials.get(index).getId());
                        				}
                        				
                        				setBlock(result, x, y, z, (short) org.bukkit.Material.GRASS.getId());
                        				found = true;
	                        			
	                        			index++;
	                        			if(index == 2){
	                        				index = 0;
	                        			}
                        			}
                        		}
                        		
                        		if(!found){
                        			if(- valx % size != 91 && - valx % size != -91 && - valx % size != 96 && - valx % size != -96){
                        				setBlock(result, x, (y +1), z, (short) org.bukkit.Material.STEP.getId());//3
                        				setBlock(result, x, y, z, (short) org.bukkit.Material.GRASS.getId());
                        			}
                        			else{
                                		setBlock(result, x, (y +1), z, (short) org.bukkit.Material.STEP.getId());//5
                        				setBlock(result, x, y, z, (short) org.bukkit.Material.GRASS.getId());
                        			}
                        		}
                        	}
                        }
                        else if(valz % size == 0 || valx % size == 0 || valz % size == 103 || valx % size == 103 || valz % size == -103 || valx % size == -103){
                        	if(valz % size == 0 && valx % size == 0 || valz % size == 103 && valx % size == 103 || valz % size == -103 && valx % size == -103){
                        		setBlock(result, x, y, z, (short) org.bukkit.Material.STAINED_CLAY.getId());//12
                        	}
                        	else if(valz % size - valx % size <= 1 && valz % size - valx % size >= -1 || valz % size - valx % size <= 104 && valz % size - valx % size >= 102 || valz % size - valx % size <= -102 && valz % size - valx % size >= -104){
                        		setBlock(result, x, y, z, (short) org.bukkit.Material.STAINED_CLAY.getId());//15
                        	}
                        	else{
                        		List<org.bukkit.Material> materials = Arrays.asList(org.bukkit.Material.STAINED_CLAY, org.bukkit.Material.HARD_CLAY);//12, 0
                        		
                        		int index = 0;
                        		boolean found = false;
                        		for(int i = 12; i <= plotsize +2; i += 6){
                        			if(valz % size - valx % size <= i && valz % size - valx % size >= -i){
                        				setBlock(result, x, y, z, (short) materials.get(index).getId());
                        				found = true;
	                        			
	                        			index++;
	                        			if(index == 2){
	                        				index = 0;
	                        			}
                        			}
                        		}
                        		
                        		if(!found){
                        			if(- valx % size <= 101 && - valx % size >= -101){
                        				setBlock(result, x, y, z, (short) org.bukkit.Material.HARD_CLAY.getId());
                        			}
                        			else{
                                		setBlock(result, x, y, z, (short) org.bukkit.Material.STAINED_CLAY.getId());//15
                        			}
                        		}
                        	}
                        }
                        else{
                            if((valz - n2 + mod1) % size == 0 || (valz + n2 + mod2) % size == 0){
                            	setBlock(result, x, y, z, (short) org.bukkit.Material.GRASS.getId());
                            }
                            else{
                                boolean found2 = false;
                                for(double i = n1; i >= 0; i--){
                                    if((valz - i + mod1) % size == 0 || (valz + i + mod2) % size == 0){
                                        found2 = true;
                                        break;
                                    }
                                }

                                if(found2){
                                    setBlock(result, x, y, z, (short) org.bukkit.Material.GRASS.getId());
                                } 
                                else{
                                    boolean found3 = false;
                                    for(double i = n3; i >= 0; i--){
                                        if((valx - i + mod1) % size == 0 || (valx + i + mod2) % size == 0){
                                            found3 = true;
                                            break;
                                        }
                                    }

                                    if(found3){
                                        setBlock(result, x, y, z, (short) org.bukkit.Material.GRASS.getId());
                                    } 
                                    else{
                                        setBlock(result, x, y, z, (short) org.bukkit.Material.GRASS.getId());
                                    }
                                }
                            }
                        }
                    } 
                    else if(y == (roadheight + 1)){
                       
                    } 
                    else{
                        setBlock(result, x, y, z, (short) org.bukkit.Material.DIRT.getId());
                    }
                }
            }
        }

        return result;
    }

    private void setBlock(short[][] result, int x, int y, int z, short blkid) {
        if(result[y >> 4] == null){
            result[y >> 4] = new short[4096];
        }
        result[y >> 4][((y & 0xF) << 8) | (z << 4) | x] = blkid;
    }
    
    @Override
    public List<BlockPopulator> getDefaultPopulators(World world) {
        return Arrays.asList((BlockPopulator) new PlotPopulator());
    }

    public Location getFixedSpawnLocation(World world, Random random) {
        return new Location(world, 0, roadheight + 2, 0);
    }
}
