package home_work_1.robots_builder;

import home_work_1.robots_builder.dto.RobotParts;


import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RobotPartsFactory {
    private static final int MIN_PARTS_COUNT = 1;
    private static final int MAX_PARTS_COUNT = 4;
    private static final int STARTED_PARTS_COUNT = 20;

    private final RobotParts[] allParts = RobotParts.values();
    private final ThreadLocalRandom rnd = ThreadLocalRandom.current();

    private final List<RobotParts> dump = new ArrayList<>();

    public RobotPartsFactory() {
        throwStartedRobotParts();
    }

    /**
     * Метод симулирует выброс на свалку случайное количество запчастей
     */
    public void throwRobotParts() {
        int partsCount = rnd.nextInt(MIN_PARTS_COUNT,MAX_PARTS_COUNT);

        for (int i = 0; i < partsCount; i++) {
            addPartToDump();
        }
    }

    /**
     * Метод возвращает из свалки определенное количество запчастей и удаляет их из свалки
     * Если на свалке запчастей меньше или они отсутствуют, возвращаются все имеющиеся
     * там запчасти или ничего
     *
     * @param count количество запчастей, которое необходимо вернуть
     * @return список запчастей
     */
    public synchronized List<RobotParts> getParts(int count) {
        List<RobotParts> takenParts = new ArrayList<>();

        if (!dump.isEmpty()) {
            if (count >= dump.size()) {
                takenParts.addAll(dump);
                dump.clear();
            } else {
                for (int i = 0; i < count; i++) {
                    int index = rnd.nextInt(dump.size());
                    RobotParts part = dump.get(index);
                    takenParts.add(part);
                    dump.remove(part);
                }
            }
        }

        return takenParts;
    }

    /**
     * Метод для начального заполнения свалки
     */
    private void throwStartedRobotParts() {
        for (int i = 0; i < STARTED_PARTS_COUNT; i++) {
            addPartToDump();
        }
    }

    /**
     * Метод добавляет на свалку одну случайную запчасть
     */
    private void addPartToDump() {
        RobotParts part = allParts[rnd.nextInt(allParts.length)];
        dump.add(part);
    }
}
