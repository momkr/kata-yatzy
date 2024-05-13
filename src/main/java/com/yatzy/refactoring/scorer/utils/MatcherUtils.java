package com.yatzy.refactoring.scorer.utils;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@UtilityClass
public class MatcherUtils {

    public static final Integer PAIR_SIZE = 2;
    public static final Integer TRIPLE_SIZE = 3;
    public static final Integer SQUARE_SIZE = 4;

    public static final int SMALL_STRAIGHT_START_VALUE = 1;
    public static final int SMALL_STRAIGHT_END_VALUE = 5;

    public static final int LARGE_STRAIGHT_START_VALUE = 2;
    public static final int LARGE_STRAIGHT_END_VALUE = 6;

    public static Map<Integer, List<Integer>> collectDices(List<Integer> dices) {
        return dices.stream().collect(Collectors.groupingBy(Integer::intValue));
    }

    public static Map<Integer, List<Integer>> getElementsWithPair(Map<Integer, List<Integer>> collect) {
        return collect.entrySet().stream()
                .filter(entry -> entry.getValue().size() >= PAIR_SIZE)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<Integer, List<Integer>> getElementsWithTriple(Map<Integer, List<Integer>> collect) {
        return collect.entrySet().stream()
                .filter(entry -> entry.getValue().size() >= TRIPLE_SIZE)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<Integer, List<Integer>> getElementsWithSquare(Map<Integer, List<Integer>> collect) {
        return collect.entrySet().stream()
                .filter(entry -> entry.getValue().size() >= SQUARE_SIZE)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Boolean hasValidStraight(List<Integer> dices, Integer startValue, Integer endValue) {
        return IntStream.range(startValue, endValue + 1)
                .boxed()
                .map(dices::contains)
                .filter(value -> Objects.equals(value, Boolean.FALSE))
                .findFirst().orElse(Boolean.TRUE);
    }

}
