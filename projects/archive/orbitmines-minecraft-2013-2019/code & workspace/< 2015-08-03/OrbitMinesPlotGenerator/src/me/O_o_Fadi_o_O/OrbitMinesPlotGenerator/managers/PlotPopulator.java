package me.O_o_Fadi_o_O.OrbitMinesPlotGenerator.managers;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class PlotPopulator extends BlockPopulator {
    private double plotsize;
    private double pathsize;

    private int roadheight;

    public PlotPopulator() {
        plotsize = 88;
        pathsize = 15;
        roadheight = 70;
    }

    @Override
	public void populate(World world, Random rand, Chunk chunk) {
        int cx = chunk.getX();
        int cz = chunk.getZ();

        int xx = cx << 4;
        int zz = cz << 4;

        double size = plotsize + pathsize;
        
        for(int x = 0; x < 16; x++){
        	int valx = (xx + x);

            for(int z = 0; z < 16; z++){
                int height = roadheight + 2;
                int valz = (zz + z);

                for(int y = 0; y < height; y++){
                    if(y == 0){
                    	//Bedrock, Data: 0
                    }
                    else if(y == roadheight){
                        if(valx % size != 0 && (valz % size == 1 || valz % size == -1 || valz % size == 102 || valz % size == -102)){
                        	if((valz % size == 1 && valx % size == 1) || (valz % size == 1 && valx % size == -1) || (valz % size == -1 && valx % size == 1) || ((valz % size == -1 && valx % size == -1)) || (valz % size == 102 && valx % size == 1) || (valz % size == 102 && valx % size == -1) || (valz % size == -102 && valx % size == 1) || ((valz % size == -102 && valx % size == -1))){
                        		//Hardened Clay, Data: 0
                            }
                        	else{
                        		List<Byte> data = Arrays.asList((byte) 15, (byte) 12);
                        		
                        		int index = 0;
                        		boolean found = false;
                        		for(int i = 12; i <= plotsize +2; i += 6){
                        			if(- valx % size <= i && - valx % size >= -i){
                        				setData(world, valx, y, valz, data.get(index));
                        				found = true;
	                        			
	                        			index++;
	                        			if(index == 2){
	                        				index = 0;
	                        			}
                        			}
                        		}
                        		
                        		if(!found){
                        			if(- valx % size <= 101 && - valx % size >= -101){
                        				setData(world, valx, y, valz, (byte) 12);
                            		}
                        			else{
                        				//Hardened Clay, Data: 0
                            		}
                        		}
                        	}
                        }
                        else if(valz % size != 0 && (valx % size == 1 || valx % size == -1 || valx % size == 102 || valx % size == -102)){
                        	if((valx % size == 1 && valz % size == 1) || (valx % size == 1 && valz % size == -1) || (valx % size == -1 && valz % size == 1) || ((valx % size == -1 && valz % size == -1)) || (valx % size == 102 && valz % size == 1) || (valx % size == 102 && valz % size == -1) || (valx % size == -102 && valz % size == 1) || ((valx % size == -102 && valz % size == -1))){
                        		//Hardened Clay, Data: 0
                        	}
                        	else{
                        		List<Byte> data = Arrays.asList((byte) 15, (byte) 12);
                        		
                        		int index = 0;
                        		boolean found = false;
                        		for(int i = 12; i <= plotsize +2; i += 6){
                        			if(- valz % size <= i && - valz % size >= -i){
                        				setData(world, valx, y, valz, data.get(index));
                        				found = true;
	                        			
	                        			index++;
	                        			if(index == 2){
	                        				index = 0;
	                        			}
                        			}
                        		}
                        		
                        		if(!found){
                        			if(- valz % size <= 101 && - valz % size >= -101){
                        				setData(world, valx, y, valz, (byte) 12);
                            		}
                        			else{
                        				//Hardened Clay, Data: 0
                            		}
                        		}
                        	}
                        }
                        else if(valx % size != 0 && (valz % size == 2 || valz % size == -2 || valz % size == 101 || valz % size == -101)){
                        	if((valz % size == 2 && valx % size == 2) || (valz % size == 2 && valx % size == -2) || (valz % size == -2 && valx % size == 2) || ((valz % size == -2 && valx % size == -2)) || (valz % size == 101 && valx % size == 2) || (valz % size == 101 && valx % size == -2) || (valz % size == -101 && valx % size == 2) || ((valz % size == -101 && valx % size == -2))){
                				setData(world, valx, y, valz, (byte) 12);
                            }
                        	else{
                        		List<Byte> data = Arrays.asList((byte) 0, (byte) 15);
                        		
                        		int index = 0;
                        		boolean found = false;
                        		for(int i = 12; i <= plotsize +2; i += 6){
                        			if(- valx % size <= i && - valx % size >= -i){
                        				if(index == 1){
                            				setData(world, valx, y, valz, data.get(index));
                        				}
                        				found = true;
	                        			
	                        			index++;
	                        			if(index == 2){
	                        				index = 0;
	                        			}
                        			}
                        		}
                        		
                        		if(!found){
                        			if(- valx % size <= 100 && - valx % size >= -100){
                        				setData(world, valx, y, valz, (byte) 15);
                            		}
                        			else{
                        				setData(world, valx, y, valz, (byte) 12);
                            		}
                        		}
                        	}
                        }
                        else if(valz % size != 0 && (valx % size == 2 || valx % size == -2 || valx % size == 101 || valx % size == -101)){
                        	if((valx % size == 2 && valz % size == 2) || (valx % size == 2 && valz % size == -2) || (valx % size == -2 && valz % size == 2) || ((valx % size == -2 && valz % size == -2)) || (valx % size == 101 && valz % size == 2) || (valx % size == 101 && valz % size == -2) || (valx % size == -101 && valz % size == 2) || ((valx % size == -101 && valz % size == -2))){
                        		setData(world, valx, y, valz, (byte) 12);
                        	}
                        	else{
                        		List<Byte> data = Arrays.asList((byte) 0, (byte) 15);
                        		
                        		int index = 0;
                        		boolean found = false;
                        		for(int i = 12; i <= plotsize +2; i += 6){
                        			if(- valz % size <= i && - valz % size >= -i){
                        				if(index == 1){
                            				setData(world, valx, y, valz, data.get(index));
                        				}
                        				found = true;
	                        			
	                        			index++;
	                        			if(index == 2){
	                        				index = 0;
	                        			}
                        			}
                        		}
                        		
                        		if(!found){
                        			if(- valz % size <= 100 && - valz % size >= -100){
                        				setData(world, valx, y, valz, (byte) 15);
                            		}
                        			else{
                        				setData(world, valx, y, valz, (byte) 12);
                            		}
                        		}
                        	}
                        }
                        else if(valx % size != 0 && (valz % size == 3 || valz % size == -3 || valz % size == 100 || valz % size == -100)){
                        	if((valz % size == 3 && valx % size == 3) || (valz % size == 3 && valx % size == -3) || (valz % size == -3 && valx % size == 3) || ((valz % size == -3 && valx % size == -3)) || (valz % size == 100 && valx % size == 3) || (valz % size == 100 && valx % size == -3) || (valz % size == -100 && valx % size == 3) || ((valz % size == -100 && valx % size == -3))){
                        		setData(world, valx, y, valz, (byte) 15);
                            }
                        	else{
                        		List<Byte> data = Arrays.asList((byte) 15, (byte) 12);
                        		
                        		int index = 0;
                        		boolean found = false;
                        		for(int i = 12; i <= plotsize +2; i += 6){
                        			if(- valx % size <= i && - valx % size >= -i){
                        				setData(world, valx, y, valz, data.get(index));
                        				found = true;
	                        			
	                        			index++;
	                        			if(index == 2){
	                        				index = 0;
	                        			}
                        			}
                        		}
                        		
                        		if(!found){
                        			if(- valx % size <= 99 && - valx % size >= -99){
                        				setData(world, valx, y, valz, (byte) 12);
                            		}
                        			else{
                        				setData(world, valx, y, valz, (byte) 15);
                            		}
                        		}
                        	}
                        }
                        else if(valz % size != 0 && (valx % size == 3 || valx % size == -3 || valx % size == 100 || valx % size == -100)){
                        	if((valx % size == 3 && valz % size == 3) || (valx % size == 3 && valz % size == -3) || (valx % size == -3 && valz % size == 3) || ((valx % size == -3 && valz % size == -3)) || (valx % size == 100 && valz % size == 3) || (valx % size == 100 && valz % size == -3) || (valx % size == -100 && valz % size == 3) || ((valx % size == -100 && valz % size == -3))){
                        		setData(world, valx, y, valz, (byte) 15);
                        	}
                        	else{
                        		List<Byte> data = Arrays.asList((byte) 15, (byte) 12);
                        		
                        		int index = 0;
                        		boolean found = false;
                        		for(int i = 12; i <= plotsize +2; i += 6){
                        			if(- valz % size <= i && - valz % size >= -i){
                        				setData(world, valx, y, valz, data.get(index));
                        				found = true;
	                        			
	                        			index++;
	                        			if(index == 2){
	                        				index = 0;
	                        			}
                        			}
                        		}
                        		
                        		if(!found){
                        			if(- valz % size <= 99 && - valz % size >= -99){
                        				setData(world, valx, y, valz, (byte) 12);
                            		}
                        			else{
                        				setData(world, valx, y, valz, (byte) 15);
                            		}
                        		}
                        	}
                        }
                        else if(valx % size != 0 && (valz % size == 4 || valz % size == -4 || valz % size == 99 || valz % size == -99)){
                        	if((valz % size == 4 && valx % size == 4) || (valz % size == 4 && valx % size == -4) || (valz % size == -4 && valx % size == 4) || ((valz % size == -4 && valx % size == -4)) || (valz % size == 99 && valx % size == 4) || (valz % size == 99 && valx % size == -4) || (valz % size == -99 && valx % size == 4) || ((valz % size == -99 && valx % size == -4))){
                        		setData(world, valx, y, valz, (byte) 12);
                            }
                        	else{
                        		List<Byte> data = Arrays.asList((byte) 12, (byte) 0);
                        		
                        		int index = 0;
                        		boolean found = false;
                        		for(int i = 12; i <= plotsize +2; i += 6){
                        			if(- valx % size <= i && - valx % size >= -i){
                        				if(index == 0){
                            				setData(world, valx, y, valz, data.get(index));
                        				}
                        				found = true;
	                        			
	                        			index++;
	                        			if(index == 2){
	                        				index = 0;
	                        			}
                        			}
                        		}
                        		
                        		if(!found){
                        			if(- valx % size <= 98 && - valx % size >= -98){
                        				//Hardened Clay, Data: 0
                            		}
                        			else{
                        				setData(world, valx, y, valz, (byte) 12);
                            		}
                        		}
                        	}
                        }
                        else if(valz % size != 0 && (valx % size == 4 || valx % size == -4 || valx % size == 99 || valx % size == -99)){
                        	if((valx % size == 4 && valz % size == 4) || (valx % size == 4 && valz % size == -4) || (valx % size == -4 && valz % size == 4) || ((valx % size == -4 && valz % size == -4)) || (valx % size == 99 && valz % size == 4) || (valx % size == 99 && valz % size == -4) || (valx % size == -99 && valz % size == 4) || ((valx % size == -99 && valz % size == -4))){
                        		setData(world, valx, y, valz, (byte) 12);
                        	}
                        	else{
                        		List<Byte> data = Arrays.asList((byte) 12, (byte) 0);
                        		
                        		int index = 0;
                        		boolean found = false;
                        		for(int i = 12; i <= plotsize +2; i += 6){
                        			if(- valz % size <= i && - valz % size >= -i){
                        				if(index == 0){
                            				setData(world, valx, y, valz, data.get(index));
                        				}
                        				found = true;
	                        			
	                        			index++;
	                        			if(index == 2){
	                        				index = 0;
	                        			}
                        			}
                        		}
                        		
                        		if(!found){
                        			if(- valz % size <= 98 && - valz % size >= -98){
                        				//Hardened Clay, Data: 0
                            		}
                        			else{
                        				setData(world, valx, y, valz, (byte) 12);
                            		}
                        		}
                        	}
                        }
                        else if(valx % size != 0 && (valz % size == 5 || valz % size == -5 || valz % size == 98 || valz % size == -98)){
                        	if((valz % size == 5 && valx % size == 5) || (valz % size == 5 && valx % size == -5) || (valz % size == -5 && valx % size == 5) || ((valz % size == -5 && valx % size == -5)) || (valz % size == 98 && valx % size == 5) || (valz % size == 98 && valx % size == -5) || (valz % size == -98 && valx % size == 5) || ((valz % size == -98 && valx % size == -5))){
                        		//Hardened Clay, Data: 0
                            }
                        	else{
                        		List<Byte> data = Arrays.asList((byte) 15, (byte) 12);
                        		
                        		int index = 0;
                        		boolean found = false;
                        		for(int i = 12; i <= plotsize +2; i += 6){
                        			if(- valx % size <= i && - valx % size >= -i){
                        				setData(world, valx, y, valz, data.get(index));
                        				found = true;
	                        			
	                        			index++;
	                        			if(index == 2){
	                        				index = 0;
	                        			}
                        			}
                        		}
                        		
                        		if(!found){
                        			if(- valx % size <= 97 && - valx % size >= -97){
                        				setData(world, valx, y, valz, (byte) 12);
                            		}
                        			else{
                        				//Hardened Clay, Data: 0
                            		}
                        		}
                        	}
                        }
                        else if(valz % size != 0 && (valx % size == 5 || valx % size == -5 || valx % size == 98 || valx % size == -98)){
                        	if((valx % size == 5 && valz % size == 5) || (valx % size == 5 && valz % size == -5) || (valx % size == -5 && valz % size == 5) || ((valx % size == -5 && valz % size == -5)) || (valx % size == 98 && valz % size == 5) || (valx % size == 98 && valz % size == -5) || (valx % size == -98 && valz % size == 5) || ((valx % size == -98 && valz % size == -5))){
                        		//Hardened Clay, Data: 0
                        	}
                        	else{
                        		List<Byte> data = Arrays.asList((byte) 15, (byte) 12);
                        		
                        		int index = 0;
                        		boolean found = false;
                        		for(int i = 12; i <= plotsize +2; i += 6){
                        			if(- valz % size <= i && - valz % size >= -i){
                        				setData(world, valx, y, valz, data.get(index));
                        				found = true;
	                        			
	                        			index++;
	                        			if(index == 2){
	                        				index = 0;
	                        			}
                        			}
                        		}
                        		
                        		if(!found){
                        			if(- valz % size <= 97 && - valz % size >= -97){
                        				setData(world, valx, y, valz, (byte) 12);
                            		}
                        			else{
                        				//Hardened Clay, Data: 0
                            		}
                        		}
                        	}
                        }
                        else if(valx % size != 0 && (valz % size == 6 || valz % size == -6 || valz % size == 97 || valz % size == -97)){
                    		List<Byte> data = Arrays.asList((byte) 0, (byte) 15);
                    		
                    		int index = 0;
                    		boolean found = false;
                    		for(int i = 12; i <= plotsize +2; i += 6){
                    			if(- valx % size <= i && - valx % size >= -i){
                    				if(index == 1){
                        				setData(world, valx, y, valz, data.get(index));
                    				}
                    				found = true;
                        			
                        			index++;
                        			if(index == 2){
                        				index = 0;
                        			}
                    			}
                    		}
                    		
                    		if(!found){
                    			setData(world, valx, y, valz, (byte) 15);
                    		}
                        }
                        else if(valz % size != 0 && (valx % size == 6 || valx % size == -6 || valx % size == 97 || valx % size == -97)){
                    		List<Byte> data = Arrays.asList((byte) 0, (byte) 15);
                    		
                    		int index = 0;
                    		boolean found = false;
                    		for(int i = 12; i <= plotsize +2; i += 6){
                    			if(- valz % size <= i && - valz % size >= -i){
                    				if(index == 1){
                        				setData(world, valx, y, valz, data.get(index));
                    				}
                    				found = true;
                        			
                        			index++;
                        			if(index == 2){
                        				index = 0;
                        			}
                    			}
                    		}
                    		
                    		if(!found){
                    			setData(world, valx, y, valz, (byte) 15);
                    		}
                        }
                        else if(valz % size != 0 && (valx % size == 7 || valx % size == -7 || valx % size == 96 || valx % size == -96)){
                        	if((valx % size == 7 && valz % size == 7) || (valx % size == 7 && valz % size == -7) || (valx % size == -7 && valz % size == 7) || ((valx % size == -7 && valz % size == -7)) || (valx % size == 96 && valz % size == 7) || (valx % size == 96 && valz % size == -7) || (valx % size == -96 && valz % size == 7) || ((valx % size == -96 && valz % size == -7))){
                        		setData(world, valx, (y +1), valz, (byte) 5);
                            }
                        	else{
                        		List<Byte> data = Arrays.asList((byte) 0, (byte) 3);
                        		
                        		int index = 0;
                        		boolean found = false;
                        		for(int i = 12; i <= plotsize +2; i += 6){
                        			if(- valz % size <= i && - valz % size >= -i){
                        				if(index == 1 && (- valz % size == 12 || - valz % size == -12 || - valz % size == 19 || - valz % size == -19 || - valz % size == 24 || - valz % size == -24 || - valz % size == 31 || - valz % size == -31 || - valz % size == 36 || - valz % size == -36 || - valz % size == 43 || - valz % size == -43 || - valz % size == 48 || - valz % size == -48 || - valz % size == 55 || - valz % size == -55 || - valz % size == 60 || - valz % size == -60 || - valz % size == 67 || - valz % size == -67 || - valz % size == 72 || - valz % size == -72 || - valz % size == 79 || - valz % size == -79 || - valz % size == 84 || - valz % size == -84)){
                        					setData(world, valx, (y +1), valz, (byte) 5);
                        				}
                        				else{
                        					setData(world, valx, (y +1), valz, data.get(index));
                        				}
                        				
                        				found = true;
	                        			
	                        			index++;
	                        			if(index == 2){
	                        				index = 0;
	                        			}
                        			}
                        		}
                        		
                        		if(!found){
                        			if(- valz % size != 91 && - valz % size != -91 && - valz % size != 96 && - valz % size != -96){
                        				setData(world, valx, (y +1), valz, (byte) 3);
                        			}
                        			else{
                        				setData(world, valx, (y +1), valz, (byte) 5);
                        			}
                        		}
                        	}
                        }
                        else if(valx % size != 0 && (valz % size == 7 || valz % size == -7 || valz % size == 96 || valz % size == -96)){
                        	if((valz % size == 7 && valx % size == 7) || (valz % size == 7 && valx % size == -7) || (valz % size == -7 && valx % size == 7) || ((valz % size == -7 && valx % size == -7)) || (valz % size == 96 && valx % size == 7) || (valz % size == 96 && valx % size == -7) || (valz % size == -96 && valx % size == 7) || ((valz % size == -96 && valx % size == -7))){
                        		setData(world, valx, (y +1), valz, (byte) 5);
                            }
                        	else{
                        		List<Byte> data = Arrays.asList((byte) 0, (byte) 3);
                        		
                        		int index = 0;
                        		boolean found = false;
                        		for(int i = 12; i <= plotsize +2; i += 6){
                        			if(- valx % size <= i && - valx % size >= -i){
                        				if(index == 1 && (- valx % size == 12 || - valx % size == -12 || - valx % size == 19 || - valx % size == -19 || - valx % size == 24 || - valx % size == -24 || - valx % size == 31 || - valx % size == -31 || - valx % size == 36 || - valx % size == -36 || - valx % size == 43 || - valx % size == -43 || - valx % size == 48 || - valx % size == -48 || - valx % size == 55 || - valx % size == -55 || - valx % size == 60 || - valx % size == -60 || - valx % size == 67 || - valx % size == -67 || - valx % size == 72 || - valx % size == -72 || - valx % size == 79 || - valx % size == -79 || - valx % size == 84 || - valx % size == -84)){
                        					setData(world, valx, (y +1), valz, (byte) 5);
                        				}
                        				else{
                        					setData(world, valx, (y +1), valz, data.get(index));
                        				}
                        				
                        				found = true;
	                        			
	                        			index++;
	                        			if(index == 2){
	                        				index = 0;
	                        			}
                        			}
                        		}
                        		
                        		if(!found){
                        			if(- valx % size != 91 && - valx % size != -91 && - valx % size != 96 && - valx % size != -96){
                        				setData(world, valx, (y +1), valz, (byte) 3);
                        			}
                        			else{
                        				setData(world, valx, (y +1), valz, (byte) 5);
                        			}
                        		}
                        	}
                        }
                        else if(valz % size == 0 || valx % size == 0 || valz % size == 103 || valx % size == 103 || valz % size == -103 || valx % size == -103){
                        	if(valz % size == 0 && valx % size == 0 || valz % size == 103 && valx % size == 103 || valz % size == -103 && valx % size == -103){
                        		setData(world, valx, y, valz, (byte) 12);
                        	}
                        	else if(valz % size - valx % size <= 1 && valz % size - valx % size >= -1 || valz % size - valx % size <= 104 && valz % size - valx % size >= 102 || valz % size - valx % size <= -102 && valz % size - valx % size >= -104){
                        		setData(world, valx, y, valz, (byte) 15);
                        	}
                        	else{
                        		List<Byte> data = Arrays.asList((byte) 12, (byte) 0);
                        		
                        		int index = 0;
                        		boolean found = false;
                        		for(int i = 12; i <= plotsize +2; i += 6){
                        			if(valz % size - valx % size <= i && valz % size - valx % size >= -i){
                        				if(index == 0){
                        					setData(world, valx, y, valz, data.get(index));
                        				}
                        				found = true;
	                        			
	                        			index++;
	                        			if(index == 2){
	                        				index = 0;
	                        			}
                        			}
                        		}
                        		
                        		if(!found){
                        			if(- valx % size <= 101 && - valx % size >= -101){
                        				//Hardened Clay, Data: 0
                        			}
                        			else{
                        				setData(world, valx, y, valz, (byte) 15);
                        			}
                        		}
                        	}
                        }
                        else{}
                    } 
                }
            }
        }
	}

    @SuppressWarnings("deprecation")
    private void setData(World w, int x, int y, int z, byte b) {
        w.getBlockAt(x, y, z).setData(b);
    }
}