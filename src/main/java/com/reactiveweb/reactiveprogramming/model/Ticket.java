package com.reactiveweb.reactiveprogramming.model;

import lombok.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@EqualsAndHashCode(callSuper = true)
@Table("TICKET")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Ticket extends AbstractBaseModel<Long, String> {
    @Column
    public String approver;
}
