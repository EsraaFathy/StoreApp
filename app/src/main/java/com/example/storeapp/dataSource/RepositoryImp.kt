package com.example.storeapp.dataSource

import com.example.storeapp.dataSource.remote.RemoteDataSource

class RepositoryImp(override val remoteDataSource: RemoteDataSource) : Repository {


    override suspend fun <T : Any> getData(path: String, query: String, ofClass: Class<T>): T? {
     return  remoteDataSource.fetchData(path,query,ofClass)
    }
}