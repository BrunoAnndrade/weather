package com.example.weather

import android.location.Location
import com.example.weather.Domain.DepedencyInjection.LocationModule
import com.example.weather.Domain.Location.DefaultLocationTracker
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class LocationModuleTest {

    @ExperimentalCoroutinesApi
    @Test
    fun `bindLocationTracker binds DefaultLocationTracker to LocationTracker`() {
        // Mock da implementação de DefaultLocationTracker
        val mockDefaultLocationTracker = mockk<DefaultLocationTracker>()

        // Criação de uma instância de LocationModule para teste
        val locationModule = object : LocationModule() {}

        // Chamada do método que será testado
        val locationTracker = locationModule.bindLocationTracker(mockDefaultLocationTracker)

        // Verifica se o método foi chamado corretamente e com os parâmetros corretos
        verify { locationModule.bindLocationTracker(mockDefaultLocationTracker) }

        // Você também pode adicionar mais verificações, se necessário
    }
}