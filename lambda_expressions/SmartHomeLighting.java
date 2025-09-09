// Lambda Example 1: Smart Home Lighting Automation
interface LightAction {
    void activate();
}

public class SmartHomeLighting {
    public static void main(String[] args) {
        // Lambda for different triggers
        LightAction motionTrigger = () -> System.out.println("Lights ON due to motion detected.");
        LightAction timeTrigger = () -> System.out.println("Lights ON at sunset.");
        LightAction voiceTrigger = () -> System.out.println("Lights ON via voice command.");

        // Activate different actions
        motionTrigger.activate();
        timeTrigger.activate();
        voiceTrigger.activate();
    }
}