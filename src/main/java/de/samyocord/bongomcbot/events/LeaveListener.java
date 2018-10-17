package de.samyocord.bongomcbot.events;

import de.samyocord.bongomcbot.utils.MessageLogger;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class LeaveListener extends ListenerAdapter {

    @Override
    public void onGuildMemberLeave(GuildMemberLeaveEvent event) {
        event.getGuild().getTextChannelById("502199856073539584").sendMessage(new EmbedBuilder().setTitle("User hat geleavt").setDescription(event.getMember().getAsMention() + " hat uns gerade verlassen :c").setThumbnail(event.getMember().getUser().getAvatarUrl()).build());
        try {
            MessageLogger.addLeave(event.getMember().getAsMention());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
