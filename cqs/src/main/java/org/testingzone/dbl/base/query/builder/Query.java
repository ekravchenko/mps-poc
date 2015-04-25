package org.testingzone.dbl.base.query.builder;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;
import org.testingzone.dbl.base.query.builder.join.JoinRequest;

import java.util.*;

public final class Query {

    public static final Query EMPTY = new Query(new BooleanBuilder(), new HashSet<JoinRequest>());

    private final BooleanBuilder booleanBuilder;

    private final Set<JoinRequest> joinRequests;

    private Query(BooleanBuilder booleanBuilder, Set<JoinRequest> joinRequests) {
        this.booleanBuilder = booleanBuilder;
        this.joinRequests = joinRequests;
    }

    public Query and(QueryItem queryItem) {
        BooleanBuilder where = andPredicate(queryItem.getPredicate());
        Set<JoinRequest> joins = addJoins(queryItem.getJoins());
        return new Query(where, joins);
    }

    public Query or(QueryItem queryItem) {
        BooleanBuilder where = orPredicate(queryItem.getPredicate());
        Set<JoinRequest> joins = addJoins(queryItem.getJoins());
        return new Query(where, joins);
    }

    public Query join(JoinRequest joinRequest) {
        BooleanBuilder where = new BooleanBuilder(this.booleanBuilder);
        Set<JoinRequest> joins = addJoin(joinRequest);
        return new Query(where, joins);
    }

    BooleanBuilder getWhereClause() {
        return new BooleanBuilder(this.booleanBuilder);
    }

    Set<JoinRequest> getJoins() {
        return new HashSet<>(joinRequests);
    }

    private Set<JoinRequest> addJoins(List<JoinRequest> newJoinRequests) {
        Set<JoinRequest> joinRequests = new HashSet<>(this.joinRequests);
        joinRequests.addAll(newJoinRequests);
        return joinRequests;
    }

    private Set<JoinRequest> addJoin(JoinRequest newJoinRequest) {
        Set<JoinRequest> joinRequests = new HashSet<>(this.joinRequests);
        joinRequests.add(newJoinRequest);
        return joinRequests;
    }

    private BooleanBuilder andPredicate(Predicate predicate) {
        BooleanBuilder booleanBuilder = new BooleanBuilder(this.booleanBuilder);
        booleanBuilder.and(predicate);
        return booleanBuilder;
    }

    private BooleanBuilder orPredicate(Predicate predicate) {
        BooleanBuilder booleanBuilder = new BooleanBuilder(this.booleanBuilder);
        booleanBuilder.or(predicate);
        return booleanBuilder;
    }
}
