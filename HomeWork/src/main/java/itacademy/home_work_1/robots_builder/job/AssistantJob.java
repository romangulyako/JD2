package home_work_1.robots_builder.job;

import home_work_1.robots_builder.Assistant;
import home_work_1.robots_builder.RobotPartsFactory;
import home_work_1.robots_builder.dto.RobotParts;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AssistantJob implements Runnable{
    private final static long INTERVAL_BETWEEN_NIGHTS = 100;
    private final static int NIGHTS_COUNT = 100;

    private final RobotPartsFactory factory;
    private final Assistant assistant;

    public AssistantJob(RobotPartsFactory factory, Assistant assistant) {
        this.factory = factory;
        this.assistant = assistant;
    }

    /**
     * Метод симулирует работу ассистента по сбору на свалке запчастей и передаче их ученому
     */
    @Override
    public void run() {
        for (int i = 0; i < NIGHTS_COUNT; i++) {
            List<RobotParts> parts = assistant.takeRobotPartsFromDump(factory);
            assistant.giveRobotPartsToScientist(parts);

            try {
                TimeUnit.MILLISECONDS.sleep(INTERVAL_BETWEEN_NIGHTS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
