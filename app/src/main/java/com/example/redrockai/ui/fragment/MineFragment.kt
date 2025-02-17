package com.example.redrockai.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.redrockai.R
import com.example.redrockai.databinding.FragmentMineBinding
import com.example.redrockai.lib.utils.adapter.FragmentVpAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MineFragment : Fragment() {

    private var _mBinding: FragmentMineBinding? = null
    private val mBinding get() = _mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _mBinding = FragmentMineBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _mBinding = null
    }


}