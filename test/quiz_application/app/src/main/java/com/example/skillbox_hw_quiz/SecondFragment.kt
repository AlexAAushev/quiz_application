package com.example.skillbox_hw_quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import androidx.navigation.fragment.findNavController
import com.example.skillbox_hw_quiz.databinding.FragmentSecondBinding
import com.example.skillbox_hw_quiz.quiz.QuizStorage
import android.view.animation.AnimationUtils


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    private val quiz = QuizStorage.getQuiz(QuizStorage.Locale.Ru)
    private val questionsList = quiz.questions
    private var answers = mutableListOf<Int>()
    var userAnswer = " "

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        val element = binding.radioGroupOne
        val fadeIn = AnimationUtils.loadAnimation(context, R.anim.fade_in)
        element.startAnimation(fadeIn)

        val elementTwo = binding.radioGroupTwo
        val fadeInTwo = AnimationUtils.loadAnimation(context, R.anim.fade_in_2)
        elementTwo.startAnimation(fadeInTwo)

        val elementThree = binding.radioGroupThree
        val fadeInThree = AnimationUtils.loadAnimation(context, R.anim.fade_in_3)
        elementThree.startAnimation(fadeInThree)

        return binding.root
    }

    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation? {
        return if (enter) {
            AnimationUtils.loadAnimation(context, R.anim.fade_in)
        }else{
            AnimationUtils.loadAnimation(context, R.anim.slide_one)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonBack.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)

        }

        binding.buttonSend.setOnClickListener {
            userAnswer = QuizStorage.answer(QuizStorage.getQuiz(QuizStorage.Locale.Ru), answers)
            var bundle = Bundle().apply {
                putString("userAnswer", userAnswer)

            }
            findNavController().navigate(R.id.action_SecondFragment_to_ThreeFragment, bundle)

        }

        binding.askOne.text = questionsList[0].question
        binding.radioButtonOne1.text = questionsList[0].answers[0]
        binding.radioButtonOne2.text = questionsList[0].answers[1]
        binding.radioButtonOne3.text = questionsList[0].answers[2]
        binding.radioButtonOne4.text = questionsList[0].answers[3]

        binding.askTwo.text = questionsList[1].question
        binding.radioButtonTwo1.text = questionsList[1].answers[0]
        binding.radioButtonTwo2.text = questionsList[1].answers[1]
        binding.radioButtonTwo3.text = questionsList[1].answers[2]
        binding.radioButtonTwo4.text = questionsList[1].answers[3]

        binding.askThree.text = questionsList[2].question
        binding.radioButtonThree1.text = questionsList[2].answers[0]
        binding.radioButtonThree2.text = questionsList[2].answers[1]
        binding.radioButtonThree3.text = questionsList[2].answers[2]
        binding.radioButtonThree4.text = questionsList[2].answers[3]

        binding.radioGroupOne.setOnCheckedChangeListener { _, buttonId ->
            when (buttonId) {
                R.id.radio_button_one_1 -> answers.add(0)
                R.id.radio_button_one_2 -> answers.add(1)
                R.id.radio_button_one_3 -> answers.add(2)
                R.id.radio_button_one_4 -> answers.add(3)
            }

        }

        binding.radioGroupTwo.setOnCheckedChangeListener { _, buttonId ->
            when (buttonId) {
                R.id.radio_button_two_1 -> answers.add(0)
                R.id.radio_button_two_2 -> answers.add(1)
                R.id.radio_button_two_3 -> answers.add(2)
                R.id.radio_button_two_4 -> answers.add(3)
            }
        }

        binding.radioGroupThree.setOnCheckedChangeListener { _, buttonId ->
            when (buttonId) {
                R.id.radio_button_three_1 -> answers.add(0)
                R.id.radio_button_three_2 -> answers.add(1)
                R.id.radio_button_three_3 -> answers.add(2)
                R.id.radio_button_three_4 -> answers.add(3)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}