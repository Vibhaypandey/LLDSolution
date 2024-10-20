package LLD.EASY.TrafficSignal;

import java.util.HashMap;
import java.util.Objects;

public class TrafficLightController {
    HashMap<String , Road> roads;

    public static TrafficLightController instance;

    private TrafficLightController(){
        roads = new HashMap<>();
    }

    public static  synchronized  TrafficLightController getInstance(){
        if(Objects.isNull(instance)){
            return  new TrafficLightController();
        }
        return instance;
    }

    public void createRoads(Road road){
        roads.put(road.getId(),road);

    }

    public void removeRoad(String roadId){
        roads.remove(roadId);
    }

    public void startTraficLight(){
        for(Road road : roads.values()){
          TrafficLight trafficLight = road.getTrafficLight();
          new Thread(()->{
              while(true){
                  try{
                      System.out.println("RED LIGHT IS ON...PLEASE DON'T CROSS THE RODE" +Thread.currentThread().getName());
                      Thread.sleep(trafficLight.getRedduration());
                      System.out.println("GREEN LIGHT IS ON...GO...");
                      trafficLight.changeSignal(Signal.GREEN);
                      Thread.sleep(trafficLight.getGreenduration());
                      System.out.println("YELLOW LIGHT IS ON...PLEASE PUT YOUR HELMET");
                      trafficLight.changeSignal(Signal.YELLOW);
                      System.out.println("RED LIGHT IS ON...PLEASE DON'T CROSS THE RODE..again");
                      Thread.sleep(trafficLight.getYellowduration());
                      trafficLight.changeSignal(Signal.RED);


                  }
                  catch (InterruptedException interruptedException){

                  }
              }
          }).start();
        }
    }

    public void handleEmergency(String roadId) {
        Road road = roads.get(roadId);
        if (road != null) {
            TrafficLight trafficLight = road.getTrafficLight();
            System.out.println("Emergency vehicle is coming .. so changing light to green...");
            trafficLight.changeSignal(Signal.GREEN);
            // Perform emergency handling logic

        }
    }

}
