package org.jesperancinha.housing.service

import org.jesperancinha.housing.dao.OwnerRepository
import org.springframework.stereotype.Service

@Service
class OwnerService(private val ownerRepository: OwnerRepository) {
    fun checkLiability(name: String) = ownerRepository.checkLiability(name)

}