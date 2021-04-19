package edu.iis.mto.multithread;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.ExecutorService;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RadarTest {

    @Mock
    private PatriotBattery batteryMock;

    @Mock
    private ExecutorService executor;

    @RepeatedTest(1234)
    void launchPatriotOnceWhenNoticesAScudMissle() {
        // given
        Scud enemyMissle = new Scud();
        int rocketsCount = 100;
        BetterRadar betterRadar = new BetterRadar(executor, rocketsCount, batteryMock);

        // when
        betterRadar.notice(enemyMissle);

        // then
        verify(executor).execute(any(Runnable.class));
    }

}
