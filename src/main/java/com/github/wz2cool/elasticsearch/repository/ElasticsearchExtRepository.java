package com.github.wz2cool.elasticsearch.repository;

import com.github.wz2cool.elasticsearch.model.LogicPagingResult;
import com.github.wz2cool.elasticsearch.query.DynamicQuery;
import com.github.wz2cool.elasticsearch.query.LogicPagingQuery;
import org.springframework.data.elasticsearch.core.query.ByQueryResponse;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

/**
 * Abstract Elasticsearch Repository
 *
 * @param <T> entity class
 * @author Frank
 */
@NoRepositoryBean
public interface ElasticsearchExtRepository<T, I> extends ElasticsearchRepository<T, I> {
    /**
     * delete by dynamic query
     *
     * @param dynamicQuery dynamic query
     */
    ByQueryResponse deleteByDynamicQuery(DynamicQuery<T> dynamicQuery);

    List<T> selectByDynamicQuery(DynamicQuery<T> dynamicQuery);

    Optional<T> selectFirstByDynamicQuery(DynamicQuery<T> dynamicQuery);

    List<T> selectByDynamicQuery(DynamicQuery<T> dynamicQuery, int page, int pageSize);

    /**
     * select by logic paging
     *
     * @param logicPagingQuery logic paging query
     * @return logic paging result
     */
    LogicPagingResult<T> selectByLogicPaging(LogicPagingQuery<T> logicPagingQuery);
}
