package net.defracted.infection;

import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class InfectionsListener implements Listener {
    private final Random random = new Random();

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            Player target = ((Player) event.getEntity()).getPlayer();

            if (event.getDamager() instanceof Zombie && target != null) {
                int chance = random.nextInt(101);

                // не забыть поставить на шанс > 97
                if (chance > 97) {
                    target.sendMessage(Topkek.ChatFormat("&cВы были заражены! Постарайтесь найти способ излечиться!"));

                    int whatEffects = random.nextInt(3);

                    if (whatEffects == 0) {
                        target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 20 * (60 * 5), 2));
                        target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * (60 * 5), 2));
                        target.sendMessage(Topkek.ChatFormat("&7&oВы чувствуете, будто что-то вас утяжеляет..."));
                        return;
                    }

                    if (whatEffects == 1) {
                        target.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 20 * (60 * 5), 2));
                        target.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20 * (60 * 5), 1));
                        target.sendMessage(Topkek.ChatFormat("&7&oВы чувствуете усталость и головную боль..."));
                        return;
                    }

                    if (whatEffects == 2) {
                        target.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20 * (60 * 5), 1));
                        target.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 20 * (60 * 5), 1));
                        target.sendMessage(Topkek.ChatFormat("&7&oВы чувствуете голод и странное покалывание в животе..."));
                        return;
                    }
                }
            }
        }
    }
}
