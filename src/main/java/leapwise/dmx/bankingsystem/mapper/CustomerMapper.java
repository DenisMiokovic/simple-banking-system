package leapwise.dmx.bankingsystem.mapper;

import leapwise.dmx.bankingsystem.dto.CustomerDTO;
import leapwise.dmx.bankingsystem.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {AccountMapper.class})
public interface CustomerMapper {

	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

	Customer toEntity(CustomerDTO dto);

	CustomerDTO toDto(Customer customer);
}
