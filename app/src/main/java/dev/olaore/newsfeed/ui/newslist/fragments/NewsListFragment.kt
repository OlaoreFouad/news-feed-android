package dev.olaore.newsfeed.ui.newslist.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dev.olaore.newsfeed.data.common.models.Result
import dev.olaore.newsfeed.data.models.newslist.domain.DomainNewsItem
import dev.olaore.newsfeed.data.models.newslist.remote.NewsItem
import dev.olaore.newsfeed.databinding.FragmentNewsListBinding
import dev.olaore.newsfeed.ui.newslist.adapters.NewsItemAdapter
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
            binding.isLoading = it is Result.Loading
            when (it) {
                is Result.Success -> {
                    this.setupList(it.data!!)
                }
                is Result.Error -> {
                    Toast.makeText(requireContext(), "Error Occurred: " + it.message, Toast.LENGTH_LONG).show()
                }
            }
        })

        viewModel.getTopHeadlines()

    }

    private fun setupList(items: List<DomainNewsItem>) {
        val newsItemAdapter = NewsItemAdapter(items)
        binding.newsList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = newsItemAdapter
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}