package com.nplusone.n1.problem

import com.nplusone.n1.problem.entities.UserDetails
import jakarta.persistence.EntityManager
import org.hibernate.Session
import org.hibernate.query.Query
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.repository.query.FluentQuery
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import java.util.*
import java.util.function.Function


class UserDetailsRepositoryUglyImpl(
    private val entityManager: EntityManager
) : UserDetailsRepositoryUgly, ApplicationContextAware {
    lateinit var context: ApplicationContext

    @Transactional(propagation = Propagation.REQUIRED)
    override fun findByNameContaining(text: String): List<UserDetails> {
        context.getBean(UserDetailsRepositoryUgly::class.java).findById("--not-existing-id--")
        // get the current hibernate session
        val currentSession: Session = entityManager.unwrap(Session::class.java)
        // create a query
        val userDetailsQuery: Query<UserDetails> =
            currentSession.createQuery("from UserDetails", UserDetails::class.java)
        // execute query and get result list
        val userDetails: List<UserDetails> = userDetailsQuery.resultList
        // return the results
        return userDetails
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    override fun findById(id: String): Optional<UserDetails> {
        // get the current hibernate session
        val currentSession: Session = entityManager.unwrap(Session::class.java)
        // create a query
        val userDetailsQuery: Query<UserDetails> =
            currentSession
                .createQuery("from UserDetails", UserDetails::class.java)
        val userDetails: Optional<UserDetails> = Optional.of(userDetailsQuery.resultList[0])
        // return the results
        return userDetails
    }


    override fun setApplicationContext(applicationContext: ApplicationContext) {
        this.context = applicationContext
    }

    override fun <S : UserDetails?> save(entity: S & Any): S & Any {
        TODO("Not yet implemented")
    }

    override fun <S : UserDetails?> saveAll(entities: MutableIterable<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun existsById(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun <S : UserDetails?> findAll(example: Example<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun <S : UserDetails?> findAll(example: Example<S>, sort: Sort): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableList<UserDetails> {
        TODO("Not yet implemented")
    }

    override fun findAll(sort: Sort): MutableList<UserDetails> {
        TODO("Not yet implemented")
    }

    override fun findAll(pageable: Pageable): Page<UserDetails> {
        TODO("Not yet implemented")
    }

    override fun count(): Long {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun flush() {
        TODO("Not yet implemented")
    }

    override fun deleteAllInBatch() {
        TODO("Not yet implemented")
    }

    override fun getReferenceById(id: String): UserDetails {
        TODO("Not yet implemented")
    }

    override fun getById(id: String): UserDetails {
        TODO("Not yet implemented")
    }

    override fun getOne(id: String): UserDetails {
        TODO("Not yet implemented")
    }

    override fun deleteAllByIdInBatch(ids: MutableIterable<String>) {
        TODO("Not yet implemented")
    }

    override fun deleteAllInBatch(entities: MutableIterable<UserDetails>) {
        TODO("Not yet implemented")
    }

    override fun <S : UserDetails?> saveAllAndFlush(entities: MutableIterable<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun <S : UserDetails?> saveAndFlush(entity: S & Any): S & Any {
        TODO("Not yet implemented")
    }

    override fun <S : UserDetails?, R : Any?> findBy(
        example: Example<S>,
        queryFunction: Function<FluentQuery.FetchableFluentQuery<S>, R>
    ): R & Any {
        TODO("Not yet implemented")
    }

    override fun <S : UserDetails?> exists(example: Example<S>): Boolean {
        TODO("Not yet implemented")
    }

    override fun <S : UserDetails?> findOne(example: Example<S>): Optional<S> {
        TODO("Not yet implemented")
    }

    override fun deleteAll(entities: MutableIterable<UserDetails>) {
        TODO("Not yet implemented")
    }

    override fun deleteAllById(ids: MutableIterable<String>) {
        TODO("Not yet implemented")
    }

    override fun delete(entity: UserDetails) {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String) {
        TODO("Not yet implemented")
    }

    override fun <S : UserDetails?> count(example: Example<S>): Long {
        TODO("Not yet implemented")
    }

    override fun findAllById(ids: MutableIterable<String>): MutableList<UserDetails> {
        TODO("Not yet implemented")
    }

    override fun <S : UserDetails?> findAll(example: Example<S>, pageable: Pageable): Page<S> {
        TODO("Not yet implemented")
    }

}