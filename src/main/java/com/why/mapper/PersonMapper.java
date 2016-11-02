package com.why.mapper;

import com.why.entity.Person;
import org.springframework.stereotype.Repository;

/**
 * Created by why on 2016/11/2.
 */
@Repository
public interface PersonMapper {

    public Person getPersonById(Integer id);

}
