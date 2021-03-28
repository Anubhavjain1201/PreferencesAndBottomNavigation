package com.example.learningpreferencesandbottomnavigation

import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.PreferenceManager
import com.example.learningpreferencesandbottomnavigation.databinding.FragmentFirstBinding

class FirstFragment : Fragment(), SharedPreferences.OnSharedPreferenceChangeListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onSharedPreferenceChanged(p0: SharedPreferences?, p1: String?) {

        if(p1 == "notifications"){
            Log.i("FirstFragment", "toggled")
        }
    }

    override fun onPause() {
        super.onPause()
        PreferenceManager.getDefaultSharedPreferences(this.requireContext()).registerOnSharedPreferenceChangeListener(this)
    }

    override fun onResume() {
        super.onResume()
        PreferenceManager.getDefaultSharedPreferences(this.requireContext()).unregisterOnSharedPreferenceChangeListener(this)
    }
}