package cn.wegrowth.elearning.domain.training

import cn.wegrowth.elearning.repository.TrainingRepository
import org.springframework.stereotype.Service

interface TrainingServices {
    fun getAllTrainings(): List<Training>
}

@Service
class TrainingServicesImpl(private val trainingRepository: TrainingRepository) : TrainingServices {
    override fun getAllTrainings(): List<Training> {
        return trainingRepository.findAll()
    }
}