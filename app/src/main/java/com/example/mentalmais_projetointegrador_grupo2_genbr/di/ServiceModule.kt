package com.example.mentalmais_projetointegrador_grupo2_genbr.di

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    fun returnRepository(): Repository{
        return Repository()
    }
}