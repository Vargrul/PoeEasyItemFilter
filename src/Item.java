import java.util.ArrayList;

import enums.*;


public class Item {

	boolean show;
	int itemLevel = -1;
	String itemLevelCond = null;
	int dropLevel = -1;
	String DropLevelCond = null;
	int quality = -1;
	String qualityCond = null;
	Rarity rarity = null;
	String rarityCond = null;
	ArrayList<String> itemClass = new ArrayList<String>();
	String baseType = null;
	int sockets = -1;
	String socketsCond = null;
	int linkedSockets = -1;
	String linkedSocketsCond = null;
	String socketGroup = null;
	int height = -1;
	String heightCond = null;
	int width = -1;
	String widthCond = null;
	
	int[] boarderColor = {-1,-1,-1,-1};
	int[] backgroundColor = {-1,-1,-1,-1};
	int[] textColor = {-1,-1,-1,-1};
	int fontSize = -1;
	int sound = -1;
	int soundVolume = -1;
	
	public Item(boolean show){
		this.show = show;
	}
	
	public int getItemLevel() {
		return itemLevel;
	}
	public void setItemLevel(int itemLevel) {
		this.itemLevel = itemLevel;
	}
	public String getItemLevelCond() {
		return itemLevelCond;
	}

	public void setItemLevelCond(String itemLevelCond) {
		this.itemLevelCond = itemLevelCond;
	}

	public int getDropLevel() {
		return dropLevel;
	}
	public void setDropLevel(int dropLevel) {
		this.dropLevel = dropLevel;
	}
	public String getDropLevelCond() {
		return DropLevelCond;
	}

	public void setDropLevelCond(String dropLevelCond) {
		DropLevelCond = dropLevelCond;
	}

	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	public String getQualityCond() {
		return qualityCond;
	}

	public void setQualityCond(String qualityCond) {
		this.qualityCond = qualityCond;
	}

	public Rarity getRarity() {
		return rarity;
	}
	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}
	public String getRarityCond() {
		return rarityCond;
	}

	public void setRarityCond(String rarityCond) {
		this.rarityCond = rarityCond;
	}
	public ArrayList<String> getItemClass() {
		return itemClass;
	}

	public void setItemClass(ArrayList<String> itemClass) {
		this.itemClass = itemClass;
	}
	
	public void addItemClass(String itemClass){
		this.itemClass.add(itemClass);
	}

	public String getBaseType() {
		return baseType;
	}
	public void setBaseType(String baseType) {
		this.baseType = baseType;
	}
	public int getSockets() {
		return sockets;
	}
	public void setSockets(int sockets) {
		this.sockets = sockets;
	}
	public String getSocketsCond() {
		return socketsCond;
	}

	public void setSocketsCond(String socketsCond) {
		this.socketsCond = socketsCond;
	}

	public int getLinkedSockets() {
		return linkedSockets;
	}
	public void setLinkedSockets(int linkedSockets) {
		this.linkedSockets = linkedSockets;
	}
	public String getLinkedSocketsCond() {
		return linkedSocketsCond;
	}

	public void setLinkedSocketsCond(String linkedSocketsCond) {
		this.linkedSocketsCond = linkedSocketsCond;
	}

	public String getSocketGroup() {
		return socketGroup;
	}
	public void setSocketGroup(String socketGroup) {
		this.socketGroup = socketGroup;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getHeightCond() {
		return heightCond;
	}

	public void setHeightCond(String heightCond) {
		this.heightCond = heightCond;
	}

	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public String getWidthCond() {
		return widthCond;
	}

	public void setWidthCond(String widthCond) {
		this.widthCond = widthCond;
	}

	public boolean isShow() {
		return show;
	}
	public void setShow(boolean show) {
		this.show = show;
	}
	public int[] getBoarderColor() {
		return boarderColor;
	}
	public void setBoarderColor(int[] boarderColor) {
		this.boarderColor = boarderColor;
	}
	public int[] getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(int[] backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public int[] getTextColor() {
		return textColor;
	}
	public void setTextColor(int[] textColor) {
		this.textColor = textColor;
	}
	public int getFontSize() {
		return fontSize;
	}
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	public int getSound() {
		return sound;
	}
	public void setSound(int sound) {
		this.sound = sound;
	}
	public int getSoundVolume() {
		return soundVolume;
	}
	public void setSoundVolume(int soundVolume) {
		this.soundVolume = soundVolume;
	}
}