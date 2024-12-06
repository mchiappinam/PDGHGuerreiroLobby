package me.mchiappinam.pdghguerreirolobby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Threads extends Thread {
	private Main plugin;
	private String tipo;
	
	private String p_string;
	private int numero;
	private Player player;
	public Threads(Main pl,String tipo2,String player) {
		plugin=pl;
		tipo=tipo2;
		p_string=player;
	}
	public Threads(Main pl,String tipo2,String player,String pkilled) {
		plugin=pl;
		tipo=tipo2;
		p_string=player;
	}
	public Threads(Main pl,String tipo2,Player player2) {
		plugin=pl;
		tipo=tipo2;
		player=player2;
	}
	public Threads(Main pl,String tipo2,List<String> l2,Player p2) {
		plugin=pl;
		tipo=tipo2;
		player=p2;
	}
	public Threads(Main pl,String tipo2,Player p,String p2,int num) {
		plugin=pl;
		tipo=tipo2;
		p_string=p2.trim();
		numero=num;
		player=p;
	}
	public Threads(Main pl,String tipo2,Player player2,String p3,boolean bool2) {
		plugin=pl;
		tipo=tipo2;
		player=player2;
		p_string=p3.trim();
	}
	public Threads(Main pl, String tipo2) {
		plugin=pl;
		tipo=tipo2;
	}
	
	public void run() {
		switch(tipo) {
			case "sendguerreiro": {
				try {
					Connection con = DriverManager.getConnection(plugin.mysql_url,plugin.mysql_user,plugin.mysql_pass);
					PreparedStatement pst3 = con.prepareStatement("SELECT `kills` FROM `rankpvp` WHERE `nome`='"+p_string.trim()+"';");
					ResultSet rs2 = pst3.executeQuery();
					if(!rs2.isBeforeFirst()) {
						PreparedStatement pst5 = con.prepareStatement("INSERT INTO `guerreiro` (`nome`,`kills`,`deaths`,`kd`) VALUES ('"+p_string.trim()+"',0,0,0);");
						pst5.execute();
						pst5.close();
					}
					rs2.close();
					pst3.close();
					con.close();
				}
				catch(Exception e3) {}
				break;
			}
		}
	}
}
