package aplikasi.growumkm.dashboard.ui.detail

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import aplikasi.growumkm.R
import aplikasi.growumkm.databinding.FragmentDocumentBinding
import aplikasi.growumkm.databinding.FragmentHomeBinding


class DocumentFragment : Fragment() {


    private var _binding: FragmentDocumentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDocumentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnDetailVideo.setOnClickListener {
            startActivity(Intent(requireContext(),VideoActivity::class.java))
        }

        binding.btnLaporanDetail.setOnClickListener {
            startActivity(Intent(requireContext(),DocumentActivity::class.java))
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}