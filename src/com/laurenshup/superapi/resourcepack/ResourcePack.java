package com.laurenshup.superapi.resourcepack;

/**
 * This is the class for a resource pack.
 * 
 * @author Laurenshup
 */
public class ResourcePack {
	
	private String path;
	
	/**
	 * @param path the path to the .zip file
	 */
	public ResourcePack(String path) {
		this.path = path;
	}
	
	/**
	 * Gives the resource pack path.
	 * 
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

}
