package aplikasi.growumkm.dashboard.ui.home.handler

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import aplikasi.data.api.UmkmData
import aplikasi.growumkm.dashboard.ui.detail.DetailActivity
import aplikasi.growumkm.databinding.HomeDetailHolderBinding
import aplikasi.growumkm.util.formatAngkaJuta
import aplikasi.growumkm.util.getRupiahFormat
import com.bumptech.glide.Glide

class HomeAdapter : PagingDataAdapter<UmkmData,HomeAdapter.Holder>(DIFF_CALLBACK) {



    override fun onBindViewHolder(holder: HomeAdapter.Holder, position: Int) {
        val data = getItem(position)
        val name = data?.namaUmkm
        val urlImg = data?.img
        val danaTerkumpul = data?.investAmount
        val targetInvestasi = data?.trgtInvest

        holder.bind(urlImg!!,name!!,danaTerkumpul,targetInvestasi)

        holder.binding.dataItemHome.setOnClickListener {
            val intent = Intent(it.context,DetailActivity::class.java)
            intent.putExtra("ID_UMKM",data.idUmkm)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.Holder {
        val binding = HomeDetailHolderBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }


    class Holder(val binding: HomeDetailHolderBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(urlImg : String, nameUmkm : String, danaTerkumpul : Int?, targetInvestasi : Int?){
            binding.umkmName.text = nameUmkm
            Glide.with(binding.root).load(urlImg).into(binding.roundedImageView)
            binding.danaTerkumpul.text = getRupiahFormat(danaTerkumpul ?: 0)
            binding.target.text = formatAngkaJuta(targetInvestasi ?: 1000000)

        }
    }
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<UmkmData>() {
            override fun areItemsTheSame(oldItem: UmkmData, newItem: UmkmData): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: UmkmData, newItem: UmkmData): Boolean {
                return oldItem.idUser == newItem.idUser
            }
        }
    }

}