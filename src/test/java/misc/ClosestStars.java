package misc;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class ClosestStars {

    //Given the position of a trillion stars (and the Earth), calculate the 1000 stars that are closest to the Earth.
    private final CelestialObject EARTH = new CelestialObject();
    class CelestialObject implements Comparable<CelestialObject> {

        long x;
        long y;
        long z;

        public int compareTo(CelestialObject other) {
            long otherDistSqrd = computeDistanceSquaredFromEarth(other);
            long thisDistSqrd = computeDistanceSquaredFromEarth(this);
            // return 1 if this is closer than other
            if(thisDistSqrd < otherDistSqrd) return 1;
            // return 0 if they are the same distance
            if(thisDistSqrd == otherDistSqrd) return 0;
            // return -1 if other is closer than this
            if(thisDistSqrd > otherDistSqrd) return -1;
            // 1.10 == 1.1000000000001
            return 0;
        }

        private long computeDistanceSquaredFromEarth(CelestialObject other) {
            return (other.x - EARTH.x)*(other.x - EARTH.x) +
                    (other.y - EARTH.y)*(other.y - EARTH.y) + (other.z - EARTH.z)*(other.z - EARTH.z);
        }
    }

    interface StarService {
        CelestialObject getNextStar();
        boolean hasNext();
    }

    private static final Comparator<CelestialObject> MAX_COMPARATOR = (star1, star2) -> star1.compareTo(star2);

    public List<CelestialObject> calculateClosestStars(StarService service) {
        if(service == null)
            throw new IllegalArgumentException("service must be non-null");

        PriorityQueue<CelestialObject> stars = new PriorityQueue<CelestialObject>(1000, MAX_COMPARATOR);
        for(int i = 0; i < 1000; i++)
            stars.offer(service.getNextStar());

        while(service.hasNext()) {
            CelestialObject top = stars.peek();
            CelestialObject next = service.getNextStar();
            if(top.compareTo(next) < 0) {
                stars.poll();
                stars.offer(next);
            }
        }

        return stars.stream().collect(Collectors.toList());
    }
}
