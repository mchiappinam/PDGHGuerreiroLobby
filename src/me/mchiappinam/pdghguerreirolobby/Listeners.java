package me.mchiappinam.pdghguerreirolobby;

import me.mchiappinam.pdghguerreirolobby.Threads;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Listeners implements Listener {
	private Main plugin;
	public Listeners(Main main) {
		plugin=main;
	}
	
	@EventHandler
	private void onJoin(PlayerJoinEvent e) {
		Threads t = new Threads(plugin,"join",e.getPlayer().getName());
		t.start();
	}
}
