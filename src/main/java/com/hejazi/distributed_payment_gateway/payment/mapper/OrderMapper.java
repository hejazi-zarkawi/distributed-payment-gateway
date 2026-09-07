package com.hejazi.distributed_payment_gateway.payment.mapper;

import com.hejazi.distributed_payment_gateway.payment.dto.response.OrderResponse;
import com.hejazi.distributed_payment_gateway.payment.entity.OrderRecord;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {
    OrderResponse toResponse(OrderRecord orderRecord);
}
