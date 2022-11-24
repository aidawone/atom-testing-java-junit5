package cn.aidawone.atomtestingjavajunit5.repositories;


import cn.aidawone.atomtestingjavajunit5.model.Owner;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
