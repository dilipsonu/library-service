package com.dk.library.repository;

import com.dk.library.domain.entity.Batch;
import com.dk.library.domain.entity.QBatch;
import com.querydsl.core.types.dsl.SimpleExpression;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource (collectionResourceRel = "batches", path = "batches")
public interface BatchRepository extends
                                     PagingAndSortingRepository<Batch, UUID>,
                                     QueryDslPredicateExecutor<Batch>,
                                     QuerydslBinderCustomizer<QBatch> {

    @Override
    default void customize(QuerydslBindings bindings, QBatch batch) {

        bindings.bind(batch.status).first(SimpleExpression::eq);

    }

}
