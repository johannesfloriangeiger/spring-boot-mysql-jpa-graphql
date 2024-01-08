package org.example.controller;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class ExceptionResolver extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(@NonNull final Throwable throwable, @NonNull final DataFetchingEnvironment dataFetchingEnvironment) {
        if (throwable instanceof NotFoundException) {
            return GraphqlErrorBuilder.newError()
                    .errorType(ErrorType.NOT_FOUND)
                    .message(throwable.getMessage())
                    .path(dataFetchingEnvironment.getExecutionStepInfo().getPath())
                    .location(dataFetchingEnvironment.getField().getSourceLocation())
                    .build();
        } else {
            return null;
        }
    }
}