package com.leftlane.refinitivdataparser.repository;

import com.leftlane.refinitivdataparser.repository.entities.CrossRefCodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CRCRepository extends JpaRepository<CrossRefCodes, Integer> {
    List<CrossRefCodes> findByStatus(Boolean status);
}