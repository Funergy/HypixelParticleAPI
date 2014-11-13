/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.particleapi.Handlers;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Funergy
 *
 */
public class ParticleUsers {
	private static ArrayList<UUID> list = new ArrayList<UUID>();
	
	public static boolean hasParticles(UUID uuid){
		return list.contains(uuid);
	}
	public static void addPlayerToList(UUID uuid){
		if(!list.contains(uuid)){
		list.add(uuid);
		}else{
		System.out.println("[ERROR] Error adding player to list!");
		System.out.println("[ERROR] Player is already in list!");
		}
	}
	public static void removePlayer(UUID uuid){
	if(list.contains(uuid)){
		list.remove(uuid);
	}else{
		System.out.println("[ERROR] Error removing player from list!");
		System.out.println("[ERROR] Player doesn't contain in the list!");

	}
	}

}
