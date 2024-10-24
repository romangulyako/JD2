package itacademy.home_work_1.robots_builder;

import itacademy.home_work_1.robots_builder.job.AssistantJob;
import itacademy.home_work_1.robots_builder.job.RobotPartsFactoryJob;

public class Main {
    public static void main(String[] args) {
        Scientist scientist1 = new Scientist();
        Scientist scientist2 = new Scientist();

        Assistant assistant1 = new Assistant(scientist1);
        Assistant assistant2 = new Assistant(scientist2);

        RobotPartsFactory factory = new RobotPartsFactory();

        Thread factoryJob = new Thread(new RobotPartsFactoryJob(factory));
        Thread assistant1Job = new Thread(new AssistantJob(factory,assistant1));
        Thread assistant2Job = new Thread(new AssistantJob(factory,assistant2));

        factoryJob.start();
        assistant1Job.start();
        assistant2Job.start();

        try {
            factoryJob.join();
            assistant1Job.join();
            assistant2Job.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Количество собранных роботов у первого ученого:" + scientist1.assembleRobots());
        System.out.println("Количество собранных роботов у второго ученого:" + scientist2.assembleRobots());
    }
}
