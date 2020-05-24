package com.grocery.management.repository;

import com.grocery.management.domain.Currency;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by arshi on 5/6/2020.
 */
public interface CurrencyRepository extends CrudRepository<Currency, Long> {
}
