package leapwise.dmx.bankingsystem.mapper;

import leapwise.dmx.bankingsystem.dto.TransactionDTO;
import leapwise.dmx.bankingsystem.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

	TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

	Transaction toEntity(TransactionDTO dto);

	@Mapping(source = "senderAccount.accountNumber", target = "senderAccountNumber")
	@Mapping(source = "receiverAccount.accountNumber", target = "receiverAccountNumber")
	TransactionDTO toDto(Transaction transaction);
}
