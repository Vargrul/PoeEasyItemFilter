import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import enums.Rarity;


public class ItemFilter {

	String path="";
	String fileName ="";
	ArrayList<Item> items = new ArrayList<Item>();
	
	
	public ItemFilter(String path, String fileName) {
		this.path = path;
		this.fileName = fileName;
	}
	public ItemFilter(String path, String fileName, ArrayList<Item> items) {
		this.path = path;
		this.fileName = fileName;
		this.items = items;
	}

	public boolean load(){
		BufferedReader reader = null;
		
		try {
			File file = new File(this.path + this.fileName);
			reader = new BufferedReader(new FileReader(file));
			
			String line;
			while((line = reader.readLine()) != null){
				String cmd = null, attribute = null;
				//Remove white spaces at beginning
				line = line.trim();
				line = line.replace((char) 9, ' ');
				
				if(!line.startsWith("#") && !line.isEmpty()){
					//Remove trailing comments
					int subIndex = line.indexOf('#');
					if(subIndex != -1)
						line = line.substring(0,subIndex);
					
					subIndex = line.indexOf(' ');
					if(subIndex != -1){
						cmd = line.substring(0,subIndex);
						attribute = line.substring(subIndex+1);
					} else {
						cmd = line;
					}
					
					
					/*========== Show ==========*/
					if (cmd.compareTo("Show") == 0){
						items.add(new Item(true));
					
					/*========== Hide ==========*/
					} else if (cmd.compareTo("Hide") == 0) {
						items.add(new Item(false));
					
					/*========== ItemLevel ==========*/
					} else if (cmd.compareTo("ItemLevel") == 0){
						String cond = null;
						subIndex = attribute.indexOf(' ');
						if(subIndex != -1){
							cond = attribute.substring(0,subIndex);
							attribute = attribute.substring(subIndex+1);
						}
						items.get(items.size()-1).setItemLevelCond(cond);
						items.get(items.size()-1).setItemLevel(Integer.parseInt(attribute));
					
					/*========== DropLevel ==========*/	
					} else if (cmd.compareTo("DropLevel") == 0){
						String cond = null;
						subIndex = attribute.indexOf(' ');
						if(subIndex != -1){
							cond = attribute.substring(0,subIndex);
							attribute = attribute.substring(subIndex+1);
						}
						
						items.get(items.size()-1).setDropLevelCond(cond);
						items.get(items.size()-1).setDropLevel(Integer.parseInt(attribute));

					/*========== Quality ==========*/		
					} else if (cmd.compareTo("Quality") == 0){
						String cond = null;
						subIndex = attribute.indexOf(' ');
						if(subIndex != -1){
							cond = attribute.substring(0,subIndex);
							attribute = attribute.substring(subIndex+1);
						}
						
						items.get(items.size()-1).setQualityCond(cond);
						items.get(items.size()-1).setQuality(Integer.parseInt(attribute));
						
					/*========== Rarity ==========*/
					} else if (cmd.compareTo("Rarity") == 0){
						String cond = null;
						subIndex = attribute.indexOf(' ');
						if(subIndex != -1){
							cond = attribute.substring(0,subIndex);
							attribute = attribute.substring(subIndex+1);
						}
						
						items.get(items.size()-1).setRarityCond(cond);
						items.get(items.size()-1).setRarity(Rarity.valueOf(attribute.toUpperCase()));
						
					/*========== ItemClass ==========*/
					} else if (cmd.compareTo("Class") == 0){
						attribute.trim();
						
						while(true){
							String temp = attribute.substring(1,attribute.substring(1).indexOf('\"')+1);
							
							items.get(items.size()-1).addItemClass(temp);
							
							if(attribute.length() >= temp.length()+3){
								attribute = attribute.substring(temp.length()+3);
								attribute.trim();
							}
							else
								break;
						}
						
					/*========== BaseType ==========*/
					} else if (cmd.compareTo("BaseType") == 0){
						items.get(items.size()-1).setBaseType(attribute);
						
					/*========== Sockets ==========*/
					} else if (cmd.compareTo("Sockets") == 0){
						String cond = null;
						subIndex = attribute.indexOf(' ');
						if(subIndex != -1){
							cond = attribute.substring(0,subIndex);
							attribute = attribute.substring(subIndex+1);
						}
						
						items.get(items.size()-1).setSockets(Integer.parseInt(attribute));
						items.get(items.size()-1).setSocketsCond(cond);
						
					/*========== LinkedSockets ==========*/	
					} else if (cmd.compareTo("LinkedSockets") == 0){
						String cond = null;
						subIndex = attribute.indexOf(' ');
						if(subIndex != -1){
							cond = attribute.substring(0,subIndex);
							attribute = attribute.substring(subIndex+1);
						}
						
						items.get(items.size()-1).setLinkedSockets(Integer.parseInt(attribute));
						items.get(items.size()-1).setLinkedSocketsCond(cond);
					
					/*========== SocketGroup ==========*/
					} else if (cmd.compareTo("SocketGroup") == 0){
						items.get(items.size()-1).setSocketGroup(attribute);
						
					/*========== Height ==========*/
					} else if (cmd.compareTo("Height") == 0){
						String cond = null;
						subIndex = attribute.indexOf(' ');
						if(subIndex != -1){
							cond = attribute.substring(0,subIndex);
							attribute = attribute.substring(subIndex+1);
						}
						
						items.get(items.size()-1).setHeight(Integer.parseInt(attribute));
						items.get(items.size()-1).setHeightCond(cond);
						
					/*========== Width ==========*/						
					} else if (cmd.compareTo("Width") == 0){
						String cond = null;
						subIndex = attribute.indexOf(' ');
						if(subIndex != -1){
							cond = attribute.substring(0,subIndex);
							attribute = attribute.substring(subIndex+1);
						}
						
						items.get(items.size()-1).setWidth(Integer.parseInt(attribute));
						items.get(items.size()-1).setWidthCond(cond);
						
					/*========== SetBorderColor ==========*/
					} else if (cmd.compareTo("SetBorderColor") == 0){
						int[] temp = {-1,-1,-1,-1};
						
						for(int i = 0 ; i < 4 ; i++){
							subIndex = attribute.indexOf(' ');
							if(subIndex != -1){
								temp[i] = Integer.parseInt(attribute.substring(0,subIndex));
								attribute = attribute.substring(subIndex);
								attribute = attribute.trim();	
							} else {
								temp[i] = Integer.parseInt(attribute);
							}
						}
						
						items.get(items.size()-1).setBoarderColor(temp);
						
					/*========== SetBackgroundColor ==========*/
					} else if (cmd.compareTo("SetBackgroundColor") == 0){
						int[] temp = {-1,-1,-1,-1};
						
						for(int i = 0 ; i < 4 ; i++){
							subIndex = attribute.indexOf(' ');
							if(subIndex != -1){
								temp[i] = Integer.parseInt(attribute.substring(0,subIndex));
								attribute = attribute.substring(subIndex);
								attribute = attribute.trim();	
							} else {
								temp[i] = Integer.parseInt(attribute);
							}
						}
						
						items.get(items.size()-1).setBackgroundColor(temp);
						
					/*========== SetTextColor ==========*/
					} else if (cmd.compareTo("SetTextColor") == 0){
						int[] temp = {-1,-1,-1,-1};
						
						for(int i = 0 ; i < 4 ; i++){
							subIndex = attribute.indexOf(' ');
							if(subIndex != -1){
								temp[i] = Integer.parseInt(attribute.substring(0,subIndex));
								attribute = attribute.substring(subIndex);
								attribute = attribute.trim();	
							} else {
								temp[i] = Integer.parseInt(attribute);
							}
						}
						
						items.get(items.size()-1).setTextColor(temp);
						
					/*========== SetFontSize ==========*/
					} else if (cmd.compareTo("SetFontSize") == 0){
						items.get(items.size()-1).setFontSize(Integer.parseInt(attribute));
						
					/*========== PlayAlertSound ==========*/
					} else if (cmd.compareTo("PlayAlertSound") == 0){
						subIndex = attribute.indexOf(' ');
						if(subIndex != -1){
							items.get(items.size()-1).setSound(Integer.parseInt(attribute.substring(0,subIndex)));
							items.get(items.size()-1).setSoundVolume(Integer.parseInt(attribute.substring(subIndex+1)));
						} else
							items.get(items.size()-1).setSound(Integer.parseInt(attribute));
					} else {
						System.out.println("cmd not found!!");
					}
					
					
					//Doing stuff with each line
					//System.out.println("Command   :" + cmd);
					//System.out.println("Attribute :" + attribute);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try{			
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	public boolean write(String fileName){
		BufferedWriter writer = null;
		try {
			FileWriter file = new FileWriter(this.path + fileName + ".txt");
			writer = new BufferedWriter(file);
			
			writer.write("FooBar2");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try{			
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
}
