package com.envyful.better.dex.rewards.forge.config.comparator.type;

import com.envyful.api.forge.player.ForgeEnvyPlayer;
import com.envyful.better.dex.rewards.forge.config.comparator.RankComparator;
import com.pixelmonmod.pixelmon.api.storage.StorageProxy;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;

@ConfigSerializable
public class CountRankComparator implements RankComparator {

    protected double count;

    public CountRankComparator() {
    }

    public CountRankComparator(double count) {
        this.count = count;
    }

    @Override
    public String id() {
        return "count";
    }

    @Override
    public boolean test(ForgeEnvyPlayer player) {
        if (player != null) {
            return StorageProxy.getParty(player.getParent()).playerPokedex.countCaught() >= this.count;
        } else return false;
    }

    @Override
    public int distance(ForgeEnvyPlayer player) {
        var caught = StorageProxy.getParty(player.getParent()).playerPokedex.countCaught();
        return (int) Math.max(0, this.count - caught);
    }
}
