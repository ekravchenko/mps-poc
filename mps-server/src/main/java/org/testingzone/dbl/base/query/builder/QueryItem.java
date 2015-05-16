package org.testingzone.dbl.base.query.builder;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;
import org.testingzone.dbl.base.query.builder.join.JoinRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Query main building block. Collection of QueryItems is what builds up every query. The nice thing about QueryItem is
 * that it holds both 'where clause' predicate and join instruction
 */
public final class QueryItem {

    /**
     * QueryDSL predicate that should be used in 'where' clause
     */
    private final Predicate predicate;

    /**
     * Join instructions
     */
    private final List<JoinRequest> joins;

    /**
     * The QueryItem with empty predicate (NullObject pattern)
     */
    public static final QueryItem EMPTY = new QueryItem(new BooleanBuilder());

    /**
     * Create query item based on QueryDSL predicate only. Constructor should be used when JOIN is not needed
     *
     * @param predicate - where clause predicate, shouldn't be null
     */
    public QueryItem(Predicate predicate) {
        this.predicate = predicate;
        this.joins = new ArrayList<>();
    }

    /**
     * Create query item based on a predicate and join
     *
     * @param predicate - QueryDSL predicate that will be used in 'where clause', shouldn't be null
     * @param joins     - join instructions, can be null
     */
    public QueryItem(Predicate predicate, JoinRequest... joins) {
        this.predicate = predicate;
        this.joins = (joins != null) ? Arrays.asList(joins) : new ArrayList<>();
    }

    /**
     * Get list of 'join expressions' that should be used with predicate
     *
     * @return Join instructions. Will never return null
     */
    public List<JoinRequest> getJoins() {
        return joins;
    }

    /**
     * Get QueryDSL predicate that can be used in 'where' clause
     *
     * @return QueryDSL predicate. Will never return null
     */
    public Predicate getPredicate() {
        return predicate;
    }
}
