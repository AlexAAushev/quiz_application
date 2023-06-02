package com.example.skillbox_hw_quiz

import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.example.skillbox_hw_quiz.databinding.FragmentThreeBinding

private const val ARG_USER_ANSWER = "userAnswer"
private var userAnswer: String? = null

class ThreeFragment : Fragment() {
    private var _binding: FragmentThreeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentThreeBinding.inflate(inflater, container, false)
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

        arguments?.let {
            userAnswer = it.getString(ARG_USER_ANSWER)
        }

        binding.buttonStartOver.setOnClickListener {
            findNavController().navigate(R.id.action_ThreeFragment_to_SecondFragment)
        }
        binding.parameter.text = userAnswer

        val button = binding.buttonStartOver
        val screen = binding.fragmentThree

        (AnimatorInflater.loadAnimator(context, R.animator.custom_animation) as ObjectAnimator)
            .apply {
                target = button
                start()
            }

        (AnimatorInflater.loadAnimator(context, R.animator.custom_animation) as ObjectAnimator)
            .apply {
                target = screen
                start()
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
