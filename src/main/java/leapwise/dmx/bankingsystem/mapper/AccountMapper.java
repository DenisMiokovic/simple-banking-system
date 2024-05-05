package leapwise.dmx.bankingsystem.mapper;

import leapwise.dmx.bankingsystem.dto.AccountDTO;
import leapwise.dmx.bankingsystem.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccountMapper {

	AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

	Account toEntity(AccountDTO dto);

	AccountDTO toDto(Account customer);
}
