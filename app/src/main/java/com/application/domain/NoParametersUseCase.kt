package com.application.domain

import com.application.domain.scheduler.DefaultSchedulers
import com.application.domain.scheduler.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

/**
 * Base use case class with no parameters, handles the coroutine context switching
 * It also allows you to scope it to required job/context (most of the time viewmodel's)
 *
 * @param schedulers - [DefaultSchedulers] as default value,
 * to switch schedulers, pass the proper ones through the constructor
 * ```
 *    class LoginUseCase(
 *        schedulers: Schedulers,
 *        ...
 *    ) : UseCase<User, LoginUseCase.Params>(
 *        schedulers = schedulers
 *    )
 * ```
 */
abstract class NoParametersUseCase<out Type>(
    schedulers: Schedulers = DefaultSchedulers()
) where Type : Any {
    var backgroundContext: CoroutineContext = schedulers.background()
    var foregroundContext: CoroutineContext = schedulers.main()

    abstract suspend fun run(): Result<Type>

    /**
     * @see UseCase.invoke
     */
    operator fun invoke(parentJob: Job = Job(), onResult: (Result<Type>) -> Unit = {}) {
        CoroutineScope(backgroundContext + parentJob).launch {
            val result = run()
            withContext(foregroundContext) {
                onResult(result)
            }
        }
    }
}

fun <T : NoParametersUseCase<*>> T.makeUnconfined() = apply {
    backgroundContext = Dispatchers.Unconfined
    foregroundContext = Dispatchers.Unconfined
}
