package creational;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- 1. Singleton ---");
        SmartHomeHub hub = SmartHomeHub.getInstance();
        hub.connectDevice("Термостат у вітальні");

        System.out.println("\n--- 2. Simple Factory ---");
        SimpleDeviceFactory deviceFactory = new SimpleDeviceFactory();
        SmartDevice myLight = deviceFactory.createDevice("light");
        if (myLight != null) myLight.turnOn();

        System.out.println("\n--- 3. Factory Method ---");
        SensorCreator motionCreator = new MotionSensorCreator();
        motionCreator.installAndTest();

        System.out.println("\n--- 4. Abstract Factory ---");
        EcosystemFactory appleEcosystem = new AppleFactory();
        Camera appleCam = appleEcosystem.createCamera();
        Display appleDisp = appleEcosystem.createDisplay();
        appleCam.record();
        appleDisp.showVideo();

        System.out.println("\n--- 5. Builder ---");
        SecuritySystem fortKnoxSystem = new SecuritySystem.Builder()
                .addAlarm()
                .addCameras(8)
                .addLaserGrid()
                .build();
        fortKnoxSystem.showConfig();

        System.out.println("\n--- 6. Prototype ---");
        BulbConfig livingRoomBulb = new BulbConfig("White", 100);

        BulbConfig bedroomBulb = (BulbConfig) livingRoomBulb.doClone();

        bedroomBulb.setColor("Warm Yellow");
        bedroomBulb.setBrightness(40);

        System.out.println("Оригінал (Вітальня): " + livingRoomBulb);
        System.out.println("Клон (Спальня): " + bedroomBulb);
    }
}