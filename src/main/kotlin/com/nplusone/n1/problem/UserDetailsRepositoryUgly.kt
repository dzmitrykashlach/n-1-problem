package com.nplusone.n1.problem

import com.nplusone.n1.problem.entities.UserDetails
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

// ugly interface for @Transactional testing purposes

@Repository
@Primary
interface UserDetailsRepositoryUgly : JpaRepository<UserDetails, String> {
    @EntityGraph(
        type = EntityGraph.EntityGraphType.FETCH,
        attributePaths = arrayOf("addresses")
    )
    fun findByNameContaining(text: String): List<UserDetails>
}