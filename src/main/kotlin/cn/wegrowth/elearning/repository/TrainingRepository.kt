package cn.wegrowth.elearning.repository

import cn.wegrowth.elearning.domain.training.QTraining
import cn.wegrowth.elearning.domain.training.Training
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.stereotype.Repository

interface TrainingExtRepository {
    fun findByName(name: String): List<Training>
}

@Repository
class TrainingExtRepositoryImpl(private val trainingQueryDslRepository: TrainingQueryDslRepository) :
    TrainingExtRepository {

    override fun findByName(name: String): List<Training> {
        return trainingQueryDslRepository.findAll(QTraining.training.name.like(name)).toList()
    }

    //    @Repository
    interface TrainingQueryDslRepository : JpaRepository<Training, String>, QuerydslPredicateExecutor<Training>
}

@Repository
interface TrainingRepository : JpaRepository<Training, String>, TrainingExtRepository