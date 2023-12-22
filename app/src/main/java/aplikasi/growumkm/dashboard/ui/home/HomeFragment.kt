package aplikasi.growumkm.dashboard.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import aplikasi.growumkm.R
import aplikasi.growumkm.dashboard.ui.MainViewModelFactory
import aplikasi.growumkm.dashboard.ui.home.handler.HomeAdapter
import aplikasi.growumkm.dashboard.ui.home.handler.HomeViewModel
import aplikasi.growumkm.dashboard.ui.home.handler.LoadingStateAdapter
import aplikasi.growumkm.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private  val viewModel : HomeViewModel by viewModels {
        MainViewModelFactory.getInstance(requireContext())
    }
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyleviewHome : RecyclerView
    private lateinit var imageNoItem : ImageView



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        searchItem()
        setRecyleView()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun searchItem(){
        with(binding){
            binding.searchViewHome.setupWithSearchBar(binding.searchBarHome)
            searchViewHome
                .editText
                .setOnEditorActionListener { textView, i, keyEvent -> textView
                    Toast.makeText(requireContext(),"${searchViewHome.text} : ${resources.getString(
                        R.string.not_availabel)}",Toast.LENGTH_SHORT).show()
                    true
                }
        }
    }
    private fun setRecyleView(){
        recyleviewHome = binding.recyleViewHome
        imageNoItem = binding.dataNotFound
        val adapter = HomeAdapter()
        recyleviewHome.layoutManager = LinearLayoutManager(requireContext())
        recyleviewHome.adapter = adapter.withLoadStateFooter(
            footer = LoadingStateAdapter{
                adapter.retry()
            }
        )
        viewModel.getAllDataUmkm().observe(viewLifecycleOwner){
            adapter.submitData(lifecycle,it)
        }
    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}