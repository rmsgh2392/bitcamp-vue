package com.mypet.web.brd;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ArticleRepository extends CrudRepository<Article, Long>{

}
