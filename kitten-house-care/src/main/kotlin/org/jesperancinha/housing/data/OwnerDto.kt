package org.jesperancinha.housing.data

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Getter
import lombok.NoArgsConstructor

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
class OwnerDto {
    private val name: String? = null
    private val addres: String? = null
}