package com.github.mitschi.services.graphql;

/**
 * This class is used to send GraphQL queries.
 */
class GraphQLQuery {
    private Object variables;

    private String query;

    public GraphQLQuery() {
    }

    public GraphQLQuery(Object variables, String query) {
        this.variables = variables;
        this.query = query;
    }

    public Object getVariables() {
        return variables;
    }

    public void setVariables(Object variables) {
        this.variables = variables;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}