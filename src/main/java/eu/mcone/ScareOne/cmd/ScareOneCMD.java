package eu.mcone.ScareOne.cmd;

import eu.mcone.ScareOne.ScareOne;
import eu.mcone.coresystem.api.bukkit.command.CoreCommand;
import org.bukkit.command.CommandSender;

public class ScareOneCMD extends CoreCommand {

    public ScareOneCMD() {
        super("scareone");
    }

    @Override
    public boolean onCommand(CommandSender sender, String[] strings) {
        ScareOne.getInstance().getMessenger().sendSender(sender, "§8§m---------- §r§4§lMCONE-ScareOne §8§m----------");
        ScareOne.getInstance().getMessenger().sendSender(sender, "§7Entwickelt von §fMarvio");
        ScareOne.getInstance().getMessenger().sendSender(sender, "§r");
        ScareOne.getInstance().getMessenger().sendSender(sender, "§7§oWir bemühen uns darum alle Systeme und Spielmodi so effizient wie möglich zu gestalten.");
        ScareOne.getInstance().getMessenger().sendSender(sender, "§7§oDeshalb sind auch alle von uns verwendeten Plugins ausschließlich selbst entwickelt!");
        ScareOne.getInstance().getMessenger().sendSender(sender, "§8§m---------- §r§4§lMCONE-ScareOne §8§m----------");

        return true;
    }
}
