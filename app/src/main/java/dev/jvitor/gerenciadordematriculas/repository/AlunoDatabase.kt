package dev.jvitor.gerenciadordematriculas.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.jvitor.gerenciadordematriculas.models.Aluno
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [Aluno::class], version = 1)
abstract class AlunoDatabase : RoomDatabase() {

    abstract fun alunoDao() : AlunoDao

    companion object{

        private lateinit var INSTANCE: AlunoDatabase

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context) : AlunoDatabase{
            if (!::INSTANCE.isInitialized){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,
                        AlunoDatabase::class.java,
                        "alunos-db")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}