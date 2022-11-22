package com.example.storeapp.useCase

import com.example.storeapp.dataSource.Repository
import com.example.storeapp.model.MovieResponse
import kotlinx.coroutines.flow.flow

class MovieDataUseCase(private val repository: Repository) : FlowUseCase<MovieResponse?>() {
    override suspend fun performAction() = flow {
       val movie= repository.getData("api", "batman", MovieResponse::class.java)
        movie?.Search?.forEach{
            it.Title = it.Title + "  Test"
        }
        emit(movie)
    }
}