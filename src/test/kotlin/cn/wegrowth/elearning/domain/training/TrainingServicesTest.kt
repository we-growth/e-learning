package cn.wegrowth.elearning.domain.training

import cn.wegrowth.elearning.repository.TrainingRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class TrainingServicesTest {

    init {
        MockKAnnotations.init(this)
    }

    @MockK
    lateinit var trainingRepository: TrainingRepository

    private val trainingServices = TrainingServicesImpl(trainingRepository)

    @Test
    fun `create Training Test`() {
        every { trainingRepository.findAll() } returns listOf(Training("test-abc"))
        val allTrainings = trainingServices.getAllTrainings()
        Assertions.assertThat(allTrainings).size().isEqualTo(1)
    }
}