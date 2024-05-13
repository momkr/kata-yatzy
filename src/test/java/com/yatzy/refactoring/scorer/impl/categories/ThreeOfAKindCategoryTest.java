package com.yatzy.refactoring.scorer.impl.categories;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ThreeOfAKindCategoryTest {

    private final ThreeOfAKindCategory threeOfAKindCategory = new ThreeOfAKindCategory();

    @ParameterizedTest
    @MethodSource("threeOfAKindSumParameters")
    void should_return_expected_result_with_given_parameters(List<Integer> dices, Integer expected) {
        Assertions.assertThat(threeOfAKindCategory.calculateScore(dices)).isEqualTo(expected);
    }

    static List<Arguments> threeOfAKindSumParameters() {
        return List.of(
                Arguments.of(null, 0),
                Arguments.of(Collections.emptyList(), 0),
                Arguments.of(Arrays.asList(3, 3, 3, 4, 5), 9),
                Arguments.of(Arrays.asList(5, 3, 5, 4, 5), 15),
                Arguments.of(Arrays.asList(3, 3, 3, 3, 5), 9),
                Arguments.of(Arrays.asList(3, 3, 3, 3, 5, 5, 5), 0)
        );
    }
}