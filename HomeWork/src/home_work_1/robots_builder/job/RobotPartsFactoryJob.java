package home_work_1.robots_builder.job;

import home_work_1.robots_builder.RobotPartsFactory;

import java.util.concurrent.TimeUnit;

public class RobotPartsFactoryJob implements Runnable{
    private final static long INTERVAL_BETWEEN_DAYS = 100;
    private final static int NIGHTS_COUNT = 100;

    private final RobotPartsFactory factory;

    public RobotPartsFactoryJob(RobotPartsFactory factory) {
        this.factory = factory;
    }

    @Override
    public void run() {
        for (int i = 0; i < NIGHTS_COUNT; i++) {
            factory.throwRobotParts();
            try {
                TimeUnit.MILLISECONDS.sleep(INTERVAL_BETWEEN_DAYS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
