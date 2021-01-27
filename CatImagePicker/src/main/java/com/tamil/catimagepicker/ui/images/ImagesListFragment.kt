package com.tamil.catimagepicker.ui.images

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tamil.catimagepicker.ImagePicker
import com.tamil.catimagepicker.base.*
import com.tamil.catimagepicker.databinding.FragmentImageListBinding
import com.tamil.catimagepicker.di.ComponentInjection

internal class ImagesListFragment : BaseFragment() {

    private val viewModelFactory = ComponentInjection.provideViewModelFactory()
    private lateinit var binding: FragmentImageListBinding

    private val viewModel: ImageSearchViewModel by viewModels { viewModelFactory }
    private var isLoading: Boolean = false

    private val adapter = ImageListAdapter {
        val intent = Intent()
        intent.putExtra(ImagePicker.INTENT_PICK_IMAGE_KEY, it.url)
        requireActivity().setResult(Activity.RESULT_OK, intent)
        requireActivity().finish()
    }
    private var pageNo = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImageListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    // loadmore
                    loadMoreContent()
                }
            }
        })
        val layoutManager = GridLayoutManager(requireActivity(), 3)
        binding.recyclerview.layoutManager = layoutManager
        binding.recyclerview.adapter = adapter
    }


    private fun loadMoreContent() {
        if (isLoading)
            return
        viewModel.getCatImages(pageNo, pageLimit)
        isLoading = true

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadMoreContent()
        viewModel.viewState.observe(viewLifecycleOwner, {
            when (it) {
                is Success -> {
                    isLoading = false
                    pageNo++
                    adapter.submitItems(it.data)
                }
                is Error -> {
                    isLoading = false
                }
                is Loading -> {
                    isLoading = true

                }
                is NoInternetState -> {
                    isLoading = false

                }
                else -> {
                    isLoading = false
                }
            }
        })
    }

    companion object {
        private val pageLimit = 10
    }

}