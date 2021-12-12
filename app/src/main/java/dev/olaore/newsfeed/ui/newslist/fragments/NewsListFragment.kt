package dev.olaore.newsfeed.ui.newslist.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dev.olaore.newsfeed.data.common.models.Result
import dev.olaore.newsfeed.databinding.FragmentNewsListBinding
import dev.olaore.newsfeed.ui.newslist.viewmodels.NewsListViewModel

class NewsListFragment : Fragment() {

    private var _binding: FragmentNewsListBinding? = null
    val binding: FragmentNewsListBinding
        get() = _binding!!

    private val viewModel: NewsListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentNewsListBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.topHeadlines.observe(viewLifecycleOwner, {
            if (it is Result.Success) {
                Log.d("NewsListFragment", "Size of news items: ${it.data?.size}")
            }
        })

        viewModel.getTopHeadlines()

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}