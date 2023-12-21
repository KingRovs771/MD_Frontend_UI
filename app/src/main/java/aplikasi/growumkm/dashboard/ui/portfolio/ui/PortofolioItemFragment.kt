package aplikasi.growumkm.dashboard.ui.portfolio.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import aplikasi.growumkm.R


class PortofolioItemFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portofolio_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyleViewPortofolio : RecyclerView = view.findViewById(R.id.recyle_view_portofolio_item)
        recyleViewPortofolio.layoutManager = LinearLayoutManager(requireContext())
        super.onViewCreated(view, savedInstanceState)
    }


}