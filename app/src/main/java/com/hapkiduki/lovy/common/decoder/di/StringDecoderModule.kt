package com.hapkiduki.lovy.common.decoder.di

import com.hapkiduki.lovy.common.decoder.StringDecoder
import com.hapkiduki.lovy.common.decoder.UriDecoder
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class StringDecoderModule {
    @Binds
    abstract fun bindStringDecoder(uriDecoder: UriDecoder): StringDecoder
}