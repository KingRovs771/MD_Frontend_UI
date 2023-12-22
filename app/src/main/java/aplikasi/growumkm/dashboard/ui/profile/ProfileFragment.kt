package aplikasi.growumkm.dashboard.ui.profile

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import aplikasi.growumkm.R
import aplikasi.growumkm.dashboard.ui.MainViewModelFactory
import aplikasi.growumkm.dashboard.ui.profile.handler.ProfileViewModel
import aplikasi.growumkm.databinding.FragmentProfileBinding
import aplikasi.growumkm.login.LoginActivity

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val profileViewModel : ProfileViewModel by viewModels {
        MainViewModelFactory.getInstance(requireContext())
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupButton()
        super.onViewCreated(view, savedInstanceState)
    }
    private fun setupButton(){
        binding.btnDataPribadi.setOnClickListener {
            showDialogByClicking(R.layout.holder_user_profile)
        }
        binding.btnMulaiUmkm.setOnClickListener {
            startActivity(Intent(requireContext(),MulaiUmkmActivity::class.java))
        }

        binding.btnTermPrivacy.setOnClickListener {
            startActivity(Intent(requireContext(),TermPolicyActivity::class.java))
        }

        binding.btnAboutUs.setOnClickListener {
            startActivity(Intent(requireContext(),AboutUs::class.java))
        }

        binding.btnLogOut.setOnClickListener {
            profileViewModel.logout()
            val myIntent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(myIntent)
            activity?.finish()
        }
    }
    private fun showDialogByClicking(contentView : Int){
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(contentView)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val buttonBack : LinearLayout = dialog.findViewById(R.id.back_dialog_profile)
        val buttonBack2 : ImageView = dialog.findViewById(R.id.btn_back_profile_global)

        buttonBack.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()

        buttonBack2.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}