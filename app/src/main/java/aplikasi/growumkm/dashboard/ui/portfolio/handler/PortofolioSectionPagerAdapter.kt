package aplikasi.growumkm.dashboard.ui.portfolio.handler

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import aplikasi.growumkm.dashboard.ui.portfolio.ui.DividenFragment
import aplikasi.growumkm.dashboard.ui.portfolio.ui.PortofolioItemFragment
import aplikasi.growumkm.dashboard.ui.portfolio.ui.RiwayatFragment

class PortofolioSectionPagerAdapter(activity : Fragment) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        var fragment : Fragment? = null
        when(position){
            0 -> fragment = PortofolioItemFragment()
            1 -> fragment = DividenFragment()
            2 -> fragment = RiwayatFragment()
        }

        return fragment as Fragment
    }
}