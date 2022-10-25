package com.jinwookim.pass.repository.packaze;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public interface PackageRepository extends JpaRepository<PackageEntity, Integer> {
    List<PackageEntity> findByCreatedAtAfter(LocalDateTime dateTime, Pageable pageable);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE PackageEntity p "+" set p.count = :count," + " p.period = :period" + " where p.packageSeq = :packageSeq"
    )
    int updateCountAndPeriod(Integer packageSeq, Integer count, Integer period);

}
