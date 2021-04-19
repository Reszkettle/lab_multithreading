package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BetterRadar {

    private final ExecutorService executor;
    private final int rocketsCount;
    private final PatriotBattery battery;

    public BetterRadar(int rocketsCount, PatriotBattery battery) {
        this.rocketsCount = rocketsCount;
        this.battery = battery;
        this.executor = Executors.newSingleThreadExecutor();
    }

    public BetterRadar(ExecutorService executor, int rocketsCount, PatriotBattery battery) {
        this.executor = executor;
        this.rocketsCount = rocketsCount;
        this.battery = battery;
    }

    public void notice(Scud enemyMissile) {
        this.executor.submit(() -> {
            for (int i = 0; i < rocketsCount; ++i) {
                this.battery.launchPatriot(enemyMissile);
            }
        });
    }
}
