package com.citiasia.inidesakubeta.ui.tvcc.tvccDetail

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.data.remote.model.ResponseTvcc
import com.citiasia.inidesakubeta.databinding.FragmentTvccDetailBinding
import com.citiasia.inidesakubeta.ui.ViewModelFactory
import com.citiasia.inidesakubeta.ui.adapter.TvccListAdapter
import com.citiasia.inidesakubeta.ui.adapter.TvccListPreviewAdapter
import com.citiasia.inidesakubeta.ui.tvcc.tvccHome.TvccFrontViewModel

class TvccDetailFragment : Fragment() {

    private var _binding: FragmentTvccDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: TvccDetailViewModel
    private val args : TvccDetailFragmentArgs by navArgs()

    // declaring a null variable for VideoView
    private var simpleVideoView: VideoView? = null
    // declaring a null variable for MediaController
    private var mediaControls: MediaController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTvccDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val receiveData = args.dataTvcc

        val vmFactory = ViewModelFactory(requireContext())
        viewModel = ViewModelProvider(
            requireActivity(),
            vmFactory
        ).get(TvccDetailViewModel::class.java)


        setPreviousPage()

        setUpData(receiveData, viewModel.getTvccData())
    }


    private fun setUpData(data: ResponseTvcc, listData: List<ResponseTvcc>) {
        setVideo(data.urlVideo)

        val listAdapter = TvccListAdapter(listData)
        val listPreviewAdapter = TvccListPreviewAdapter(listData)

        with(binding) {
            tvTitle.text = "TVCC ${data?.title}"

            rvListContent.layoutManager = GridLayoutManager(requireContext(), 2)
            rvListContent.adapter = listAdapter

            rvTvccPreview.layoutManager = LinearLayoutManager(requireContext())
            rvTvccPreview.adapter = listPreviewAdapter
        }

    }

    private fun setVideo(url: String) {

        simpleVideoView = binding.videoView

        if (mediaControls == null) {
            mediaControls = MediaController(requireContext())

            mediaControls!!.setAnchorView(this.simpleVideoView)
        }

        simpleVideoView!!.setMediaController(mediaControls)

        simpleVideoView!!.setVideoURI(Uri.parse(url))

        simpleVideoView!!.requestFocus()

        simpleVideoView!!.start()

        simpleVideoView!!.setOnCompletionListener {
            Toast.makeText(requireContext(), "Video completed",
                Toast.LENGTH_LONG).show()
            true
        }

        simpleVideoView!!.setOnErrorListener { mp, what, extra ->
            Toast.makeText(requireContext(), "An Error Occurred " +
                    "While Playing Video !!!", Toast.LENGTH_LONG).show()
            false
        }



//        val videoView = binding.videoView

//        val uri: Uri = Uri.parse(url)
//
//        videoView.setVideoURI(uri)
//
//        val mediaController = MediaController(requireContext())
//
//        mediaController.setAnchorView(videoView)
//        mediaController.setMediaPlayer(videoView)
//
//        videoView.setMediaController(mediaController)
//
//        // Tambahkan penanganan kesalahan
//        videoView.setOnErrorListener { mediaPlayer, what, extra ->
//            // Tangani kesalahan di sini
//            Log.e("VideoPlayer", "Error during playback - what: $what, extra: $extra")
//            return@setOnErrorListener true
//        }
//
//        videoView.setOnPreparedListener { mediaPlayer ->
//            // Callback ketika video telah siap diputar
//            videoView.start()
//        }
//
//        videoView.start()
    }

    private fun setPreviousPage() {
        requireActivity().onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().popBackStack()
                }
            })

        binding.topAppBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    companion object {
        const val TAG = "TVCC_DETAIL"
    }

}