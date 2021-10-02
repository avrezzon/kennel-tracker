package com.springsrescuemisson.kenneltracker.mapper;

public interface Mapper<T,K> {
    K convertToEntity(T dto);
    T convertToDto(K entity);
}
