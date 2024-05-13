package com.yatzy.refactoring.scorer.impl.faces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;

class SixesCategoryTest {

    private final SixesCategory sixesCategory = new SixesCategory();

    @ParameterizedTest
    @MethodSource("sixesCategoryRollsParameters")
    void should_return_expected_score_with_given_rolls(List<Integer> rolls, Integer expectedScore) {
        Assertions.assertThat(sixesCategory.calculateScore(rolls)).isEqualTo(expectedScore);
    }

    static List<Arguments> sixesCategoryRollsParameters() {
        return List.of(
                Arguments.of(null, 0),
                Arguments.of(Collections.emptyList(), 0),
                Arguments.of(List.of(1, 2, 2, 4, 5), 0),
                Arguments.of(List.of(6, 6, 6, 4, 4), 18),
                Arguments.of(List.of(6, 6, 6, 6, 6), 30)
        );
    }
}