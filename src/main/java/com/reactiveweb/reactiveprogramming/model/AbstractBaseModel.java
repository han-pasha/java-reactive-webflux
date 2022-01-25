package com.reactiveweb.reactiveprogramming.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public abstract class AbstractBaseModel<T , U> {
    @Column
    @Id
    public T id;
    @Column
    public U name;
//    @Column @NotNull
//    public ZonedDateTime createdDateTime;
}
