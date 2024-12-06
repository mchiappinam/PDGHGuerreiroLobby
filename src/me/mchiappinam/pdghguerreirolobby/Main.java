package me.mchiappinam.pdghguerreirolobby;

import java.util.Calendar;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	protected int etapa = 0;
	
	//Mysql
    protected String mysql_url = "";
    protected String mysql_user = "";
    protected String mysql_pass = "";
    protected boolean flatfile = true;
    protected String servidor="ERRO";
	
	@Override
    public void onEnable() {
		getServer().getConsoleSender().sendMessage("§3[GuerreiroLobby] §2dativando... - Plugin by: mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[GuerreiroLobby] §2Acesse: http://pdgh.com.br/");
		
		getServer().getPluginManager().registerEvents(new Listeners(this), this);
		getServer().getPluginCommand("guerreiro").setExecutor(new Comando(this));

		if(getServer().getPluginManager().getPlugin("PDGHReportar")!=null) {
			getServer().getConsoleSender().sendMessage("§2Hooked to PDGHReportar!");
		}else{
			getLogger().warning("ERRO: PDGHReportar nao encontrado!");
			getServer().getPluginManager().disablePlugin(this);
		}
		updateServer();
		getServer().getScheduler().runTaskTimer(this, new Runnable() {
			public void run() {
				if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
					if(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)==13)
						if(Calendar.getInstance().get(Calendar.MINUTE)==00) {
							//prepareGuerreiro();
						}
			}
		}, 0, 100);
	}
	
	@Override
    public void onDisable() {
		getServer().getConsoleSender().sendMessage("§3[Guerreiro] §2desativado - Plugin by: mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[Guerreiro] §2Acesse: http://pdgh.com.br/");
	}

	public void updateServer() {
		servidor=me.mchiappinam.pdghreportar.Main.servidor;
	}

	public void addPlayer(Player p) {
		Threads t = new Threads(this,"sendguerreiro",p);
		t.start();
	}
}
