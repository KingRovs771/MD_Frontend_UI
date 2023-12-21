package aplikasi.growumkm.dashboard.ui.detail.handler

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import aplikasi.growumkm.dashboard.ui.detail.DescriptionFragment
import aplikasi.growumkm.dashboard.ui.detail.DocumentFragment
import aplikasi.growumkm.dashboard.ui.detail.RatingFragment

class DetailSectionPagerAdapter(activity : AppCompatActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        var fragment : Fragment? = null
        when(position){
            0 -> fragment = DescriptionFragment()
            1 -> fragment = DocumentFragment()
            2 -> fragment = RatingFragment()
        }
        return  fragment as Fragment
    }
}