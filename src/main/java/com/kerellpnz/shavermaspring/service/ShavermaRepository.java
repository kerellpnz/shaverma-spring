package com.kerellpnz.shavermaspring.service;

import com.kerellpnz.shavermaspring.domain.Shaverma;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ShavermaRepository extends CrudRepository<Shaverma, UUID> {
}
