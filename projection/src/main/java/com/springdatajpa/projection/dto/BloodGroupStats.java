package com.springdatajpa.projection.dto;

import com.springdatajpa.projection.entity.type.BloodGroupType;
import lombok.Data;

@Data
public class BloodGroupStats {
    private final BloodGroupType bloodGroupType;
    private final Long count;
}
