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
import androidx.fragment.app.Fragment
import aplikasi.growumkm.R
import aplikasi.growumkm.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

private var _binding: FragmentProfileBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

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
    }
    private fun showDialogByClicking(contentView : Int){
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(contentView)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val buttonBack : ImageView = dialog.findViewById(R.id.btn_back_profile_global)

        buttonBack.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}