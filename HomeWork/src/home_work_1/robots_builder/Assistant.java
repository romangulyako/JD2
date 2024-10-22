package home_work_1.robots_builder;

import home_work_1.robots_builder.dto.RobotParts;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Assistant {
    private final static int MIN_PARTS_COUNT = 1;
    private final static int MAX_PARTS_COUNT = 4;

    private final Scientist scientist;
    private final ThreadLocalRandom rnd = ThreadLocalRandom.current();

    public Assistant(Scientist scientist) {
        this.scientist = scientist;
    }

    /**
     * Метод собирает на свалке случайное количество запчастей
     *
     * @param factory фабрика, на свалке которой будут собираться запчасти
     * @return список собранных запчастей
     */
    public synchronized List<RobotParts> takeRobotPartsFromDump(RobotPartsFactory factory) {
        int takenPartsCount = rnd.nextInt(MIN_PARTS_COUNT,MAX_PARTS_COUNT);
        return factory.getParts(takenPartsCount);
    }

    /**
     * Метод передает запчасти ученому
     * @param parts список передаваемых запчастей
     */
    public void giveRobotPartsToScientist(List<RobotParts> parts) {
        scientist.takeRobotParts(parts);
    }
}
