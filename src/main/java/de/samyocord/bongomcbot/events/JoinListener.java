package de.samyocord.bongomcbot.events;

import de.samyocord.bongomcbot.utils.MessageLogger;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class JoinListener extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        event.getGuild().getTextChannelById("502199856073539584").sendMessage(new EmbedBuilder().setTitle("Neuer User").setDescription(event.getMember().getAsMention() + " ist uns gerade beigetreten").setThumbnail(event.getMember().getUser().getAvatarUrl()).build());
        try {
            MessageLogger.addJoin(event.getMember().getAsMention());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
