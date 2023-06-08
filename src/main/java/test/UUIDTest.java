package test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class UUIDTest {
    public static void main(String[] args) {
        Set<Long> uuid = new HashSet<>();
        for (int i = 0; i < 10000000 ; i++) {
            uuid.add(get64LeastSignificantBitsForVersion1());
        }
        System.out.println(uuid.size());

    }

//    UUID test
    private static long get64LeastSignificantBitsForVersion1() {
        Random random = new Random();
        long random63BitLong = random.nextLong() & 0x3FFFFFFFFFFFFFFFL;
        long variant3BitFlag = 0x8000000000000000L;
        return random63BitLong | variant3BitFlag;
    }

}
