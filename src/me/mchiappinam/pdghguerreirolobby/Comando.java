package me.mchiappinam.pdghguerreirolobby;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Comando implements CommandExecutor {
	private Main plugin;
	public Comando(Main main) {
		plugin=main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("guerreiro")) {
			if(args.length>0) {
				sender.sendMessage("§cUse /guerreiro");
				return true;
			}
			if(sender==plugin.getServer().getConsoleSender()) {
				sender.sendMessage("§3§l[Guerreiro] §cConsole bloqueado de executar o comando!");
				return true;
			}
			if(plugin.etapa==0) {
				sender.sendMessage("§3§l[Guerreiro] §cO evento guerreiro não está acontecendo!");
				return true;
			}else if(plugin.etapa==2) {
				sender.sendMessage("§3§l[Guerreiro] §cO evento já está acontecendo!");
				return true;
			}
            if(((Player)sender).isInsideVehicle()) {
			     sender.sendMessage("§3§l[Guerreiro] §cVocê está dentro de um veículo!");
			     return true;
			}
            if(((Player)sender).isDead()) {
			     sender.sendMessage("§3§l[Guerreiro] §cVocê está morto!");
			     return true;
			}
			plugin.addPlayer((Player)sender);
			return true;
		}
		return true;
	}
	
	private void sendHelp(Player p) {
		p.sendMessage("§d§lPDGHGuerreiro - Comandos do plugin:");
		p.sendMessage("§2/guerreiro ? -§a- Lista de comandos");
		p.sendMessage("§c/guerreiro forcestart -§a- Força o inicio do evento guerreiro");
		p.sendMessage("§c/guerreiro forcestop -§a- Força a parada do evento guerreiro");
		p.sendMessage("§2/guerreiro kick <nome> -§a- Kicka um jogador do evento guerreiro");
		p.sendMessage("§2/guerreiro ban <nome> -§a- Bane um jogador do evento guerreiro");
		p.sendMessage("§2/guerreiro unban <nome> -§a- Desbane um jogador do evento guerreiro");
		p.sendMessage("§2/guerreiro setspawn -§a- Marca local de spawn do evento guerreiro");
		p.sendMessage("§2/guerreiro setsaida -§a- Marca local de saida do evento guerreiro");
		p.sendMessage("§2/guerreiro setarenamenor -§a- Marca local da arena menor do evento guerreiro");
		p.sendMessage("§2/guerreiro info -§a- Mostra quantos jogadores estão dentro do evento guerreiro");
	}

}
