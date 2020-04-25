package net.defracted.infection;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private void loadListener(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
    }


    @Override
    public void onEnable() {
        loadListener(new InfectionsListener());
    }
}
