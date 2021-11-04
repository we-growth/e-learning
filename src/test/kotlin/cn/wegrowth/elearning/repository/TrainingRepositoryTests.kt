package cn.wegrowth.elearning.repository

import cn.wegrowth.elearning.domain.training.Training
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager


@DataJpaTest
class TrainingRepositoryTests @Autowired constructor(
    val entityManager: TestEntityManager,
    val trainingRepository: TrainingRepository
) {
    @Test
    fun saveTest() {
        val training = Training("test-Training")
        entityManager.persist(training)

        val trainings = trainingRepository.findByName("test-Training")
        assertThat(trainings).size().isEqualTo(1)
    }
}