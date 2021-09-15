package com.example.tmsandroid.dz.dz29

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.SimpleCursorAdapter
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.tmsandroid.R
import com.example.tmsandroid.databinding.FragmentConactListBinding

class ContactListFragment : Fragment() {

    private var _binding: FragmentConactListBinding? = null
    private val binding get() = _binding!!
    private var cols = listOf(
        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER,
        ContactsContract.CommonDataKinds.Phone._ID
    ).toTypedArray()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConactListBinding.inflate(inflater, container, false)

        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.READ_CONTACTS
            ) != PackageManager.PERMISSION_GRANTED
        )
            ActivityCompat.requestPermissions(
                requireActivity(),
                Array(1) { Manifest.permission.READ_CONTACTS },
                111
            )
        else
            readContact()

        return binding.root
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 111 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            readContact()
    }

    private fun readContact() {
        val listFrom = listOf(
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER
        ).toTypedArray()

        val listTo = intArrayOf(
            R.id.tv_contact_name,
            R.id.tv_contact_number
        )

        var resultSet = requireActivity().contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            cols,
            null,
            null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
        )

        val adapter = SimpleCursorAdapter(
            requireContext(),
            R.layout.item_contact,
            resultSet,
            listFrom,
            listTo,
            0
        )

        binding.lvContactList.adapter = adapter

        binding.searchViewContact.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                resultSet = requireActivity().contentResolver.query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    cols,
                    "${ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME} LIKE ?",
                    Array(1){"%$newText%"},
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                )
                adapter.changeCursor(resultSet)
                return false
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}