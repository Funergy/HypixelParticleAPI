/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.particleapi.Handlers;

import java.lang.reflect.InvocationTargetException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.funergy.particleapi.HypixelParticleAPI;
import com.funergy.particleapi.Utils.ParticleUtils;

/**
 * @author Funergy
 *
 */
public class Particle {
	private Player p;
	private ParticleEffects particle;
	
	//Create new particle
	public Particle(Player p){
		this.p = p;
	}
	//Set the particle
	public void setParticle(ParticleEffects s){
		this.particle = s;
	}
	//Run it
	public void run(){
		if(particle != null){
		ParticleUsers.addPlayerToList(p.getUniqueId());
		new BukkitRunnable(){ 
			  
            double a = 0;
 
            @Override
            public void run(){
                if(p.isOnline()||ParticleUsers.hasParticles(p.getUniqueId())){
        			Location eye = p.getEyeLocation();
        			if (a < 360.0) {
        				if(a == 324.0){
        					a = 0;		
        				}else{
        				a += 36;
        				}
        			} else {
        				a = 0;
        			}
        			double x;
        			double y = eye.getY() + 0.3;
        			double z;

        			double angle = a * Math.PI / 180;
        			x = (double) (eye.getX() + 0.5 * Math.cos(angle));
        			z = (double) (eye.getZ() + 0.5 * Math.sin(angle));
        			
        			try {
        				for(Player online : Bukkit.getOnlinePlayers()){
						ParticleUtils.spawnParticles(x,y,z, online, particle.toString(), 1);
        				}
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchFieldException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
        	}else{
        		this.cancel();
        		return;
        	}
            }
            
        }.runTaskTimer(HypixelParticleAPI.getPlugin(HypixelParticleAPI.class), 0, 2); 
	}else{
		System.out.println("[ERROR] Cannot Play particle!");
		System.out.println("[ERROR] You haven't defined your particle effect!");
	}
	}

}
