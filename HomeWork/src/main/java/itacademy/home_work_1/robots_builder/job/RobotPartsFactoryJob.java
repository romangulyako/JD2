package itacademy.home_work_1.robots_builder.job;

import itacademy.home_work_1.robots_builder.RobotPartsFactory;

import java.util.concurrent.TimeUnit;

public class RobotPartsFactoryJob implements Runnable{
    private final static long INTERVAL_BETWEEN_NIGHTS = 100;
    private final static int NIGHTS_COUNT = 100;

    private final RobotPartsFactory factory;

    public RobotPartsFactoryJob(RobotPartsFactory factory) {
        this.factory = factory;
    }

    /**
     * Метод симулирует работу фабрики по выбросу на свалку запчастей
     */
    @Override
    public void run() {
        for (int i = 0; i < NIGHTS_COUNT; i++) {
            factory.throwRobotParts();
            try {
                TimeUnit.MILLISECONDS.sleep(INTERVAL_BETWEEN_NIGHTS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
