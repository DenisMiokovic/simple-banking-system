package leapwise.dmx.bankingsystem.util;

import jakarta.persistence.criteria.Predicate;
import leapwise.dmx.bankingsystem.model.Transaction;
import org.springframework.data.jpa.domain.Specification;

public class TransactionSpecifications {
	public static Specification<Transaction> customerTransactionsWithDynamicFilter(Long customerId, String fieldName, Object value) {
		return (root, query, cb) -> {
			Predicate customerPredicate = cb.or(
					cb.equal(root.get("senderAccount").get("customer").get("customerId"), customerId),
					cb.equal(root.get("receiverAccount").get("customer").get("customerId"), customerId)
			);

			if (fieldName != null && !fieldName.isEmpty() && value != null) {
				Predicate fieldPredicate = cb.equal(root.get(fieldName), value);
				return cb.and(customerPredicate, fieldPredicate);
			}

			return customerPredicate;
		};
	}
}
