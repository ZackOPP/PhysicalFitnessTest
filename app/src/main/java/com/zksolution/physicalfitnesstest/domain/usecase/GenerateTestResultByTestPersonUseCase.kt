package com.zksolution.physicalfitnesstest.domain.usecase

import com.zksolution.physicalfitnesstest.domain.model.TestPerson
import com.zksolution.physicalfitnesstest.domain.repository.TestPersonDetailRepository
import com.zksolution.physicalfitnesstest.domain.repository.TestPersonJoggingRepository
import com.zksolution.physicalfitnesstest.domain.repository.TestPersonRepository
import com.zksolution.physicalfitnesstest.domain.usecase.base.UseCase
import io.reactivex.Completable
import javax.inject.Inject

class GenerateTestResultByTestPersonUseCase @Inject constructor(
    private val testPersonJoggingRepository: TestPersonJoggingRepository,
    private val testPersonDetailRepository: TestPersonDetailRepository,
    private val testPersonRepository: TestPersonRepository
) : UseCase<Completable, TestPerson>() {

    override fun execute(p: TestPerson): Completable =
        testPersonJoggingRepository
            .getByTestPerson(p)
            .map {
                val totalDistance = it.fieldDistance.toDouble() * it.laps.toDouble()
                if (totalDistance > 20.toDouble()) 2 else 1
            }
            .flatMapCompletable {
                var result = it
                testPersonDetailRepository.getByTestPerson(p)
                    .flatMapCompletable { list ->
                        list.forEach { testPersonDetail ->
                            result += if (testPersonDetail.repetitions.toDouble() / testPersonDetail.minutes.toDouble() > 50)
                                2
                            else
                                1
                        }
                        p.result = ("%.2f".format(result.toDouble() * 100.toDouble() / 6)).toDouble()
                        testPersonRepository.updateInCache(p)
                    }
            }
}