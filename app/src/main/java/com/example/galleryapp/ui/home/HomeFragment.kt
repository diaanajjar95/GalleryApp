package com.example.galleryapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.galleryapp.data.models.Hit
import com.example.galleryapp.databinding.FragmentHomeBinding
import com.example.galleryapp.ui.base.BaseFragment
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModel()
    private val imagesAdapter: ImagesAdapter by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.title = "Home"
        binding.imagesRc.apply {
            adapter = imagesAdapter
        }

        imagesAdapter.setOnItemClickListener(object :
            ImagesAdapter.OnItemClickListener {
            override fun onItemClicked(view: View, item: Hit, position: Int) {
//                val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(item)
//                findNavController().navigate(action)
            }
        })

        viewModel.images.observe(viewLifecycleOwner) {
            imagesAdapter.clear()
            imagesAdapter.setItems(it)
        }

        viewModel.loading.observe(viewLifecycleOwner) {
            showProgress(it)
        }

        viewModel.message.observe(viewLifecycleOwner) {
            showMessage(it)
        }

        viewModel.getImages()

    }

}