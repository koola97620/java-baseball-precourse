package baseball.util;

import baseball.domain.Number;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NumberUtils {

    public static List<Number> toList(Collection<Integer> set) {
        List<Number> list = new ArrayList<>();
        int index = 0;
        for (Integer number : set) {
            list.add(Number.of(number,index++));
        }
        return list;
    }

    public static List<Number> toList(String numberString) {
        List<Number> list = new ArrayList<>();
        String[] numberStringArray = numberString.split("");
        int index = 0;
        for(String number : numberStringArray) {
            list.add(Number.of(Integer.parseInt(number),index++));
        }
        return list;
    }
}
