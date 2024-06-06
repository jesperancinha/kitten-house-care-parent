package org.jesperancinha.kittens.service

import org.jesperancinha.kittens.dao.OwnerRepository
import org.springframework.stereotype.Service

@Service
class OwnerService(private val ownerRepository: OwnerRepository) {
    fun checkLiability(name: String) = ownerRepository.checkLiability(name)

}