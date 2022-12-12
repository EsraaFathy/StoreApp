package com.example.storeapp.data.repo

import com.example.storeapp.data.remote.RemoteDataSource
import com.example.storeapp.domain.repo.Repository

class RepositoryImp( val remoteDataSource: RemoteDataSource) : Repository {

    override suspend fun <T> getData(path: String, query: String, ofClass: Class<T>): T? {
        return  remoteDataSource.fetchData(path,query,ofClass)
    }
}