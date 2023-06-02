package com.example.skillbox_hw_quiz

import android.app.ActivityOptions
import android.app.ActivityOptions.makeSceneTransitionAnimation
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.app.ActivityOptionsCompat.makeSceneTransitionAnimation
import androidx.fragment.app.FragmentTransitionImpl
import androidx.navigation.fragment.findNavController
import com.example.skillbox_hw_quiz.databinding.FragmentFirstBinding
import kotlinx.coroutines.delay

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation? {
        return if (enter) {
            AnimationUtils.loadAnimation(context, R.anim.fade_in)
        } else {
            AnimationUtils.loadAnimation(context, R.anim.slide_one)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonStart.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}