package home_work_1.robots_builder;

import home_work_1.robots_builder.dto.RobotParts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scientist {
    private final Map<RobotParts,Integer> robotPartsForAssembly = new HashMap<>();

    public void takeRobotParts(List<RobotParts> parts) {
        for (RobotParts part : parts) {
            Integer count = robotPartsForAssembly.get(part);
            if (count == null) {
                count = 0;
            }
            robotPartsForAssembly.put(part, ++count);
        }
    }

    public int assembleRobots() {
        int mandatoryCountParts = RobotParts.values().length;

        if (robotPartsForAssembly.size() == mandatoryCountParts) {

            List<Integer> values = new ArrayList<>(robotPartsForAssembly.values());

            int count = values.get(0);

            for (Integer value : values) {
                if(value < count) {
                    count = value;
                }
            }

            return count;
        }

        return 0;
    }
}
