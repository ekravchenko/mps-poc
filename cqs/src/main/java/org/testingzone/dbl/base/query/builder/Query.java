package org.testingzone.dbl.base.query.builder;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;
import org.testingzone.dbl.base.query.builder.join.JoinRequest;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class Query {

    public static final Query EMPTY = new Query();

    private final BooleanBuilder booleanBuilder;

    private final List<JoinRequest> joinRequests;

    private Query() {
        this(new BooleanBuilder(), new LinkedList<>());
    }

    private Query(BooleanBuilder booleanBuilder, List<JoinRequest> joinRequests) {
        this.booleanBuilder = booleanBuilder;
        this.joinRequests = joinRequests;
    }

    public Query and(QueryItem queryItem) {
        BooleanBuilder where = andPredicate(queryItem.getPredicate());
        List<JoinRequest> joins = addJoins(queryItem.getJoins());
        return new Query(where, joins);
    }

//    public Query or(QueryItem queryItem) {
//        BooleanBuilder where = orPredicate(queryItem.getPredicate());
//        List<JoinRequest> joins = addJoins(queryItem.getJoins());
//        return new Query(where, joins);
//    }

    Query join(List<JoinRequest> joinRequests) {
        BooleanBuilder where = new BooleanBuilder(this.booleanBuilder);
        List<JoinRequest> joins = addJoins(joinRequests);
        return new Query(where, joins);
    }

    BooleanBuilder getWhereClause() {
        return new BooleanBuilder(this.booleanBuilder);
    }

    Set<JoinRequest> getJoins() {
        return new LinkedHashSet<>(joinRequests);
    }

    private List<JoinRequest> addJoins(List<JoinRequest> newJoinRequests) {
        List<JoinRequest> joinRequests = new LinkedList<>(this.joinRequests);
        joinRequests.addAll(newJoinRequests);
        return joinRequests;
    }

    private BooleanBuilder andPredicate(Predicate predicate) {
        BooleanBuilder booleanBuilder = new BooleanBuilder(this.booleanBuilder);
        booleanBuilder.and(predicate);
        return booleanBuilder;
    }

//    private BooleanBuilder orPredicate(Predicate predicate) {
//        BooleanBuilder booleanBuilder = new BooleanBuilder(this.booleanBuilder);
//        booleanBuilder.or(predicate);
//        return booleanBuilder;
//    }
}
