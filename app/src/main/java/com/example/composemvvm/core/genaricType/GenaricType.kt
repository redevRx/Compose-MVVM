package com.example.composemvvm.core.genaricType

class Hero<T>(internal val value: Any?, internal val isError:Boolean){

    companion object {
        inline fun <T> success(value:T):Hero<T> = Hero(value,false)
        inline fun <T> failed(exception: Throwable):Hero<T> = Hero(exception,true)
    }
}

internal inline fun <T> Hero<T>.ok(success:(data:T) -> Unit):Hero<T>{
    if(!isError) success(value as T)
    return this
}

internal inline fun <T> Hero<T>.not(error:(ex:Throwable) -> Unit):Hero<T>{
   if(isError) error(value as Throwable)
    return this
}

inline fun <R> snakeHero(block: () -> R):Hero<R>{
    return try {
        Hero.success(block())
    }catch (ex: Throwable){
        Hero.failed(ex)
    }
}

inline fun <T,R> T.snakeHero(block: T.() -> R):Hero<R>{
    return try {
        Hero.success(block())
    } catch (ex: Throwable){
        Hero.failed(ex)
    }
}
