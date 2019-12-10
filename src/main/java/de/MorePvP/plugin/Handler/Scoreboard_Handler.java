package de.MorePvP.plugin.Handler;

import de.MorePvP.plugin.Lobby;
import de.MorePvP.plugin.Utils.STATICS;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class Scoreboard_Handler {

    private static Integer animationCount;
    String rank;

    private String[] animation = new String[] {
            "§8•", "§8• §6§lM", "§8• §6§lMo", "§8• §6§lMor", "§8• §6§lMore", "§8• §6§lMore§c§lP", "§8• §6§lMore§c§lPv", "§8• §6§lMore§c§lPvP", "§8• §6§lMore§c§lPv", "§8• §6§lMore§c§lP", "§8• §6§lMore", "§8• §6§lMor", "§8• §6§lMo", "§8• §6§lM"
    };

    public void setScoreboard(final Player player) {
        final Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        final Objective objective = scoreboard.registerNewObjective("main-content", "dummy");

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(animation[animationCount]);

        if (player.hasPermission(STATICS.PERMS_PREFIX + "rank.owner")) {
            rank = "§4Owner";
        } else if (player.hasPermission(STATICS.PERMS_PREFIX + "rank.admin")) {
            rank = "§4Admin";
        } else if (player.hasPermission(STATICS.PERMS_PREFIX + "rank.developer")) {
            rank = "§bDeveloper";
        } else if (player.hasPermission(STATICS.PERMS_PREFIX + "rank.mod")) {
            rank = "§cModerator";
        } else if (player.hasPermission(STATICS.PERMS_PREFIX + "rank.sup")) {
            rank = "§9Supporter";
        } else if (player.hasPermission(STATICS.PERMS_PREFIX + "rank.srbuilder")) {
            rank = "§eSrBuilder";
        } else if (player.hasPermission(STATICS.PERMS_PREFIX + "rank.builder")) {
            rank = "§eBuilder";
        } else if (player.hasPermission(STATICS.PERMS_PREFIX + "rank.yt")) {
            rank = "§5YouTuber";
        } else {
            rank = "§7Spieler";
        }

        objective.getScore("§6§l× §8┃ §f§lRank").setScore(9);
        objective.getScore("§8» " + rank).setScore(8);

        player.setScoreboard(scoreboard);
    }

    public void startAnimation() {
        animationCount = 0;
        Bukkit.getScheduler().runTaskTimer(Lobby.getPlugin(Lobby.class), new Runnable() {
            @Override
            public void run() {
                Bukkit.getOnlinePlayers().forEach(current -> {

                    if (current.getScoreboard() == null)
                        setScoreboard(current);

                        current.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(animation[animationCount]);
                });

                animationCount++;

                if (animationCount == animation.length) {
                    animationCount = 0;
                }

            }
        },0 ,10);
    }
}