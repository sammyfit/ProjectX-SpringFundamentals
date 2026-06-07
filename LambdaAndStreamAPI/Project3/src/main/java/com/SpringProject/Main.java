import com.SpringProject.StreamAPI;

public class Main{
    static void main(String[] args) {
        Walkable obj = new WalkFast();
        obj.walk(4);

        NewWalkable obj2 =  (steps, isHealthy) -> {
            if(isHealthy) {
                System.out.println("Walk New Fast " + 2*steps + " steps.");
            }
            return 2*steps;
        };

        obj2.walkNew(4, true);

        NewWalkable obj3 =  (steps, isHealthy) -> 2*steps;

        System.out.println("Final Walk " + obj3.walkNew(5, false));

        System.out.println("-------------------Stream API Implementation----------------------------");
        StreamAPI.streamPractice();
    }
}

interface Walkable {
    int walk(int steps);
}

class WalkFast implements Walkable {

    @Override
    public int walk(int steps) {
        System.out.println("Walk Fast " + 2*steps + " steps.");
        return 2*steps;
    }
}

interface NewWalkable {
    int walkNew(int steps, boolean isHealthy);
}