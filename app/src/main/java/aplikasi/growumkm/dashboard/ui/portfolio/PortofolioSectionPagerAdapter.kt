package aplikasi.growumkm.dashboard.ui.portfolio

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

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