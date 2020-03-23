package com.dao;

import org.apache.ibatis.annotations.Delete;

public interface PersonMapper {
    @Delete("delete from person where id = #{id}")
    public void deletePerson(int id);
}
