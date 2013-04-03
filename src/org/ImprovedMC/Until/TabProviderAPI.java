package org.ImprovedMC.Until;

import java.util.ArrayList;


import net.minecraft.server.v1_5_R2.EntityPlayer;
import net.minecraft.server.v1_5_R2.Packet201PlayerInfo;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_5_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class TabProviderAPI extends JavaPlugin
  implements Listener
{

private ArrayList<String> nachrichten = new ArrayList<String>();

  public static String shortenString(String nachricht)
  {
    int length = nachricht.length();

    if (length > 16)
    {
      nachricht = nachricht.substring(-13) + "...";
    }

    if (length == 15)
    {
      nachricht = " " + nachricht;
    }

    if (length == 14)
    {
      nachricht = "  " + nachricht;
    }

    if (length == 13)
    {
      nachricht = "   " + nachricht;
    }

    if (length == 12)
    {
      nachricht = "    " + nachricht;
    }

    if (length == 11)
    {
      nachricht = "     " + nachricht;
    }

    if (length == 10)
    {
      nachricht = "      " + nachricht;
    }

    if (length == 9)
    {
      nachricht = "       " + nachricht;
    }

    if (length == 8)
    {
      nachricht = "        " + nachricht;
    }

    if (length == 7)
    {
      nachricht = "         " + nachricht;
    }

    if (length == 6)
    {
      nachricht = "          " + nachricht;
    }

    if (length == 5)
    {
      nachricht = "           " + nachricht;
    }

    if (length == 4)
    {
      nachricht = "            " + nachricht;
    }

    if (length == 3)
    {
      nachricht = "             " + nachricht;
    }

    if (length == 2)
    {
      nachricht = "              " + nachricht;
    }

    if (length == 1)
    {
      nachricht = "               " + nachricht;
    }

    return nachricht;
  }

  public static void setTab(ArrayList<String> contents)
  {
    for (Player t : Bukkit.getServer().getOnlinePlayers())
    {
      CraftPlayer cp = (CraftPlayer)t;
      EntityPlayer nmsPlayer = cp.getHandle();

      for (String nachricht : contents)
      {
        nachricht = shortenString(nachricht);
        nmsPlayer.playerConnection.sendPacket(new Packet201PlayerInfo(nachricht, true, 9999));
      }
    }
  }

  @EventHandler
  public void onJoin(PlayerJoinEvent event)
  {
    if (!getConfig().getBoolean("UseSuperTab"))
    {
      return;
    }

    ArrayList<String> sl = (ArrayList<String>) getConfig().getStringList("TabConfig");

    this.nachrichten.clear();

    for (String nachricht : sl)
    {
      this.nachrichten.add(nachricht);
    }

    setTab(sl);
  }
}