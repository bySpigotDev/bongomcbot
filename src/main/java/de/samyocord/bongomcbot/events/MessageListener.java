package de.samyocord.bongomcbot.events;

import de.samyocord.bongomcbot.utils.MessageLogger;
import de.samyocord.bongomcbot.utils.music.MusicPlayer;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;

public class MessageListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String msg = event.getMessage().getContentRaw();
        System.out.println(msg);
        try {
            MessageLogger.addMessage(event.getAuthor().getAsMention(), msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (msg.startsWith("!")){
            if (msg.equalsIgnoreCase("!fabi")){
                try {
                    event.getChannel().sendFile(new URL("https://minotar.net/avatar/264239f1-a732-4ff9-a7ca-41184f177ea8").openConnection().getInputStream(), "fabiii.png").queue();
                } catch (IOException e) {
                    StringWriter sw = new StringWriter();
                    e.printStackTrace(new PrintWriter(sw));
                    String eas = sw.toString();
                    event.getChannel().sendMessage(eas).queue();
                }
            }
            if (msg.equalsIgnoreCase("!radio")){
                if (event.getMember().hasPermission(Permission.ADMINISTRATOR)){
                    try{
                        MusicPlayer mp = new MusicPlayer();
                        mp.loadAndPlay(event.getTextChannel(), "http://stream.laut.fm/cityradio");
                    } catch (Exception e){
                        StringWriter sw = new StringWriter();
                        e.printStackTrace(new PrintWriter(sw));
                        String eas = sw.toString();
                        event.getChannel().sendMessage(eas).queue();
                    }
                } else {
                    event.getChannel().sendMessage("Nope").queue();
                }
            }
        }
    }
}
