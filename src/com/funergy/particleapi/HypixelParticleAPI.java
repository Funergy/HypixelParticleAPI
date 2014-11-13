/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.particleapi;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Funergy
 *
 */
public class HypixelParticleAPI extends JavaPlugin{
	/*
	 * I haven't tested this yet.
	 * if you experience errors in your console,
	 * please post a support ticket on Github!
	 */
	
	/**
	 * Usage of this plugin
	 * 
	 * To create a particle use
	 * Particle particle = new Particle(<Your player>);
	 * 
	 * Then we select the particle we want to display!
	 * particle.setParticle(ParticleEffects.ANGRY_VILLAGER);
	 * 
	 * And then to play it do
	 * particle.run();
	 * 
	 * TO REMOVE THE PARTICLE OF HIM USE
	 * ParticleUsers.removePlayer(<Your player>.getUniqueId());
	 * 
	 * 
	 * And at least:
	 * If you do a reload the whole plugin will reset!
	 * so this means it will no longer show particles.
	 * You have to create a particle again!
	 */

}
