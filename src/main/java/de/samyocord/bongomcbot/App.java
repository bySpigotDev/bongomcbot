package de.samyocord.bongomcbot;

import de.samyocord.bongomcbot.events.JoinListener;
import de.samyocord.bongomcbot.events.LeaveListener;
import de.samyocord.bongomcbot.events.MessageListener;
import de.samyocord.bongomcbot.events.NickChangeListener;
import de.samyocord.bongomcbot.utils.MessageLogger;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;

import javax.security.auth.login.LoginException;

public class App {

    public static JDA jda;

    public static void main(String[] args) {
        try {
            jda = new JDABuilder(AccountType.BOT).setToken("NTAyMTk5MjQ1NjIxNjkwMzc4.DqkfGg.BxPeb5vnyTH_rU-0u5VWQKwwI-8").build();
            jda.getPresence().setGame(Game.listening("Fabian"));
            jda.addEventListener(new MessageListener());
            jda.addEventListener(new JoinListener());
            jda.addEventListener(new LeaveListener());
            jda.addEventListener(new NickChangeListener());
            MessageLogger.load();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

}
