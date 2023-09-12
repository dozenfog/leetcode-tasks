package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KeysAndRooms {
    public static void main(String[] args) {
        System.out.println(canVisitAllRooms(List.of(List.of(1,3), List.of(3,2,1), List.of(2), List.of(0))));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Boolean> visited = new ArrayList<>();
        for (int i = 0; i < rooms.size(); i++) visited.add(false);
        Queue<Integer> roomsToVisit = new PriorityQueue<>();
        roomsToVisit.addAll(rooms.get(0));
        visited.set(0, true);
        while (!roomsToVisit.isEmpty()) {
            int curRoom = roomsToVisit.remove();
            if (!visited.get(curRoom)) {
                if (!rooms.get(curRoom).isEmpty())
                    roomsToVisit.addAll(rooms.get(curRoom));
                visited.set(curRoom, true);
            }
        }
        return visited.stream().allMatch(e -> e);
    }
}
