package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;

public class BetterRadar {

    private final ExecutorService executor;
    private final int rocketsCount;
    private final PatriotBattery battery;

    public BetterRadar(ExecutorService executor, int rocketsCount, PatriotBattery battery) {
        this.executor = executor;
        this.rocketsCount = rocketsCount;
        this.battery = battery;
    }
}
