package leapwise.dmx.bankingsystem.mapper;

import leapwise.dmx.bankingsystem.dto.TransactionRequestDTO;
import leapwise.dmx.bankingsystem.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransactionRequestMapper {

	TransactionRequestMapper INSTANCE = Mappers.getMapper(TransactionRequestMapper.class);

	@Mapping(source = "senderAccountId", target = "senderAccount.accountId")
	@Mapping(source = "receiverAccountId", target = "receiverAccount.accountId")
	Transaction toEntity(TransactionRequestDTO dto);

	@Mapping(source = "senderAccount.accountId", target = "senderAccountId")
	@Mapping(source = "receiverAccount.accountId", target = "receiverAccountId")
	TransactionRequestDTO toDto(Transaction transaction);
}
