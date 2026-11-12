
package com.igor.rpgapi.repository;

import com.igor.rpgapi.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
