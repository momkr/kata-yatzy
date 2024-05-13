package com.yatzy.refactoring.submitter;

import com.yatzy.refactoring.scorer.CategoryScorer;

import java.util.List;

public interface CategorySubmitter {

    Integer submit(List<Integer> dices, CategoryScorer category);
}
