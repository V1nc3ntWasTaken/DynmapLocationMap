package me.v1nc3ntwastaken.dynmaplocationmap.commands;

import me.v1nc3ntwastaken.dynmaplocationmap.config.ConfigurationHandler;
import me.v1nc3ntwastaken.dynmaplocationmap.utils.ComponentBuilder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Entity;

public class MapCommand extends ComponentBuilder implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String link = buildBaseLink();

        if (sender instanceof ConsoleCommandSender) {
            // |--------------------
            sender.spigot().sendMessage(
                    buildBeginningSpacerComponent(),
                    buildUpDownSpacerComponent(20)
            );
            // |   Available Map Links:
            sender.spigot().sendMessage(
                    buildBeginningSpacerComponent(),
                    buildTextSpacerComponent(),
                    buildAvailableLinksTextComponent()
            );
            // |    Map Link: LINK
            sender.spigot().sendMessage(
                    buildBeginningSpacerComponent(),
                    buildTextSpacerComponent(),
                    buildMapLinkHereTextComponent(),
                    buildBaseLinkComponent(buildBaseLink()));
            // |--------------------
            sender.spigot().sendMessage(
                    buildBeginningSpacerComponent(),
                    buildUpDownSpacerComponent(20)
            );
        } else {
            Entity entity = (Entity) sender;

            // |--------------------
            sender.spigot().sendMessage(
                    buildBeginningSpacerComponent(),
                    buildUpDownSpacerComponent(20)
            );
            // |   Available Map Links:
            sender.spigot().sendMessage(
                    buildBeginningSpacerComponent(),
                    buildTextSpacerComponent(),
                    buildAvailableLinksTextComponent()
            );
            // |    Map Link: LINK
            sender.spigot().sendMessage(
                    buildBeginningSpacerComponent(),
                    buildTextSpacerComponent(),
                    buildBaseLinkComponent("Map Link"));
            // |    World Link: LINK
            if (!ConfigurationHandler.getDisabledWorldWorlds().contains(entity.getLocation().getWorld().getName())) {
                sender.spigot().sendMessage(
                        buildBeginningSpacerComponent(),
                        buildTextSpacerComponent(),
                        buildWorldLinkComponent("World Link", entity.getLocation()));
            }
            if (!ConfigurationHandler.getDisabledLocationWorlds().contains(entity.getLocation().getWorld().getName())) {
                // |    Location Link: LINK
                sender.spigot().sendMessage(
                        buildBeginningSpacerComponent(),
                        buildTextSpacerComponent(),
                        buildLocationLinkComponent("Location Link", entity.getLocation()));
            }
            if (!ConfigurationHandler.getDisabledFlatWorlds().contains(entity.getLocation().getWorld().getName())) {
                // |    Flat Link: LINK
                sender.spigot().sendMessage(
                        buildBeginningSpacerComponent(),
                        buildTextSpacerComponent(),
                        buildFlatLinkComponent("Flat Link", entity.getLocation()));
            }
            if (!ConfigurationHandler.getDisabledSurfaceWorlds().contains(entity.getLocation().getWorld().getName())) {
                // |    Surface Link: LINK
                sender.spigot().sendMessage(
                        buildBeginningSpacerComponent(),
                        buildTextSpacerComponent(),
                        buildSurfaceLinkComponent("Surface Link", entity.getLocation()));
            }
            if (!ConfigurationHandler.getDisabledCaveWorlds().contains(entity.getLocation().getWorld().getName())) {
                // |    Cave Link: LINK
                sender.spigot().sendMessage(
                        buildBeginningSpacerComponent(),
                        buildTextSpacerComponent(),
                        buildCaveLinkComponent("Cave Link", entity.getLocation()));
            }
            // |--------------------
            sender.spigot().sendMessage(
                    buildBeginningSpacerComponent(),
                    buildUpDownSpacerComponent(20)
            );

        }

        return true;
    }
}
