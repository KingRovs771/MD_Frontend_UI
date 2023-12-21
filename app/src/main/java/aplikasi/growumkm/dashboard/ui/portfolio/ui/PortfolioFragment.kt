package aplikasi.growumkm.dashboard.ui.portfolio.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import aplikasi.growumkm.dashboard.ui.portfolio.handler.PortfolioViewModel
import aplikasi.growumkm.dashboard.ui.portfolio.handler.PortofolioSectionPagerAdapter
import aplikasi.growumkm.databinding.FragmentPortfolioBinding
import com.google.android.material.tabs.TabLayoutMediator

class PortfolioFragment : Fragment() {

private var _binding: FragmentPortfolioBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val dashboardViewModel =
            ViewModelProvider(this).get(PortfolioViewModel::class.java)

    _binding = FragmentPortfolioBinding.inflate(inflater, container, false)
    val root: View = binding.root

    return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val tabLayout = binding.tabLayoutPortofolio
        val viewPager = binding.portoViewPager
        val adapter = PortofolioSectionPagerAdapter(requireParentFragment())
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout,viewPager){ tab, position ->
            tab.text =  TAB_TITLES[position]
        }.attach()

        binding.btnPortoDeposit.setOnClickListener {
            startActivity(Intent(requireContext(), DepositActivity::class.java))
        }



        super.onViewCreated(view, savedInstanceState)
    }
override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object{

        private val TAB_TITLES = arrayOf(
            "Portofolio",
            "Dividen",
            "Riwayat"
        )
    }
}