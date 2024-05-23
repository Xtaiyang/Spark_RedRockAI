package com.example.redrockai.module.schoolroom.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.redrockai.module.schoolroom.bean.RelatedCategoryBean
import com.example.redrockai.module.schoolroom.bean.SentenceBean
import com.example.redrockai.module.schoolroom.net.SchoolRoomNet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

/**
 * @Author      : Severus (Li XiaoHui)
 * @Email       : 1627812101@qq.com
 * @Date        : on 2024-05-23 00:19.
 * @Description : 生活很难，但总有人在爱你。
 */
class SentenceViewModel() : ViewModel() {
    private val _sentenceData = MutableLiveData<SentenceBean>()
    val sentenceData: LiveData<SentenceBean> get() = _sentenceData

    fun getSentence() {
        viewModelScope.launch {
            flow {
                val list = SchoolRoomNet.getSentence()
                emit(list)
            }.flowOn(Dispatchers.IO)
                .catch { e ->
                    e.printStackTrace()
                    Log.d("hui", "getSentence:${e} ")
                }
                .collect {
                    _sentenceData.value = it
                }
        }
    }
}