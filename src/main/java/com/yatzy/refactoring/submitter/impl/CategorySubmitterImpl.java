package com.yatzy.refactoring.submitter.impl;

import com.yatzy.refactoring.scorer.CategoryScorer;
import com.yatzy.refactoring.submitter.CategorySubmitter;

import java.util.List;

public class CategorySubmitterImpl implements CategorySubmitter {

    @Override
    public Integer submit(List<Integer> dices, CategoryScorer category) {
        return category.calculateScore(dices);
    }
}
