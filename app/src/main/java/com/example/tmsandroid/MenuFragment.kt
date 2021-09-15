package com.example.tmsandroid

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tmsandroid.databinding.FragmentMenuBinding
import com.example.tmsandroid.dz.dz14.Dz14Fragment
import com.example.tmsandroid.dz.dz15.Dz15Fragment
import com.example.tmsandroid.dz.dz16.Dz16Fragment
import com.example.tmsandroid.dz.dz17.Dz17Fragment
import com.example.tmsandroid.dz.dz18.Dz18Fragment
import com.example.tmsandroid.dz.dz19.Dz19Fragment
import com.example.tmsandroid.dz.dz20.Dz20Fragment
import com.example.tmsandroid.dz.dz21.Dz21Fragment
import com.example.tmsandroid.dz.dz22.Dz22Fragment
import com.example.tmsandroid.dz.dz23.Dz23Fragment
import com.example.tmsandroid.dz.dz24.Dz24Fragment
import com.example.tmsandroid.dz.dz25.Dz25Fragment
import com.example.tmsandroid.dz.dz26.Dz26Activity
import com.example.tmsandroid.dz.dz26alt.WordActivity
import com.example.tmsandroid.dz.dz27.MemeListFragment
import com.example.tmsandroid.dz.dz28.BlurFragment
import com.example.tmsandroid.dz.dz29.ContactListFragment
import com.example.tmsandroid.dz.scorebat.MatchListFragment

class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            bDz14.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in_right,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.slide_out_right
                    )
                    .addToBackStack(null)
                    .replace(R.id.container, Dz14Fragment())
                    .commit()
            }

            bDz15.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in_right,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.slide_out_right
                    )
                    .addToBackStack(null)
                    .replace(R.id.container, Dz15Fragment())
                    .commit()
            }

            bDz16.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in_right,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.slide_out_right
                    )
                    .addToBackStack(null)
                    .replace(R.id.container, Dz16Fragment())
                    .commit()
            }

            bDz17.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in_right,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.slide_out_right
                    )
                    .addToBackStack(null)
                    .replace(R.id.container, Dz17Fragment())
                    .commit()
            }

            bDz18.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in_right,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.slide_out_right
                    )
                    .addToBackStack(null)
                    .replace(R.id.container, Dz18Fragment())
                    .commit()
            }

            bDz19.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in_right,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.slide_out_right
                    )
                    .addToBackStack(null)
                    .replace(R.id.container, Dz19Fragment())
                    .commit()
            }

            bDz20.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in_right,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.slide_out_right
                    )
                    .addToBackStack(null)
                    .replace(R.id.container, Dz20Fragment())
                    .commit()
            }

            bDz21.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in_right,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.slide_out_right
                    )
                    .addToBackStack(null)
                    .replace(R.id.container, Dz21Fragment())
                    .commit()
            }

            bDz22.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in_right,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.slide_out_right
                    )
                    .addToBackStack(null)
                    .replace(R.id.container, Dz22Fragment())
                    .commit()
            }

            bDz23.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in_right,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.slide_out_right
                    )
                    .addToBackStack(null)
                    .replace(R.id.container, Dz23Fragment())
                    .commit()
            }

            bDz24.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in_right,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.slide_out_right
                    )
                    .addToBackStack(null)
                    .replace(R.id.container, Dz24Fragment())
                    .commit()
            }
            
            bDz25.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in_right,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.slide_out_right
                    )
                    .addToBackStack(null)
                    .replace(R.id.container, Dz25Fragment())
                    .commit()
            }
            
            bDz26.setOnClickListener {
                val intent = Intent(context, Dz26Activity::class.java)
                startActivity(intent)
            }

            bDz26Alt.setOnClickListener {
                val intent = Intent(context, WordActivity::class.java)
                startActivity(intent)
            }

            bDz27.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, MemeListFragment())
                    .commit()
            }

            bDz27Alt.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, MatchListFragment())
                    .commit()
            }
            
            bDz28.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, BlurFragment())
                    .commit()
            }
            
            bDz29.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, ContactListFragment())
                    .commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}