package de.samyocord.bongomcbot.events;

import de.samyocord.bongomcbot.utils.MessageLogger;
import net.dv8tion.jda.core.events.guild.member.GuildMemberNickChangeEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class NickChangeListener extends ListenerAdapter {

    @Override
    public void onGuildMemberNickChange(GuildMemberNickChangeEvent event) {
        try {
            MessageLogger.addNickChange(event.getMember().getAsMention(), event.getPrevNick(), event.getNewNick());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
