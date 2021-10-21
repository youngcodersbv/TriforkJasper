package io.Tabskeeper.repository;

import io.Tabskeeper.model.Note;
import io.Tabskeeper.model.Tab;
import org.springframework.data.repository.CrudRepository;

import java.util.stream.StreamSupport;

public interface TabRepository extends CrudRepository<Tab, Long> {

}

