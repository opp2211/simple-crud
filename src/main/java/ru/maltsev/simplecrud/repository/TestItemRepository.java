package ru.maltsev.simplecrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.maltsev.simplecrud.entity.TestItem;

@Repository
public interface TestItemRepository extends JpaRepository<TestItem, Long> {}
